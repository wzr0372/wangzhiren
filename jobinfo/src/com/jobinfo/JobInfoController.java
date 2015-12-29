package com.jobinfo;

import com.jfinal.core.Controller;

public class JobInfoController extends Controller {
	
	public void index() {
		setAttr("jobinfoPage", JobInfo.jobinfo.paginate(getParaToInt(0, 1), 50));//分页
		render("job_info.html");
	}
	
	public void add(){
		
	}
	
	//增加
	public void save() {
		getModel(JobInfo.class).save();
		redirect("/jobinfo");
	}
	
	public void edit() {
		setAttr("jobinfo", JobInfo.jobinfo.findById(getParaToInt()));
	}
	
	
	//更新 (没做好)
	public void update() {
		getModel(JobInfo.class).update();
		redirect("/jobinfo");
	}
	
	//删除
	public void delete() {
		JobInfo.jobinfo.deleteById(getParaToInt());
		redirect("/jobinfo");
	}
}
