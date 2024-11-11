package es.uco.pw.display;
import java.time.LocalDate;

import es.uco.pw.business.jugador.JugadorDTO;
//Esto lo he hecho para hacer pruebas, luego lo borraremos
import es.uco.pw.data.dao.gestordeusuariosDAO;

public class pruebecilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gestordeusuariosDAO usuariodao = new gestordeusuariosDAO();
		JugadorDTO p = new JugadorDTO("Juan","Perez Lopez",LocalDate.parse("2000-05-29"),"Juanito@gmail.com","2432346a");
		usuariodao.addJugador(p);
	}

}
