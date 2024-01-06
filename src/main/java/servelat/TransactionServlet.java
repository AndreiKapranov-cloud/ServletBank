package servelat;
import com.example.demo.dto.BankDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.repository.TransactionDao;
import com.example.demo.repository.impl.TransactionDaoImpl;
import com.example.demo.service.TransactionService;
import com.example.demo.service.TransactionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

@WebServlet(urlPatterns = "/transaction", name = "TransactionServlet")
public class TransactionServlet extends HttpServlet {
    public TransactionServlet() throws SQLException {
    }
    TransactionDao transactionDao = new TransactionDaoImpl();
    TransactionService service = new TransactionServiceImpl(transactionDao);

    ObjectMapper mapper = new ObjectMapper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stringId = request.getParameter("transactionId");
        response.setContentType("application/json");

        if (stringId == null) {
            List<TransactionDto> allTransactions = service.getAllTransactions();
            String json = mapper.writeValueAsString(allTransactions);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(json);
        } else {
            int transactionId = Integer.parseInt(stringId);
            try {
                TransactionDto transactionDto = service.getTransactionById(transactionId);
                int checkId = transactionDto.getTransactionId();
                if (checkId == 0) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Requested transaction not found.");
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("Transaction not found with id " + transactionId);
                }
                String json = mapper.writeValueAsString(transactionDto);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(json);
            } catch (NumberFormatException e) {
                response.setStatus(SC_BAD_REQUEST);
                response.getWriter().write("ID should be a number.");
            }
        }
    }
}