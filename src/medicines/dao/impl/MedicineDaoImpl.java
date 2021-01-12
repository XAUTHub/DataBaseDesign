package medicines.dao.impl;

import medicines.dao.MedicineDao;
import medicines.domain.Medicine;
import medicines.utils.JDBCUtiles;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {
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
                discount = Integer.parseInt(rs.getString("discount"));
                medicine.setDiscount(discount);
                medicine.setImg_url(rs.getString("img_url"));
                list.add(medicine);
            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();

            JSONArray jsonArray = JSONArray.fromObject(list);
            System.out.println(jsonArray);
            response.getWriter().print(jsonArray);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
