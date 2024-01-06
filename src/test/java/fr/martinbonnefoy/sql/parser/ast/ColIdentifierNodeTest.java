package fr.martinbonnefoy.sql.parser.ast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ColIdentifierNodeTest {

	@Test
	void testColumnName() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		String columnName = "testColumn";
		colIdentifierNode.setColumnName(columnName);

		assertNotNull(colIdentifierNode.getColumnName());
		assertEquals(columnName, colIdentifierNode.getColumnName());
	}

	@Test
	void testTableName() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		String tableName = "testTable";
		colIdentifierNode.setTableName(tableName);

		assertNotNull(colIdentifierNode.getTableName());
		assertEquals(tableName, colIdentifierNode.getTableName());
	}

	@Test
	void testColumnAlias() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		String columnAlias = "alias";
		colIdentifierNode.setColumnAlias(columnAlias);

		assertNotNull(colIdentifierNode.getColumnAlias());
		assertEquals(columnAlias, colIdentifierNode.getColumnAlias());
	}

	@Test
	void testHashCodeEquals() {
		ColIdentifierNode colIdentifierNode1 = new ColIdentifierNode();
		colIdentifierNode1.setTableName("testTable");
		colIdentifierNode1.setColumnName("testColumn");
		colIdentifierNode1.setColumnAlias("alias");

		ColIdentifierNode colIdentifierNode2 = new ColIdentifierNode();
		colIdentifierNode2.setTableName("testTable");
		colIdentifierNode2.setColumnName("testColumn");
		colIdentifierNode2.setColumnAlias("alias");

		assertEquals(colIdentifierNode1.hashCode(), colIdentifierNode2.hashCode());
	}

	@Test
	void testEqualsWithEqualObject() {
		ColIdentifierNode colIdentifierNode1 = new ColIdentifierNode();
		colIdentifierNode1.setTableName("testTable");
		colIdentifierNode1.setColumnName("testColumn");
		colIdentifierNode1.setColumnAlias("alias");

		ColIdentifierNode colIdentifierNode2 = new ColIdentifierNode();
		colIdentifierNode2.setTableName("testTable");
		colIdentifierNode2.setColumnName("testColumn");
		colIdentifierNode2.setColumnAlias("alias");

		assertEquals(colIdentifierNode1, colIdentifierNode2);
	}

	@Test
	void testEqualsWithSameObject() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		colIdentifierNode.setTableName("testTable");
		colIdentifierNode.setColumnName("testColumn");
		colIdentifierNode.setColumnAlias("alias");

		assertEquals(colIdentifierNode, colIdentifierNode);
	}

	@Test
	void testEqualsWithNull() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();

		assertNotEquals(colIdentifierNode, null);
	}

	@Test
	void testEqualsWithDifferentClass() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();

		assertNotEquals(colIdentifierNode, new Object());
	}

	@Test
	void testEqualsWithDifferentTableName() {
		ColIdentifierNode colIdentifierNode1 = new ColIdentifierNode();
		colIdentifierNode1.setTableName("testTable1");
		colIdentifierNode1.setColumnName("testColumn");
		colIdentifierNode1.setColumnAlias("alias");

		ColIdentifierNode colIdentifierNode2 = new ColIdentifierNode();
		colIdentifierNode2.setTableName("testTable2");
		colIdentifierNode2.setColumnName("testColumn");
		colIdentifierNode2.setColumnAlias("alias");

		assertNotEquals(colIdentifierNode1, colIdentifierNode2);
	}

	@Test
	void testEqualsWithDifferentColumnName() {
		ColIdentifierNode colIdentifierNode1 = new ColIdentifierNode();
		colIdentifierNode1.setTableName("testTable");
		colIdentifierNode1.setColumnName("testColumn1");
		colIdentifierNode1.setColumnAlias("alias");

		ColIdentifierNode colIdentifierNode2 = new ColIdentifierNode();
		colIdentifierNode2.setTableName("testTable");
		colIdentifierNode2.setColumnName("testColumn2");
		colIdentifierNode2.setColumnAlias("alias");

		assertNotEquals(colIdentifierNode1, colIdentifierNode2);
	}

	@Test
	void testEqualsWithDifferentColumnAlias() {
		ColIdentifierNode colIdentifierNode1 = new ColIdentifierNode();
		colIdentifierNode1.setTableName("testTable");
		colIdentifierNode1.setColumnName("testColumn");
		colIdentifierNode1.setColumnAlias("alias1");

		ColIdentifierNode colIdentifierNode2 = new ColIdentifierNode();
		colIdentifierNode2.setTableName("testTable");
		colIdentifierNode2.setColumnName("testColumn");
		colIdentifierNode2.setColumnAlias("alias2");

		assertNotEquals(colIdentifierNode1, colIdentifierNode2);
	}

	@Test
	void testToStringWithOnlyColumnName() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		colIdentifierNode.setColumnName("testColumn");

		assertEquals("testColumn", colIdentifierNode.toString());
	}

	@Test
	void testToStringWithColumnNameAndAlias() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		colIdentifierNode.setColumnName("testColumn");
		colIdentifierNode.setColumnAlias("alias");

		assertEquals("testColumn AS alias", colIdentifierNode.toString());
	}

	@Test
	void testToStringWithColumnAndTableNames() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		colIdentifierNode.setTableName("testTable");
		colIdentifierNode.setColumnName("testColumn");

		assertEquals("testTable.testColumn", colIdentifierNode.toString());
	}

	@Test
	void testToStringWithEverything() {
		ColIdentifierNode colIdentifierNode = new ColIdentifierNode();
		colIdentifierNode.setTableName("testTable");
		colIdentifierNode.setColumnName("testColumn");
		colIdentifierNode.setColumnAlias("alias");

		assertEquals("testTable.testColumn AS alias", colIdentifierNode.toString());
	}

}
