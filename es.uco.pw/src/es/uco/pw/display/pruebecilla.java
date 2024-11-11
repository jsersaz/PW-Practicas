package es.uco.pw.display;
import es.uco.pw.business.jugador.JugadorDTO;
//Esto lo he hecho para hacer pruebas, luego lo borraremos
import es.uco.pw.data.dao.gestordeusuariosDAO;

public class pruebecilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gestordeusuariosDAO usuariodao = new gestordeusuariosDAO();
		JugadorDTO p = new JugadorDTO();
		usuariodao.addJugador(p);
	}

}
