package com.jobinfo;

import com.jfinal.core.Controller;

public class JobInfoController extends Controller {
	
	public void index() {
		setAttr("jobinfoPage", JobInfo.jobinfo.paginate(getParaToInt(0, 1), 50));//��ҳ
		render("job_info.html");
	}
	
	public void add(){
		
	}
	
	//����
	public void save() {
		getModel(JobInfo.class).save();
		redirect("/jobinfo");
	}
	
	public void edit() {
		setAttr("jobinfo", JobInfo.jobinfo.findById(getParaToInt()));
	}
	
	
	//���� (û����)
	public void update() {
		getModel(JobInfo.class).update();
		redirect("/jobinfo");
	}
	
	//ɾ��
	public void delete() {
		JobInfo.jobinfo.deleteById(getParaToInt());
		redirect("/jobinfo");
	}
}
