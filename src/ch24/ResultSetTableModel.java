package ch24;
//Figura 24.25: ResulSetTableModel.java Um TableModel que fornece dados ResultSet a um JTable
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

//Linhas e colunas do ResultSet são contados a partir de 1 e linhas e
//colunas JTable são contadas a partir de 0. Ao processar
//linhas ou colunas de ResultSet para utilização em uma JTable, é
//necessário adicionar 1 ao número de linha ou coluna para manipular
//a coluna apropriada de ResultSet (isto é, coluna 0 de JTable é a
//coluna de ResultSet 1 e a linha JTable 0 é a linha de ResultSet 1).
public class ResultSetTableModel extends AbstractTableModel 
{
    private final Connection connection;
    private final Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;

    // monitora o status da conexão de banco de dados
    private boolean connectedToDatabase = false;

    // construtor inicializa resuiltSet e obtém seu objeto de metadados
    // determina o número de linhas
    public ResultSetTableModel(String url, String username,
     String password, String query) throws SQLException 
    {
        //conecta-se ao banco de dados
        connection = DriverManager.getConnection(url, username, password);

        //cria statement para consultar o banco de dados
        statement = connection.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);

            //atualiza status de conexão de banco de dados
            connectedToDatabase = true;

            //configura consulta e a executa
            setQuery(query);
    }

    //obtem a classe que representa o tipo de coluna
    public Class getColumnClass(int coluna) throws IllegalStateException
    {
        //certifica-se de que há uma conexão disponível com o banco de dados
        if (!connectedToDatabase)
        throw new IllegalStateException("Não conected to database");

        //determina a classe Java de coluna
        try
        {
            String className = metaData.getColumnClassName(+1);

            //retorna objeto Class que representa className
            return Class.forName(className);
        }
        catch (Exception exception)
    {
        exception.printStackTrace();
    }

    return Object.class;//se ocorrerem os problemas acima, supõe tipo Object
    }

    //obtém número de colunas em ResultSet
    public int getColumnCount() throws IllegalStateException
    {
        //certifica-se qde que há uma conexão disponível com o banco de dados
        if(!connectedToDatabase)
        throw new IllegalStateException("Not connected to Database");

        //determina número de colunas
        try
        {
            return metaData.getColumnCount();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

        return 0;
    }

    //obtém o nome de uma coluna particular em ResultSet
    public String getColumnName(int column) throws IllegalStateException
    {
        //certifica-se de que há uma conexão disponível com o banco de dados
        if (!connectedToDatabase)
        throw new IllegalStateException("Not connected to database");

        //determina o nome da coluna
        try
        {
            return metaData.getColumnName(column +1);
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

        return "";//se ocorrerem problemas, retorna string vazia para nome de coluna
    }

    //retorna número de linhas em ResultSet
    public int getRowCount() throws IllegalStateException
    {
        //certifica-se de que há uma conexão disponível com o banco de dados
        if (!connectedToDatabase)
        throw new IllegalStateException("Note connected to database");

        return numberOfRows;
    }

    //obtém valor na linha e coluna especificadas
    public Object getValueAt(int row, int column)
    throws IllegalStateException
    {
        //certifica-se de que há uma conexão disponível com o banco de dados
        if (!connectedToDatabase)
        throw new IllegalStateException("Not connected to Database");

        //obtém um valor na linha e coluna de ResultSet especificada
        try
        {
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

        return ""; // se ocorrer problemas, retorna objeto string vazio
    }

    //configura nova string de consulta de banco de dados
    public void setQuery(String query)
    throws SQLException, IllegalStateException
    {
        //certifica-se de que há uma conexão disponível com o banco de dados
        if (!connectedToDatabase)
        throw new IllegalStateException("Note connected to Database");

        //especifica cosulta e a executa
        resultSet = statement.executeQuery(query);

        //obtém metadados para o resultSet
        metaData = resultSet.getMetaData();

        //determina o número de linhas em ResultSet
        resultSet.last();//move para a última linha
        numberOfRows = resultSet.getRow();//obtém número de linha

        //notifica a JTable de que o modelo foi alterado
        fireTableStructureChanged();
    }

    //fecha statement e connection
    public void disconnectFromDatabase()
    {
        if(connectedToDatabase)
        {
            //fecha statement e connection
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            finally //atualiza status de conexão de banco de dados
            {
                connectedToDatabase = false;
            }
        }
    }
}