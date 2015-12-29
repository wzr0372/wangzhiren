package com.common;


import com.index.IndexController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jobinfo.JobInfo;
import com.jobinfo.JobInfoController;

public class JobInfoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
				PropKit.use("a_little_config.txt");
				me.setDevMode(PropKit.getBoolean("devMode", true));
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/",IndexController.class);
		me.add("/jobinfo",JobInfoController.class,"/jobinfo");  
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("jobinfo", JobInfo.class);	

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}
