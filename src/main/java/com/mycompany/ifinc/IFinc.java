/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ifinc;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.mycompany.views.Login;

/**
 *
 * @author HP
 */
public class IFinc {

    public static void main(String[] args) {
         FlatMaterialLighterIJTheme.setup();
        
        Login login = new Login();
        login.setVisible(true);
    }
}
