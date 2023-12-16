package servelat;
import com.example.demo.repository.impl.AccountDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.dto.AccountDto;
import com.example.demo.repository.AccountDao;
import com.example.demo.service.AccountService;
import com.example.demo.service.AccountServiceImpl;
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


@WebServlet(urlPatterns = "/account", name = "AccountServlet")
public class AccountServlet extends HttpServlet {
    public AccountServlet() throws SQLException {
    }
    AccountDao accountDao = new AccountDaoImpl();
    AccountService service = new AccountServiceImpl(accountDao);

    ObjectMapper mapper = new ObjectMapper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        response.setContentType("application/json");

        if (pathInfo == null || pathInfo.isEmpty()) {
            List<AccountDto> allAccounts = service.getAllAccounts();
            String json = mapper.writeValueAsString(allAccounts);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(json);
        } else {
            String idString = pathInfo.substring(1);
            try {
                int accountId = Integer.parseInt(idString);
                AccountDto accountDto = service.getAccountById(accountId);
                if (accountDto == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("Account not found with id " + accountId);
                }
                String json = mapper.writeValueAsString(accountDto);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(json);
            } catch (NumberFormatException e) {
                response.setStatus(SC_BAD_REQUEST);
                response.getWriter().write("ID should be a number.");
            }
        }
    }
}
