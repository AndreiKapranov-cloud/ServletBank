package servelat;
import com.example.demo.dto.BankDto;
import com.example.demo.repository.BankDao;
import com.example.demo.repository.impl.BankDaoImpl;
import com.example.demo.service.BankService;
import com.example.demo.service.BankServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.dto.AccountDto;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;



    @WebServlet(urlPatterns = "/bank", name = "BankServlet")
    public class BankServlet extends HttpServlet {
        public BankServlet() throws SQLException {
        }
        BankDao bankDao = new BankDaoImpl();
        BankService service = new BankServiceImpl(bankDao);

        ObjectMapper mapper = new ObjectMapper();

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String pathInfo = request.getPathInfo();
            response.setContentType("application/json");

            if (pathInfo == null || pathInfo.isEmpty()) {
                List<BankDto> allAccounts = service.getAllBanks();
                String json = mapper.writeValueAsString(allAccounts);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(json);
            } else {
                String idString = pathInfo.substring(1);
                try {
                    int accountId = Integer.parseInt(idString);
                    BankDto bankDto = service.getBankByAccount(accountId);
                    if (bankDto == null) {
                        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        response.getWriter().write("Bank not found ");
                    }
                    String json = mapper.writeValueAsString(bankDto);
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().write(json);
                } catch (NumberFormatException e) {
                    response.setStatus(SC_BAD_REQUEST);
                    response.getWriter().write("ID should be a number.");
                }
            }
        }
    }

