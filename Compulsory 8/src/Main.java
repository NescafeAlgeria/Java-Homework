import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ContinentDao continentDao = new ContinentDao();
            CountryDao countryDao = new CountryDao();

            continentDao.create(1, "Europe");
            Integer europeId = continentDao.findByName("Europe");

            countryDao.create(1, "Romania", "RO", europeId);
            Integer romaniaId = countryDao.findByName("Romania");

            System.out.println("Continent ID for Europe: " + europeId);
            System.out.println("Country ID for Romania: " + romaniaId);

            System.out.println("Continent name with ID " + europeId + ": " + continentDao.findById(europeId));
            System.out.println("Country name with ID " + romaniaId + ": " + countryDao.findById(romaniaId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
