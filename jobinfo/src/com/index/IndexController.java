package com.index;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index(){
			//默认跳到增加页面
			render("/jobinfo/job_info_edit.html");
	}
}
