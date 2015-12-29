package com.jobinfo;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class JobInfo extends Model<JobInfo>{
	public static final JobInfo jobinfo = new JobInfo();
	
	public Page<JobInfo> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from jobinfo order by id asc");
	}
}
