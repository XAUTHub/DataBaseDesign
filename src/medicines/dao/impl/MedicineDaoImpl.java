package medicines.dao.impl;

import medicines.dao.MedicineDao;
import medicines.domain.Medicine;
import medicines.domain.Storage;
import medicines.domain.details.*;
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

    @Override
    public void showFactory(HttpServletRequest request, HttpServletResponse response) {
        List<Factory> list = new ArrayList<Factory>();
        try{
            String sql = "select * from factor";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            int stock_num;
            while (rs.next()){
                Factory factory = new Factory();
                factory.setFac_name(rs.getString("fac_name"));
                factory.setMed_identify(rs.getString("med_identify"));
                String identity = rs.getString("med_identify");
                String sql2 = "select purchase_price from medicine_info where med_id ='"+identity+"'";
                ResultSet rss = JDBCUtiles.queryTwo(sql2);
                while (rss.next()){
                    factory.setPurchase_price(Integer.parseInt(rss.getString("purchase_price")));
                }
                factory.setProduction_date(rs.getString("production_date"));
                list.add(factory);
            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/factoryM.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showIn(HttpServletRequest request, HttpServletResponse response) {
        List<in> list = new ArrayList<in>();
        try{
            String sql = "select * from purchase";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                in in = new in();
                in.setPurchase_id(rs.getString("purchase_id"));
                in.setPurchase_date(rs.getString("purchase_date"));
                list.add(in);
            }
            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/inResposity.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showOut(HttpServletRequest request, HttpServletResponse response) {
        List<out> list = new ArrayList<out>();
        try{
            String sql = "select * from sale";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                out ou = new out();
                ou.setSale_id(rs.getString("sale_id"));
                ou.setSale_date(rs.getString("sale_date"));
                list.add(ou);
            }
            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/outResposity.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showInMore(HttpServletRequest request, HttpServletResponse response) {
        List<inMore> list = new ArrayList<inMore>();
        try{
            String sql = "select * from purchase_details";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            int purchase_price, purchase_date;
            while (rs.next()){
                inMore inM = new inMore();
                inM.setPurchase_id(rs.getString("purchase_id"));
                inM.setFactor_name(rs.getString("factor_name"));
                inM.setMed_id(rs.getString("med_id"));
                inM.setPurchase_price(Integer.parseInt(rs.getString("purchase_price")));
                inM.setPurchase_num(Integer.parseInt(rs.getString("purchase_num")));
                inM.setPurchase_date(rs.getString("purchase_date"));
                list.add(inM);
            }
            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/inResposityMore.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showOutMore(HttpServletRequest request, HttpServletResponse response) {
        List<outMore> list = new ArrayList<outMore>();
        try{
            String sql = "select * from sale_details";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            double sale_discount, true_price;int sale_num;
            while (rs.next()){
                outMore outm = new outMore();
                outm.setSale_id(rs.getString("sale_id"));
                outm.setUser_id(rs.getString("user_id"));
                outm.setMed_id(rs.getString("med_id"));
                outm.setMed_name(rs.getString("med_name"));
                outm.setTrue_price(Double.parseDouble(rs.getString("true_price")));
                outm.setSale_discount(Double.parseDouble(rs.getString("sale_discount")));
                outm.setSale_num(Integer.parseInt(rs.getString("sale_num")));
                outm.setSale_date(rs.getString("sale_date"));
                list.add(outm);
            }
            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/outResposityMore.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showClient(HttpServletRequest request, HttpServletResponse response) {
        List<Client> list = new ArrayList<Client>();
        try{
            String sql = "select * from user";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                Client client = new Client();
                client.setUser_id(rs.getString("user_id"));
                client.setUser_tel(rs.getString("user_tel"));
                list.add(client);
            }
            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/Client.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
