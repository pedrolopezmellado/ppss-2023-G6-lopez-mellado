import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ppss.matriculacion.dao.DAOException;
import ppss.matriculacion.dao.FactoriaDAO;
import ppss.matriculacion.to.AlumnoTO;

import java.time.LocalDate;

public class AlumnoDaoIT {

    private FactoriaDAO factoriaDao; //SUT
    private IDatabaseTester databaseTester;
    private IDatabaseConnection connection;

    @BeforeEach
    public void setUp() throws Exception {

        String cadena_conexionDB = "cadena de conexion";
        databaseTester = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/matriculacion?useSSL=false", "root", "ppss");
        connection = databaseTester.getConnection();

        factoriaDao = new FactoriaDAO();
    }

    @Test
    @Tag("Integracion-fase1")
    public void testA1() throws Exception {
        AlumnoTO alumno = new AlumnoTO();
        alumno.setNif("33333333C");
        alumno.setNombre("Elena Aguirrez Juarez");
        alumno.setFechaNacimiento(LocalDate.of(1985, 2, 22));

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la sut
        Assertions.assertDoesNotThrow(()->factoriaDao.getAlumnoDAO().addAlumno(alumno));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, actualTable);

    }

    @Test
    @Tag("Integracion-fase1")
    public void testA2() throws Exception {
        AlumnoTO alumno = new AlumnoTO();
        alumno.setNif("11111111A");
        alumno.setNombre("Alfonso Ramirez Ruiz");
        alumno.setFechaNacimiento(LocalDate.of(1982, 2, 22));

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la sut
        DAOException exception =  Assertions.assertThrows(DAOException.class,
                () -> factoriaDao.getAlumnoDAO().addAlumno(alumno));

        Assertions.assertEquals("Error al conectar con BD", exception.getMessage());

    }

    @Test
    @Tag("Integracion-fase1")
    public void testA3() throws Exception {
        AlumnoTO alumno = new AlumnoTO();
        alumno.setNif("44444444D");
        alumno.setNombre(null);
        alumno.setFechaNacimiento(LocalDate.of(1982, 2, 22));

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la sut
        DAOException exception =  Assertions.assertThrows(DAOException.class,
                () -> factoriaDao.getAlumnoDAO().addAlumno(alumno));

        Assertions.assertEquals("Error al conectar con BD", exception.getMessage());

    }

    @Test
    @Tag("Integracion-fase1")
    public void testA4() throws Exception {

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la sut
        DAOException exception =  Assertions.assertThrows(DAOException.class,
                () -> factoriaDao.getAlumnoDAO().addAlumno(null));

        Assertions.assertEquals("Alumno nulo", exception.getMessage());

    }

    @Test
    @Tag("Integracion-fase1")
    public void testA5() throws Exception {

        AlumnoTO alumno = new AlumnoTO();
        alumno.setNif(null);
        alumno.setNombre("Pedro Garcia Lopez");
        alumno.setFechaNacimiento(LocalDate.of(1982, 2, 22));

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la sut
        DAOException exception =  Assertions.assertThrows(DAOException.class,
                () -> factoriaDao.getAlumnoDAO().addAlumno(alumno));

        Assertions.assertEquals("Error al conectar con BD", exception.getMessage());

    }

    @Test
    @Tag("Integracion-fase1")
    public void testB1() throws Exception {

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //invocamos a la sut
        Assertions.assertDoesNotThrow(()->factoriaDao.getAlumnoDAO().delAlumno("11111111A"));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla4.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, actualTable);

    }

    @Test
    @Tag("Integracion-fase1")
    public void testB2() throws Exception {

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        DAOException exception =  Assertions.assertThrows(DAOException.class,
                () -> factoriaDao.getAlumnoDAO().delAlumno("33333333C"));

        Assertions.assertEquals("No se ha borrado ningun alumno", exception.getMessage());

    }
}
