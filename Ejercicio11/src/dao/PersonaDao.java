package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Persona;
import exception.AppDaoException;

public class PersonaDao extends BaseDao {
	public PersonaDao() {
		super();
	}

	public List<Persona> obtenerTodos() {
		List<Persona> listaPersonas = null;
		String sql = "SELECT * FROM persona";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (listaPersonas == null)
					listaPersonas = new ArrayList<Persona>();

				Persona p = new Persona(rs.getString("nombre"),
						rs.getString("apellido"));
				p.setAltura(rs.getFloat("altura"));
				p.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				p.setId(rs.getInt("id"));

				listaPersonas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppDaoException(e);
		}

		return listaPersonas;
	}

	public void agregar(Persona p) {
		String sql = "INSERT INTO persona(nombre, apellido, altura, fechaNacimiento) "
				+ "VALUES(?, ?, ?, ?)";

		
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getNombre());
			pstmt.setString(2, p.getApellido());
			pstmt.setFloat(3, p.getAltura());
			pstmt.setDate(4, new java.sql.Date(
					p.getFechaNacimiento().getTime()));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppDaoException(e);
		}
	}

	public Persona obtener(Integer id) {
		Persona p = null;
		String sql = "SELECT * FROM persona WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				p = new Persona(rs.getString("nombre"),
						rs.getString("apellido"));
				p.setAltura(rs.getFloat("altura"));
				p.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				p.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppDaoException(e);
		}

		return p;
	}

	public void modificar(Persona p) {
		String sql = "UPDATE persona SET " + 
				"nombre = ?, apellido = ?, altura = ?, " +  
				"fechaNacimiento = ? WHERE id = ?";

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getNombre());
			pstmt.setString(2, p.getApellido());
			pstmt.setFloat(3, p.getAltura());
			pstmt.setDate(4, new java.sql.Date(
					p.getFechaNacimiento().getTime()));
			pstmt.setInt(5, p.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppDaoException(e);
		}
	}

	public void eliminar(Integer id) {
		String sql = "DELETE FROM persona WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppDaoException(e);
		}
	}
}
