package medicines.dao.impl;

import medicines.dao.MedicineDao;
import medicines.domain.Medicine;
import medicines.domain.Storage;
import medicines.utils.JDBCUtiles;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {

//    private static SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void showMedicineInfo(HttpServletRequest request, HttpServletResponse response) {
        List<Medicine> list = new ArrayList<Medicine>();
        try{
            String sql = "select * from medicine_info";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            int pur_price, sale_price, validity;double discount;
            while (rs.next()){
                Medicine medicine = new Medicine();
                medicine.setMed_name(rs.getString("med_name"));
                medicine.setMed_id(rs.getString("med_id"));
                medicine.setMde_class(rs.getString("class"));
                medicine.setFactor(rs.getString("factor"));
                pur_price = Integer.parseInt(rs.getString("purchase_price"));
                medicine.setPurchase_price(pur_price);
                sale_price = Integer.parseInt(rs.getString("sale_price"));
                medicine.setSale_price(sale_price);
                validity = Integer.parseInt(rs.getString("validity"));
                medicine.setValidity(validity);
                discount = Double.parseDouble(rs.getString("discount"));
                medicine.setDiscount(discount);
                medicine.setImg_url(rs.getString("img_url"));
                list.add(medicine);
            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/medicinesM.jsp").forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void showResposity(HttpServletRequest request, HttpServletResponse response) {
        List<Storage> list = new ArrayList<Storage>();
        try{
            String sql = "select * from storage";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            int stock_num;

            while (rs.next()){
                Storage storage = new Storage();
                storage.setMed_id(rs.getString("med_id"));
                stock_num = Integer.parseInt(rs.getString("stock_num"));
                storage.setStock_num(stock_num);
                System.out.println(rs.getString("production_date"));
                storage.setProduction_date(rs.getString("production_date"));
                list.add(storage);
            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/resposityM.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
