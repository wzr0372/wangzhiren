package com.index;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index(){
			//Ĭ����������ҳ��
			render("/jobinfo/job_info_edit.html");
	}
}
