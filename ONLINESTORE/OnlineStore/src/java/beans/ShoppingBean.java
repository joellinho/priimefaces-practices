package beans;

import dao.ComprasDAO;
import dao.ComprasTO;
import dao.ProductosDAO;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class ShoppingBean implements java.io.Serializable {

    public int obtenerCod_categoria() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return (Integer) session.getAttribute("cod_categoria");
    }

    public String establecerCod_categoria(int cod_categoria) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("cod_categoria", cod_categoria);
        return "subcategoria_productos?faces-redirect=true";
    }

    public int obtenerSubCategoria() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return (Integer) session.getAttribute("cod_sub_categoria");
    }

    public String establecerSubCategoria(int cod_categoria) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("cod_sub_categoria", cod_categoria);
        return "lista_de_productos?faces-redirect=true";
    }

    public List<ProductoBean> getBanner() {
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        try {
            ProductosDAO dao = new ProductosDAO();
            lista = dao.getBanner();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public List<ProductoBean> getNuevosProductos() {
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        try {
            ProductosDAO dao = new ProductosDAO();
            lista = dao.getNuevosProductos();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public List<ProductoBean> getIndexProductos() {
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        try {
            ProductosDAO dao = new ProductosDAO();
            lista = dao.getIndexProductos();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public List<CategoriaBean> getCategorias() {
        List<CategoriaBean> lista = new ArrayList<CategoriaBean>();
        try {
            ProductosDAO dao = new ProductosDAO();
            lista = dao.getCategorias();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public List<SubCategoriaBean> getSubCategoriasPorCategoria() {
        List<SubCategoriaBean> lista = new ArrayList<SubCategoriaBean>();
        try {
            ProductosDAO dao = new ProductosDAO();
            lista = dao.getSubCategoriaPorCategoria(this.obtenerCod_categoria());
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public List<ProductoBean> getProductosPorSubCategoria() {
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        try {
            ProductosDAO dao = new ProductosDAO();
            lista = dao.getProductosPorSubCategoria(this.obtenerSubCategoria());
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public List<ProductoBean> getThreeOfertas() {
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        try {
            ProductosDAO dao = new ProductosDAO();
            lista = dao.getThreeOfertas();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public List<ProductoBean> getNueveOfertas() {
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        try {
            ProductosDAO dao = new ProductosDAO();
            lista = dao.getNueveOfertas();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public String addToCart(int cod_producto, int cantidad) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CartItemBean> carrito = (List<CartItemBean>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<CartItemBean>();
        }
        ProductoBean producto;
        try {
            producto = new ProductosDAO().consultarDetalles(cod_producto);
        } catch (Exception e) {
            producto = null;
        }

        CartItemBean item = new CartItemBean();
        item.setCod_producto(cod_producto);
        item.setImg_producto(producto.getImg_producto());
        item.setNom_producto(producto.getNom_producto());
        if ("SI".equalsIgnoreCase(producto.getOferta())) {
            item.setPrecio(producto.getPrecio_oferta());
        } else {
            item.setPrecio(producto.getPrecio_normal());
        }
        //Si el item existe
        int index01;
        if ((index01 = itemExiste(cod_producto)) != -1) {
            CartItemBean itemEnCarrito01 = carrito.get(index01);
            int cantidad01 = itemEnCarrito01.getCantidad();
            item.setCantidad(cantidad + cantidad01);
            removeToCart(index01);
        } else {
            item.setCantidad(cantidad);
        }
        item.calcularTotal();
        carrito.add(item);
        session.setAttribute("carrito", carrito);
        return "carrito?faces-redirect=true";
    }

    /**
     * Método que verifica si existe o no un item, pasado como parámetro, en el
     * carrito. Si existe retorna el indice de dicho item, caso contrario
     * retornará -1.
     *
     * @param cod_producto codigo del producto.
     */
    private int itemExiste(int cod_producto) {
        int index = 0;
        List<CartItemBean> carrito = getCarrito();
        for (CartItemBean item : carrito) {
            if (cod_producto == item.getCod_producto()) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void removeToCart(int index) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CartItemBean> carrito = getCarrito();
        carrito.remove(index);
        session.setAttribute("carrito", carrito);
    }

    public List<CartItemBean> getCarrito() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CartItemBean> carrito = (List<CartItemBean>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<CartItemBean>();
        }
        return carrito;
    }

    public double getTotalCarrito() {
        List<CartItemBean> carrito = getCarrito();
        double total = 0.0;
        if (carrito == null) {
            return 0;
        }
        for (CartItemBean item : carrito) {
            total += item.getTotal();
        }
        return total;
    }

    private double dosDecimales(double valor) {
        try {
            String valStr = Double.toString(valor);
            int x = valStr.indexOf(".");
            valStr = valStr.substring(0, x + 3);
            return Double.parseDouble(valStr);
        } catch (Exception e) {
            return 0;
        }


    }

    public double getIGV() {
        double total = this.getTotalCarrito();
        double porc = 0.19;
        double igv = total * porc;
        return dosDecimales(igv);
    }

    public double getNeto() {
        double neto = this.getTotalCarrito() + this.getIGV();
        return dosDecimales(neto);
    }

    public String registrarPedido(int cod_cliente) {
        ComprasTO compra = new ComprasTO();
        compra.setCod_cliente(cod_cliente);
        //Definir fecha: formato: 04:31 p.m. 18/07/2012
        DateFormatSymbols dateSymbols = new DateFormatSymbols();
        dateSymbols.setAmPmStrings(new String[]{"a.m.", "p.m."});
        SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm a dd/MM/yyyy", dateSymbols);
        compra.setFecha(formatoFecha.format(new Date()));
        compra.setTotal_neto(this.getNeto());
        try {
            if (carritoEstaVacio()) {
                throw new Exception("El carrito de compras esta vacío.");
            }
            ComprasDAO dao = new ComprasDAO();
            dao.registrarCompra(compra);
            vaciarCarrito();
            return "pedido_registrado";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "error";
        }
    }

    public String vaciarCarrito() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CartItemBean> carrito = new ArrayList<CartItemBean>();
        session.setAttribute("carrito", carrito);
        return "carrito";
    }

    private boolean carritoEstaVacio() {
        boolean flag;
        List<CartItemBean> carrito = getCarrito();
        if (carrito == null) {
            flag = true;
        } else if (carrito.isEmpty()) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void toEnglish() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
        FacesContext.getCurrentInstance().getApplication().setDefaultLocale(new Locale("en"));
    }

    public void toSpanish() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
        FacesContext.getCurrentInstance().getApplication().setDefaultLocale(new Locale("es"));
    }
}
