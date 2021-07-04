package kr.co.fw.product;

import kr.co.fw.base.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO extends BaseVO {
	
	private String prod_id; 		/* VARCHAR(32) PK 	'상품 ID' */
	private String prod_nm;			/* VARCHAR(100) 	'상품 명' */
	private String simp_prod_nm;	/* VARCHAR(100) 	'간편 상품 명' */
	private String insco_cd; 		/* VARCHAR(5)		'보험사 코드' */
	private String prod_kind1;		/* VARCHAR(10)		'상품 대분류' */
	private String prod_kind2;		/* VARCHAR(10)		'상품 중분류' */
	private String prod_kind3;		/* VARCHAR(10)		'상품 소분류' */
	
	private String cvrg_seq; 		/* BIGINT PK AI 	'보장 일련번호'	*/
	private String cvrg_kind1;		/* VARCHAR(50)		'보장 대분류'*/
	private String cvrg_kind2;		/* VARCHAR(50)		'보장 중분류'*/
	private String cvrg_kind3;		/* VARCHAR(50) 		'보장 소분류'*/
	private String cvrg_desc;		/* VARCHAR(100)		'보장 내용'*/
	private String cvrg_period;		/* VARCHAR(20)		'보장 기간'*/	
	private String memo;			/* VARCHAR(100)		'메모' */
	
	private String cust_id; 		/* VARCHAR(32) NN	'고객 ID' */
	private String cont_id;			/* VARCHAR(32) 		'계약 ID' */
	private String pay_period;		/* VARCHAR(10)  	'납입 기간' */
	private String pay_cycle;		/* VARCHAR(10)		'납입 주기 (= 납입 방법)' */
	private String pay_mean;		/* VARCHAR(10) 		'납입 수단(카드, 계좌이체 등)' */
	private String pay_amt1;		/* VARCHAR(30)		'초회 보험료' */
	private String pay_amt2;		/* VARCHAR(30)		'계속 보험료' */
	
	private String prem_amt_seq;    /* BIGINT PK AI 	'일련번호' */
	private String age_from;		/* INT 			NN	'나이 시작' */
	private String age_to;			/* INT 			NN	'나이 종료' */
	private String gender;			/* VARCHAR(2) 	NN	'성별' */
	private String amt; 			/* INT 				'보험료' */
	private String amt_unit;		/* VARCHAR(10) 		'보험료 단위 (USD|KRW)' */

}
