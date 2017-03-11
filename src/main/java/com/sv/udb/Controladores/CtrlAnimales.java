/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Controladores;

import com.sv.udb.Modelo.Animales;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class CtrlAnimales {
   public boolean guar(Animales obj)
   {
   boolean resp = false;
   Connection con = new Conexion().getConn();
       try 
       {
           PreparedStatement cmd = con.prepareStatement("Insert into seresvivos values(null,?,?,?)");
           cmd.setString(1,obj.getNomb_sere());
           cmd.setString(2,obj.getDesc_sere());
           cmd.setInt(3,obj.getCodi_sere_refe());
           cmd.executeUpdate();
           resp=true;
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, "Error:"+e.getMessage());
       }
   return resp;
   }
     public boolean actu(Animales obj)
   {
   boolean resp = false;
   Connection con = new Conexion().getConn();
       try 
       {
           PreparedStatement cmd = con.prepareStatement("update seresvivos set nomb_sere=? , desc_sere=?, codi_refe_sere=? "
           + "where codi_sere=?");
           cmd.setString(1,obj.getNomb_sere());
           cmd.setString(2,obj.getDesc_sere());
           cmd.setInt(3,obj.getCodi_sere_refe());
           cmd.setInt(4,obj.getCodi_sere());
           cmd.executeUpdate();
           resp=true;
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
   return resp;
   }
      public boolean elim(Animales obj)
   {
   boolean resp = false;
   Connection con = new Conexion().getConn();
       try 
       {
           PreparedStatement cmd = con.prepareStatement("delete from seresvivos where codi_sere = ?");
           cmd.setInt(1,obj.getCodi_sere());
           cmd.executeUpdate();
           resp=true;
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
   return resp;
   }
      public List<Animales> vertodo()
      {
      List <Animales>  resp = new ArrayList<>();    
      Connection con = new Conexion().getConn();
          try 
          {
         PreparedStatement cmd = con.prepareStatement("SELECT s2.nomb_sere,s2.desc_sere, s1.nomb_sere 'PERTENECE A' , s2.codi_sere FROM seresvivos s1\n" +
"        RIGHT JOIN seresvivos s2 on s1.codi_sere = s2.codi_refe_sere\n" +
"        ORDER BY s1.codi_sere");
         ResultSet rs = cmd.executeQuery();
         while(rs.next())
         {
         resp.add(new Animales (rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
         }
          } 
          catch (Exception e) 
          {
          JOptionPane.showMessageDialog(null, e.getMessage());
          }
      return resp;
      }
       public List<Animales> combox()
      {
      List <Animales>  resp = new ArrayList<>();    
      Connection con = new Conexion().getConn();
          try 
          {
         PreparedStatement cmd = con.prepareStatement("SELECT* from seresvivos");
         ResultSet rs = cmd.executeQuery();
         while(rs.next())
         {
         resp.add(new Animales (rs.getInt(1),rs.getString(2),rs.getString(3)));
         }
          } 
          catch (Exception e) 
          {
          JOptionPane.showMessageDialog(null, e.getMessage());
          }
      return resp;
      }
}
