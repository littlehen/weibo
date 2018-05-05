package com.nit.weibo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.nit.weibo.dao.ContentKeyMapper;
import com.nit.weibo.dao.ContentMapper;
import com.nit.weibo.dao.WeiboMapper;
import com.nit.weibo.dto.DataTableDto;
import com.nit.weibo.dto.FunctionsDto;
import com.nit.weibo.dto.PinglunDto;
import com.nit.weibo.dto.ShenheDto;
import com.nit.weibo.model.ContentKeyWithBLOBs;
import com.nit.weibo.model.Functions;
import com.nit.weibo.model.Weibo;
import com.nit.weibo.service.IShenheService;

@Service
public class ShenheService implements IShenheService {

	@Resource
	private WeiboMapper weiboDao;
	
	@Resource
	private ContentMapper contentDao;
	
	@Resource
	private ContentKeyMapper contentKeyDao;
	

	@Override
	public Integer getInfoCount(String search) throws Exception {
		Integer resultCount = 0;
		if(search=="")
			resultCount = this.contentKeyDao.getCount();
		else
			resultCount = this.contentKeyDao.getCount2(search);
		return resultCount;
	}

	@Override
	public List<ShenheDto> getInfoDataTable(DataTableDto dataTableDto) throws Exception {
		String s=dataTableDto.getSearch();
		Integer page = 0;
		if(dataTableDto.length!=-1) {
			dataTableDto.start = dataTableDto.start == null ? 1 : dataTableDto.start;
			dataTableDto.length = dataTableDto.length == null ? 10 : dataTableDto.length;
			page = (dataTableDto.start / dataTableDto.length) + 1; //第几页
			PageHelper.startPage(page, dataTableDto.length);
		}
		List<ShenheDto> list=null;
		if(s==""){
			list=this.contentKeyDao.getDataTable();
		}
		else{
			list=this.contentKeyDao.getDataTable2(s);
		}
		return list;
	}

	@Override
	public Integer getwbInfoCount(Integer userId) throws Exception {
		return weiboDao.getCount(userId);
		
	}

	@Override
	public List<Weibo> getwbInfoDataTable(DataTableDto dataTableDto, Integer userId) throws Exception {
		Integer page = 0;
		if(dataTableDto.length!=-1) {
			dataTableDto.start = dataTableDto.start == null ? 1 : dataTableDto.start;
			dataTableDto.length = dataTableDto.length == null ? 10 : dataTableDto.length;
			page = (dataTableDto.start / dataTableDto.length) + 1; //第几页
			PageHelper.startPage(page, dataTableDto.length);
		}
		List<Weibo> list=null;
		list=this.weiboDao.getDataTable(userId);
		return list;
	}

	@Override
	public Weibo getwbmain(Integer userId) throws Exception {
		return weiboDao.selectByUserId(userId);
	}

	@Override
	public Object getwbShenhe(Integer id, Integer status) throws Exception {
		if(status == 1)
		{
			Weibo res = weiboDao.selectByPrimaryKey(id);
			if(res.getIsMain() == 2)
			{
				weiboDao.UpdateSelectByUserId(res.getUserId());
			}
		}
		Weibo record = new Weibo();
		record.setWeiboId(id);
		record.setIsFinish(status);
		return weiboDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer getzInfoCount(Integer userId) throws Exception {
		return contentKeyDao.getzCount(userId);
	}

	@Override
	public List<ContentKeyWithBLOBs> getzInfoDataTable(DataTableDto dataTableDto, Integer userId) throws Exception {
		Integer page = 0;
		if(dataTableDto.length!=-1) {
			dataTableDto.start = dataTableDto.start == null ? 1 : dataTableDto.start;
			dataTableDto.length = dataTableDto.length == null ? 10 : dataTableDto.length;
			page = (dataTableDto.start / dataTableDto.length) + 1; //第几页
			PageHelper.startPage(page, dataTableDto.length);
		}
		List<ContentKeyWithBLOBs> list=null;
		list=this.contentKeyDao.getzDataTable(userId);
		return list;
	}

	@Override
	public Object getzShenhe(Integer id, Integer status) throws Exception {
		ContentKeyWithBLOBs record = new ContentKeyWithBLOBs();
		record.setContentKeyId(id);
		record.setIsZanFinish(status);
		return contentKeyDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer getplInfoCount(Integer userId) throws Exception {
		return contentKeyDao.getplCount(userId);
	}

	@Override
	public List<PinglunDto> getplInfoDataTable(DataTableDto dataTableDto, Integer userId) throws Exception {
		Integer page = 0;
		if(dataTableDto.length!=-1) {
			dataTableDto.start = dataTableDto.start == null ? 1 : dataTableDto.start;
			dataTableDto.length = dataTableDto.length == null ? 10 : dataTableDto.length;
			page = (dataTableDto.start / dataTableDto.length) + 1; //第几页
			PageHelper.startPage(page, dataTableDto.length);
		}
		List<PinglunDto> list=null;
		list=this.contentKeyDao.getplDataTable(userId);
		for(int i = 0; i < list.size(); i++)
		{
			String t1 = list.get(i).getContentId();
			String t2 = list.get(i).getContentFuId();
			list.get(i).setContent(contentDao.selectList(t1));
			list.get(i).setContentFu(contentDao.selectList(t2));
		}
		return list;
	}

	@Override
	public Object getplShenhe(Integer id, Integer status) throws Exception {
		ContentKeyWithBLOBs record = new ContentKeyWithBLOBs();
		record.setContentKeyId(id);
		record.setIsFinish(status);
		return contentKeyDao.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public Integer getgnInfoCount(Integer userId) throws Exception {
		return contentKeyDao.getgnCount(userId);
	}
	
	@Override
	public List<FunctionsDto> getgnInfoDataTable(DataTableDto dataTableDto, Integer userId) throws Exception {
		Integer page = 0;
		if(dataTableDto.length!=-1) {
			dataTableDto.start = dataTableDto.start == null ? 1 : dataTableDto.start;
			dataTableDto.length = dataTableDto.length == null ? 10 : dataTableDto.length;
			page = (dataTableDto.start / dataTableDto.length) + 1; //第几页
			PageHelper.startPage(page, dataTableDto.length);
		}
		List<FunctionsDto> list=null;
		list=this.weiboDao.getgnDataTable(userId);
		return list;
	}

	@Override
	public Object getgnShenhe(Integer id, Integer status) throws Exception {
		Functions functions = new Functions();
		functions.setFid(id);
		functions.setIsfinish(status);
		return weiboDao.updateByPrimaryKeyFunctions(functions);
	}
}
