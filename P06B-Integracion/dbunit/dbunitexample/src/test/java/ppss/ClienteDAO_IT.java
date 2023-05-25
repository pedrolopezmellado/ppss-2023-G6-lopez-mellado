package ppss;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;

import org.junit.jupiter.api.*;

/* IMPORTANTE:
    Dado que prácticamente todos los métodos de dBUnit lanzan una excepción,
    vamos a usar "throws Esception" en los métodos, para que el código quede más
    legible sin necesidad de usar un try..catch o envolver cada sentencia dbUnit
    con un assertDoesNotThrow()
    Es decir, que vamos a primar la legibilidad de los tests.
    Si la SUT puede lanza una excepción, SIEMPRE usaremos assertDoesNotThrow para
    invocar a la sut cuando no esperemos que se lance dicha excepción (independientemente de que hayamos propagado las excepciones provocadas por dbunit).
*/
public class ClienteDAO_IT {

    private ClienteDAO clienteDAO; //SUT
    private IDatabaseTester databaseTester;
    private IDatabaseConnection connection;

    @BeforeEach
    public void setUp() throws Exception {

        String cadena_conexionDB = "cadena de conexion";
        databaseTester = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/DBUNIT?useSSL=false", "root", "ppss");
        connection = databaseTester.getConnection();

        clienteDAO = new ClienteDAO();
    }

    @Test
    public void testInsert() throws Exception {
        Cliente cliente = new Cliente(1,"John", "Smith");
        cliente.setDireccion("1 Main Street");
        cliente.setCiudad("Anycity");

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/cliente-init.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la sut
        Assertions.assertDoesNotThrow(()->clienteDAO.insert(cliente));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("cliente");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/cliente-esperado.xml");
        ITable expectedTable = expectedDataSet.getTable("cliente");

        Assertion.assertEquals(expectedTable, actualTable);

    }

    @Test
    public void testInsert2() throws Exception {
        Cliente cliente = new Cliente(2,"Pedro", "Miro");
        cliente.setDireccion("6 Avenida Diagonal");
        cliente.setCiudad("Alicante");

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/cliente-init.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la sut
        Assertions.assertDoesNotThrow(()->clienteDAO.insert(cliente));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("cliente");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/cliente-esperado2.xml");
        ITable expectedTable = expectedDataSet.getTable("cliente");

        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testDelete() throws Exception {
        Cliente cliente =  new Cliente(1,"John", "Smith");
        cliente.setDireccion("1 Main Street");
        cliente.setCiudad("Anycity");

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/cliente-esperado.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la SUT
        Assertions.assertDoesNotThrow(()->clienteDAO.delete(cliente));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("cliente");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/cliente-init.xml");
        ITable expectedTable = expectedDataSet.getTable("cliente");

        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testDelete2() throws Exception {
        Cliente cliente =  new Cliente(2,"Pedro", "Miro");
        cliente.setDireccion("6 Avenida Diagonal");
        cliente.setCiudad("Alicante");

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/cliente-esperado2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la SUT
        Assertions.assertDoesNotThrow(()->clienteDAO.delete(cliente));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("cliente");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/cliente-init.xml");
        ITable expectedTable = expectedDataSet.getTable("cliente");

        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testUpdate() throws Exception {
        Cliente cliente =  new Cliente(1,"John", "Smith");
        cliente.setDireccion("Other Street");
        cliente.setCiudad("NewCity");

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/cliente-esperado.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la SUT
        Assertions.assertDoesNotThrow(()->clienteDAO.update(cliente));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("cliente");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/cliente-update-esperado.xml");
        ITable expectedTable = expectedDataSet.getTable("cliente");

        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testRetrieve() throws Exception {
        Cliente cliente =  new Cliente(1,"John", "Smith");
        cliente.setDireccion("1 Main Street");
        cliente.setCiudad("Anycity");
        int id = 1;

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/cliente-esperado.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la SUT
        Cliente esperado = Assertions.assertDoesNotThrow(()->clienteDAO.retrieve(id));

        Assertions.assertEquals(esperado, cliente);
    }



}
