/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author admin-joel
 */
@ManagedBean
public class ThemeChoices {
public static final String[] POSSIBLE_THEMES =
{ "afterdark", "afternoon", "afterwork", "aristo", 
"black-tie", "blitzer", "bluesky", "casablanca",
"cruze", "cupertino", "dark-hive", "dot-luv",
"eggplant", "excite-bike", "flick", "glass-x",
"home", "hot-sneaks", "humanity", "le-frog",
"midnight", "mint-choc", "overcast", "pepper-grinder",
"redmond", "rocket", "sam", "smoothness",
"south-street", "start", "sunny", "swanky-purse",
"trontastic", "twitter bootstrap", "ui-darkness", 
"ui-lightness", "vader" };
public String[] getThemes() {
return(POSSIBLE_THEMES);
}
}