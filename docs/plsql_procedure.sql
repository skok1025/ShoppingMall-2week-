DELIMITER $$
	CREATE procedure proc_deleteBigCategory(in pno int unsigned,out presult integer)
	begin
		DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN        
	set presult =0;
		rollback;
		END;

	  update tblGoods set smallcategory_no=null where smallcategory_no in (select no from tblSmallCategory where bigcategory_no=pno);  
	  delete from tblSmallCategory where bigcategory_no=pno;     
      delete from tblBigCategory where no= pno;    
  set presult = 1;  
	commit;    
	end $$
DELIMITER ;
