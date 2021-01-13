package medicines.service.impl;

import medicines.dao.MedicineDao;
import medicines.dao.impl.MedicineDaoImpl;
import medicines.service.MedicineService;
import medicines.utils.JDBCUtiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

public class MedicineServiceImpl implements MedicineService {
    private MedicineDao dao = new MedicineDaoImpl();


    @Override
    public void showMedicineInfo(HttpServletRequest request, HttpServletResponse response) {
        dao.showMedicineInfo(request,response);
    }

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            String sql = "select * from role where name ='"+username+"' and pwd='"+password+"'";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            if(rs.next()){
                rs.close();
                JDBCUtiles.close();
                request.getRequestDispatcher("/overView.jsp").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showResposity(HttpServletRequest request, HttpServletResponse response) {
        dao.showResposity(request,response);
    }
}
