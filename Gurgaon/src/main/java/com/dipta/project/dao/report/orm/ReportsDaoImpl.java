package com.dipta.project.dao.report.orm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.text.WordUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.util.StringUtils;

import com.dipta.project.dao.base.AliasToEntityOrderedMapResultTransformer;
import com.dipta.project.dao.base.DaoManager;
import com.dipta.project.dao.base.orm.AbstractBaseDao;
import com.dipta.project.dao.crossReference.ICrossRefDao;
import com.dipta.project.dao.project.IProjectDao;
import com.dipta.project.dao.report.IReportDao;
import com.dipta.project.dao.user.orm.UserDaoImpl;
import com.dipta.project.domain.company.CounterpartyGoldDomain;
import com.dipta.project.domain.company.GoldDataCoverageDomain;
import com.dipta.project.domain.file.FileDataDomain;
import com.dipta.project.domain.file.FileGenerationQueryDomain;

import com.dipta.project.domain.project.GeneratedReportsDomain;
import com.dipta.project.domain.project.ProjectConfigDomain;
import com.dipta.project.domain.project.ProjectMatchStatsDomain;
import com.dipta.project.domain.project.UserProjectDomain;
import com.dipta.project.dto.common.FileReportDto;
import com.dipta.project.dto.common.RowDto;
import com.dipta.project.dto.crossReference.FeedMasterDto;
import com.dipta.project.dto.dashboard.DashboardDto;
import com.dipta.project.dto.dashboard.GoldDataCoverageDto;
import com.dipta.project.dto.dashboard.GoldDataCoverageDtoCollection;
import com.dipta.project.dto.dashboard.GoldDataTypeDto;
import com.dipta.project.dto.dashboard.GoldWidgetDto;
import com.dipta.project.dto.dashboard.PlatinumDataCoverageDto;
import com.dipta.project.dto.dashboard.PlatinumDataCoverageDtoCollection;
import com.dipta.project.dto.dashboard.PlatinumDataTypeDto;
import com.dipta.project.dto.file.FileDataDTO;
import com.dipta.project.dto.project.config.ProjectConfigXrefDto;

import com.dipta.project.dto.workflow.ProjectDTO;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.project.ProjectConfigNotFoundException;
import com.dipta.project.exception.project.ProjectDoesNotExistsException;

import com.dipta.project.utility.CommonUtils;
import com.dipta.project.utility.constants.CommonConstants;
import com.dipta.project.utility.constants.FileConstants;
import com.dipta.project.utility.constants.ProjectConfigEnum;




@Slf4j
public class ReportsDaoImpl  extends AbstractBaseDao implements IReportDao{

	public ReportsDaoImpl(String tenantEmail) {
		super(tenantEmail);
	}
	
	public ReportsDaoImpl(Long clientsID) {
		super(clientsID);
	}
}
