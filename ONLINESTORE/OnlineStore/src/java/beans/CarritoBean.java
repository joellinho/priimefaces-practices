package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CarritoBean {

    private List<CartItemBean> lista;

    public CarritoBean() {
    }

    public List<CartItemBean> getLista() {
        return lista;
    }

    public void addItem(CartItemBean item) {
        lista.add(item);
    }
}
