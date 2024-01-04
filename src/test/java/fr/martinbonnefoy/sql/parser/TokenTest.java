package fr.martinbonnefoy.sql.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TokenTest {

	@Test
	void testConstructorWithTypeShouldInitializeTypeForSelect() {
		Token token = new Token(TokenType.SELECT);

		assertNotNull(token.getType());
		assertEquals(TokenType.SELECT, token.getType());
	}

	@Test
	void testConstructorWithTypeShouldInitializeTypeForIdentifier() {
		Token token = new Token(TokenType.IDENTIFIER);

		assertNotNull(token.getType());
		assertEquals(TokenType.IDENTIFIER, token.getType());
	}

	@Test
	void testConstructorWithTypeShouldSetEmptyValue() {
		Token token = new Token(TokenType.SELECT);

		assertNotNull(token.getValue());
		assertEquals("", token.getValue());
	}

	@Test
	void testConstructorWithTypeAndValueShouldInitializeTypeAndValue() {
		Token token = new Token(TokenType.IDENTIFIER, "example");

		assertNotNull(token.getType());
		assertEquals(TokenType.IDENTIFIER, token.getType());
		assertNotNull(token.getValue());
		assertEquals("example", token.getValue());
	}

	@Test
	void testGetTypeShouldReturnCorrectType() {
		Token token = new Token(TokenType.FROM);

		assertEquals(TokenType.FROM, token.getType());
	}

	@Test
	void testGetValueShouldReturnCorrectValue() {
		Token token = new Token(TokenType.STRING_LIT, "text");

		assertEquals("text", token.getValue());
	}

	@Test
	void testSetTypeShouldModifyType() {
		Token token = new Token(TokenType.OPEN_PAREN);

		token.setType(TokenType.CLOSE_PAREN);

		assertEquals(TokenType.CLOSE_PAREN, token.getType());
	}

	@Test
	void testSetValueShouldModifyValue() {
		Token token = new Token(TokenType.COMMA);

		token.setValue("new_value");

		assertEquals("new_value", token.getValue());
	}

	@Test
	void testToStringShouldReturnReadableRepresentation() {
		Token token = new Token(TokenType.AS, "alias");

		assertEquals("<AS: 'alias'>", token.toString());
	}

	@Test
	void testEqualsForSameTokenShouldReturnTrue() {
		Token token = new Token(TokenType.SELECT);

		assertEquals(token, token);
	}

	@Test
	void testEqualsForEqualTokensShouldReturnTrue() {
		Token token1 = new Token(TokenType.IDENTIFIER, "value");
		Token token2 = new Token(TokenType.IDENTIFIER, "value");

		assertEquals(token1, token2);
	}

	@Test
	void testEqualsForDifferentValuesShouldReturnFalse() {
		Token token1 = new Token(TokenType.IDENTIFIER, "value1");
		Token token2 = new Token(TokenType.IDENTIFIER, "value2");

		assertNotEquals(token1, token2);
	}

	@Test
	void testEqualsForDifferentTypesShouldReturnFalse() {
		Token token1 = new Token(TokenType.IDENTIFIER, "value1");
		Token token2 = new Token(TokenType.SELECT, "value1");

		assertNotEquals(token1, token2);
	}

	@Test
	void testEqualsWithDifferentLetterCaseShouldBeEquals() {
		Token token1 = new Token(TokenType.SELECT, "SELECT");
		Token token2 = new Token(TokenType.SELECT, "select");

		assertEquals(token1, token2);
	}

	@Test
	void testEqualsWithDifferentLetterCaseShouldBeDifferents() {
		Token token1 = new Token(TokenType.STRING_LIT, "'literal'");
		Token token2 = new Token(TokenType.STRING_LIT, "'LITERAL'");

		assertNotEquals(token1, token2);
	}

	@Test
	void testEqualsForNonTokenObject() {
		Token token = new Token(TokenType.SELECT);

		assertNotEquals(token, "not a Token");
	}

	@Test
	void testEqualsWithNull() {
		Token token = new Token(TokenType.SELECT);

		assertNotEquals(token, null);
	}

	@Test
	void testHashCodeConsistencyForEqualTokens() {
		Token token1 = new Token(TokenType.IDENTIFIER, "value");
		Token token2 = new Token(TokenType.IDENTIFIER, "value");

		assertEquals(token1.hashCode(), token2.hashCode());
	}
}
