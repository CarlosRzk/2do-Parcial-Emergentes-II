package com.emergentes.dao;

import com.emergentes.modelo.Formulario;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormularioDAOimp extends ConexionBD implements FormularioDAO {

    @Override
    public void insert(Formulario formulario) throws Exception {
        String sql = "insert into formularios(nombres,apellidos,seminario,confirmados,fechainscripcion) values (?,?,?,?,?))";
        try{
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,formulario.getNombres());
        ps.setString(2,formulario.getApellidos());
        ps.setString(3,formulario.getSeminario());
        ps.setInt(4,formulario.getConfirmados());
        ps.setString(5,formulario.getFechainscripcion());
        ps.executeUpdate();
    
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Formulario formulario) throws Exception {
        String sql = "update formularios set nombres=?,apellidos=?, seminario=?, confirmados=?, fechainscripcion=? where id=?";
        try{
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,formulario.getNombres());
        ps.setString(2,formulario.getApellidos());
        ps.setString(3,formulario.getSeminario());
        ps.setInt(4,formulario.getConfirmados());
        ps.setString(5,formulario.getFechainscripcion());
        ps.setInt(3,formulario.getId());
        ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from formularios where id=?";
        try{
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Formulario> getAll() throws Exception {
        List<Formulario> lista = null;
        String sql = "select * from formularios";
        try {
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Formulario>();
        while(rs.next()){
            Formulario avi = new Formulario();
            avi.setId(rs.getInt("id"));
            avi.setNombres(rs.getString("nombres"));
            avi.setApellidos(rs.getString("apellidos"));
            avi.setSeminario(rs.getString("seminario"));
            avi.setConfirmados(rs.getInt("confirmados"));
            avi.setFechainscripcion(rs.getString("fechainscripcion"));
            
            lista.add(avi);
        }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public Formulario getById(int id) throws Exception {
        Formulario avi = new Formulario();
        try{
            this.conectar();
            String sql = "select * from formularios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setNombres(rs.getString("titulo"));
                avi.setApellidos(rs.getString("apellidos"));
                avi.setSeminario(rs.getString("seminario"));
                avi.setConfirmados(rs.getInt("confirmados"));
                avi.setFechainscripcion(rs.getString("fechainscripcion"));
        }
        } catch (SQLException e){
            throw e;
        } finally{
            this.desconectar(); 
        }
        return avi;
        
        
        
    }
    
}
