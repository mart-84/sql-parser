package fr.martinbonnefoy.sql.parser.exceptions;

public class InvalidTokenException extends Exception {

	public InvalidTokenException() {
		super("Erreur lors de la tokenization : Token invalide trouvé.");
	}

	public InvalidTokenException(String message) {
		super(message);
	}

}
