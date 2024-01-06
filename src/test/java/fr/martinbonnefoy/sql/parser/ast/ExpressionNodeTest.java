package fr.martinbonnefoy.sql.parser.ast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.martinbonnefoy.sql.parser.ast.ExpressionNode.ExpressionType;

class ExpressionNodeTest {

	@Test
	void testExpressionType() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);

		assertNotNull(expressionNode.getExpressionType());
		assertEquals(ExpressionType.COLUMN_IDENTIFIER, expressionNode.getExpressionType());
	}

	@Test
	void testColumnIdentifier() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		expressionNode.setColumnIdentifier(colIdentifierNode);

		assertNotNull(expressionNode.getColumnIdentifier());
		assertEquals(colIdentifierNode, expressionNode.getColumnIdentifier());
	}

	@Test
	void testSetColumnIdentifierWithOtherExpressionType() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.NUMERIC_LITERAL);
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();

		Exception expected = assertThrows(IllegalStateException.class,
				() -> expressionNode.setColumnIdentifier(colIdentifierNode));
		String expectedMessage = "Cannot set column identifier when expression is of type NUMERIC_LITERAL";
		String actualMessage = expected.getMessage();

		assertEquals(expectedMessage, actualMessage);
		assertNull(expressionNode.getColumnIdentifier());
	}

	@Test
	void testNumericLiteral() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.NUMERIC_LITERAL);
		Double numericLiteral = 123.45;
		expressionNode.setNumericLiteral(numericLiteral);

		assertNotNull(expressionNode.getNumericLiteral());
		assertEquals(numericLiteral, expressionNode.getNumericLiteral());
	}

	@Test
	void testSetNumericLiteralWithOtherExpressionType() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.STRING_LITERAL);
		Double numericLiteral = 123.45;

		Exception expected = assertThrows(IllegalStateException.class,
				() -> expressionNode.setNumericLiteral(numericLiteral));
		String expectedMessage = "Cannot set numeric literal when expression is of type STRING_LITERAL";
		String actualMessage = expected.getMessage();

		assertEquals(expectedMessage, actualMessage);
		assertNull(expressionNode.getNumericLiteral());
	}

	@Test
	void testStringLiteral() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.STRING_LITERAL);
		String stringLiteral = "test";
		expressionNode.setStringLiteral(stringLiteral);

		assertNotNull(expressionNode.getStringLiteral());
		assertEquals(stringLiteral, expressionNode.getStringLiteral());
	}

	@Test
	void testSetStringLiteralWithOtherExpressionType() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		String stringLiteral = "test";

		Exception expected = assertThrows(IllegalStateException.class,
				() -> expressionNode.setStringLiteral(stringLiteral));
		String expectedMessage = "Cannot set string literal when expression is of type COLUMN_IDENTIFIER";
		String actualMessage = expected.getMessage();

		assertEquals(expectedMessage, actualMessage);
		assertNull(expressionNode.getStringLiteral());
	}

	@Test
	void testHashCodeEquals() {
		ExpressionNode expressionNode1 = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		expressionNode1.setColumnIdentifier(colIdentifierNode);

		ExpressionNode expressionNode2 = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		expressionNode2.setColumnIdentifier(colIdentifierNode);

		assertEquals(expressionNode1.hashCode(), expressionNode2.hashCode());
	}

	@Test
	void testEqualsWithEqualObject() {
		ExpressionNode expressionNode1 = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		expressionNode1.setColumnIdentifier(colIdentifierNode);

		ExpressionNode expressionNode2 = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		expressionNode2.setColumnIdentifier(colIdentifierNode);

		assertEquals(expressionNode1, expressionNode2);
	}

	@Test
	void testEqualsWithSameObject() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		expressionNode.setColumnIdentifier(colIdentifierNode);

		assertEquals(expressionNode, expressionNode);
	}

	@Test
	void testEqualsWithNull() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);

		assertNotEquals(expressionNode, null);
	}

	@Test
	void testEqualsWithDifferentTypes() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);

		assertNotEquals(expressionNode, new Object());
	}

	@Test
	void testEqualsWithDifferentColumnIdentifiers() {
		ExpressionNode expressionNode1 = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		ColIdentifierNode colIdentifierNode1 = new ColIdentifierNode();
		colIdentifierNode1.setColumnName("foo");
		expressionNode1.setColumnIdentifier(colIdentifierNode1);

		ExpressionNode expressionNode2 = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		ColIdentifierNode colIdentifierNode2 = new ColIdentifierNode();
		colIdentifierNode2.setColumnName("bar");
		expressionNode2.setColumnIdentifier(colIdentifierNode2);

		assertNotEquals(expressionNode1, expressionNode2);
	}

	@Test
	void testEqualsWithDifferentNumericLiterals() {
		ExpressionNode expressionNode1 = new ExpressionNode(ExpressionType.NUMERIC_LITERAL);
		expressionNode1.setNumericLiteral(123.45);

		ExpressionNode expressionNode2 = new ExpressionNode(ExpressionType.NUMERIC_LITERAL);
		expressionNode2.setNumericLiteral(678.90);

		assertNotEquals(expressionNode1, expressionNode2);
	}

	@Test
	void testEqualsWithDifferentStringLiterals() {
		ExpressionNode expressionNode1 = new ExpressionNode(ExpressionType.STRING_LITERAL);
		expressionNode1.setStringLiteral("test1");

		ExpressionNode expressionNode2 = new ExpressionNode(ExpressionType.STRING_LITERAL);
		expressionNode2.setStringLiteral("test2");

		assertNotEquals(expressionNode1, expressionNode2);
	}

	@Test
	void testToStringWithColumnIdentifier() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.COLUMN_IDENTIFIER);
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		expressionNode.setColumnIdentifier(colIdentifierNode);

		assertEquals(colIdentifierNode.toString(), expressionNode.toString());
	}

	@Test
	void testToStringWithNumericLiteral() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.NUMERIC_LITERAL);
		Double numericLiteral = 123.45;
		expressionNode.setNumericLiteral(numericLiteral);

		assertEquals(numericLiteral.toString(), expressionNode.toString());
	}

	@Test
	void testToStringWithStringLiteral() {
		ExpressionNode expressionNode = new ExpressionNode(ExpressionType.STRING_LITERAL);
		String stringLiteral = "test";
		expressionNode.setStringLiteral(stringLiteral);

		assertEquals("'" + stringLiteral + "'", expressionNode.toString());
	}

}
