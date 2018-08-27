package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crispim Paiano dos Santos
 */
@WebServlet(urlPatterns = "/index2")
public class SupermecadoIndex extends HttpServlet{
    
    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<PessoaBean> clientes = new PessoaDAO().ObterUsuario();
        req.getRequestDispatcher("/layout/master.jsp").include(req, resp);
      /* out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Clientes - Lista</title>");
        out.println("<link rel='stylesheet' type='text/css' href='teste.css'/>");
        out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/all.css' integrity='sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ' crossorigin='anonymous'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container-fluid'>");
        
        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");
        out.println("<h3 class='text-center'>Lista de Clientes DAO (COM FK)</h3>");
        
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='row'>");
        out.println("<div class='col-md-2 offset-md-10'>");
        
        out.println("<a href='/WebExemplo02/alimentos/cadastro' class='btn btn-primary float-right'><i class='fa fa-user'> APENAS TESTE BANCO</i></a>");
        
        out.println("</div>");
        out.println("</div>");
        
        gerarTabela(clientes);
        //gerarCompras(compras);
        
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    
    private void gerarTabela(List<PessoaBean> usuarios){
        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");
        
        out.println("<table class='table table-striped table-hover'>");
        out.println("<thead>");
        out.println("<tr class='table-primary'>");
        out.println("<th>Código</th>");
        out.println("<th>Tipo</th>");
        out.println("<th>IDTIPO</th>");
        out.println("<th>IDTIPO</th>");
        out.println("<th>nome</th>");
        out.println("<th>email</th>");
        out.println("<th>senha</th>");
        out.println("<th>cpf</th>");
        out.println("<th>idade</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for(PessoaBean usuario: usuarios){
            out.println("<tr>");
            out.println("<th>"+usuario.getId()+"</th>");
            out.println("<th>"+usuario.getPrivilegioBean().getTipo()+"</th>");
            out.println("<th>"+usuario.getPrivilegioBean().getId()+"</th>");
            out.println("<th>"+usuario.getIdPrivilegio()+"</th>");
            out.println("<th>"+usuario.getNome()+"</th>");
            out.println("<th>"+usuario.getEmail()+"</th>");
            out.println("<th>"+usuario.getSenha()+"</th>");
            out.println("<th>"+usuario.getCpf()+"</th>");
            out.println("<th>"+usuario.getIdade()+"</th>");
            out.println("<th>");

            out.println("<a href='/WebExemplo02/alimentos/editar?id="+usuario.getId()+"' class='btn btn-outline-sucess'><i class='fa fa-edit'></i>Editar</a>");
            out.println("<a href='/WebExemplo02/alimentos/excluir?id="+usuario.getId()+"' class='botao-excluir'>Excluir</a>");

            out.println("</th>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("<tfoot>");
        out.println("<tr>");
        out.println("<th>Código</th>");
        out.println("<th>Tipo</th>");
        out.println("<th>IDTIPO</th>");
        out.println("<th>IDTIPO</th>");
        out.println("<th>nome</th>");
        out.println("<th>email</th>");
        out.println("<th>senha</th>");
        out.println("<th>cpf</th>");
        out.println("<th>idade</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</tfoot>");
        out.println("</table>");
        
        out.println("</div>");
        out.println("</div>");*/
    }
    
}
