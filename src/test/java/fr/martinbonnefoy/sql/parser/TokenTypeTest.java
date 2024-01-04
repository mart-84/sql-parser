package fr.martinbonnefoy.sql.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TokenTypeTest {

	@Test
	void testEnumElementsNotNull() {
		assertNotNull(TokenType.SELECT);
		assertNotNull(TokenType.FROM);
		assertNotNull(TokenType.WHERE);
		assertNotNull(TokenType.DISTINCT);
		assertNotNull(TokenType.AS);
		assertNotNull(TokenType.AND);
		assertNotNull(TokenType.OR);
		assertNotNull(TokenType.COMMA);
		assertNotNull(TokenType.DOT);
		assertNotNull(TokenType.STAR);
		assertNotNull(TokenType.SEMICOLON);
		assertNotNull(TokenType.OPEN_PAREN);
		assertNotNull(TokenType.CLOSE_PAREN);
		assertNotNull(TokenType.COMPARISON_OP);
		assertNotNull(TokenType.IDENTIFIER);
		assertNotNull(TokenType.NUMERIC_LIT);
		assertNotNull(TokenType.STRING_LIT);
	}

	@Test
	void testEnumElementsValues() {
		assertEquals("SELECT", TokenType.SELECT.toString());
		assertEquals("FROM", TokenType.FROM.toString());
		assertEquals("WHERE", TokenType.WHERE.toString());
		assertEquals("DISTINCT", TokenType.DISTINCT.toString());
		assertEquals("AS", TokenType.AS.toString());
		assertEquals("AND", TokenType.AND.toString());
		assertEquals("OR", TokenType.OR.toString());
		assertEquals("COMMA", TokenType.COMMA.toString());
		assertEquals("DOT", TokenType.DOT.toString());
		assertEquals("STAR", TokenType.STAR.toString());
		assertEquals("SEMICOLON", TokenType.SEMICOLON.toString());
		assertEquals("OPEN_PAREN", TokenType.OPEN_PAREN.toString());
		assertEquals("CLOSE_PAREN", TokenType.CLOSE_PAREN.toString());
		assertEquals("COMPARISON_OP", TokenType.COMPARISON_OP.toString());
		assertEquals("IDENTIFIER", TokenType.IDENTIFIER.toString());
		assertEquals("NUMERIC_LIT", TokenType.NUMERIC_LIT.toString());
		assertEquals("STRING_LIT", TokenType.STRING_LIT.toString());
	}

	@Test
	void testCaseSensitiveDefaultValue() {
		TokenType type = TokenType.SELECT;

		assertEquals(false, type.isCaseSensitive());
	}

	@Test
	void testCaseSensitiveParametrizedValue() {
		TokenType type = TokenType.STRING_LIT;

		assertEquals(true, type.isCaseSensitive());
	}

}
