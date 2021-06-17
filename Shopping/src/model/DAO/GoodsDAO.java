package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.ProductDTO;

public class GoodsDAO extends DataBaseInfo{
	final String COLUMNS = "prod_num, prod_name, prod_price, prod_image, prod_detail, prod_capacity, prud_supplyer, prod_del_fee, recommend, employee_id, ctgr "; 
	
	public ProductDTO GoodsOne(String prodNum) {
		ProductDTO dto = null;
		sql = " select " + COLUMNS + " from products "
				+ " where prod_num = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setCtgr(rs.getString("ctgr"));
				dto.setEmployeeId(rs.getString("employee_Id"));
				dto.setProdCapacity(rs.getString("prod_Capacity"));
				dto.setProdDelFee(rs.getString("prod_Del_Fee"));
				dto.setProdDetail(rs.getString("prod_Detail"));
				dto.setProdImage(rs.getString("prod_Image"));
				dto.setProdName(rs.getString("prod_Name"));
				dto.setProdNum(rs.getString("prod_Num"));
				dto.setProdPrice(rs.getInt("prod_Price"));
				dto.setProdSupplyer(rs.getString("prud_Supplyer"));
				dto.setRecommend(rs.getString("recommend"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}
	
	public List<ProductDTO> goodsList() {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		sql = " select " + COLUMNS + " from products ";
		getConnect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setCtgr(rs.getString("ctgr"));
				dto.setEmployeeId(rs.getString("employee_Id"));
				dto.setProdCapacity(rs.getString("prod_Capacity"));
				dto.setProdDelFee(rs.getString("prod_Del_Fee"));
				dto.setProdDetail(rs.getString("prod_Detail"));
				dto.setProdImage(rs.getString("prod_Image"));
				dto.setProdName(rs.getString("prod_Name"));
				dto.setProdNum(rs.getString("prod_Num"));
				dto.setProdPrice(rs.getInt("prod_Price"));
				dto.setProdSupplyer(rs.getString("prud_Supplyer"));
				dto.setRecommend(rs.getString("recommend"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public void prodInsert(ProductDTO dto) {
		sql = " insert into products ( " + COLUMNS + ") "
				+ " values(?,?,?,?,?,?,?,?,?,?,?) ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getProdNum());
			pstmt.setString(2, dto.getProdName());
			pstmt.setInt(3, dto.getProdPrice());
			pstmt.setString(4, dto.getProdImage());
			pstmt.setString(5, dto.getProdDetail());
			pstmt.setString(6, dto.getProdCapacity());
			pstmt.setString(7, dto.getProdSupplyer());
			pstmt.setString(8, dto.getProdDelFee());
			pstmt.setString(9, dto.getRecommend());
			pstmt.setString(10, dto.getEmployeeId());
			pstmt.setString(11, dto.getCtgr());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 입력되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public String goodsNum() {
		String prodNum = null;
		sql = " select prod_seq.nextval from dual ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			prodNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return prodNum;
	}
	
}
