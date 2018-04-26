package com.dipta.project.dao.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dipta.project.dao.base.DaoBaseInterface;
import com.dipta.project.domain.project.CodAttributesDomain;
import com.dipta.project.domain.project.ProjectConfigDomain;
import com.dipta.project.domain.project.ProjectExecutionDomain;
import com.dipta.project.dto.crossReference.ProjectFeedDto;
import com.dipta.project.dto.file.FileDataDTO;
import com.dipta.project.dto.hierarchy.HierarchyEntityDTO;
import com.dipta.project.dto.project.config.ProjectConfigXrefDto;
import com.dipta.project.dto.project.execute.ProjectExecutionDto;
import com.dipta.project.dto.project.execute.ProjectSkippedFeed;
import com.dipta.project.dto.project.template.ProjectTemplateCountsDto;
import com.dipta.project.dto.project.template.ProjectTemplateMasterDto;
import com.dipta.project.dto.project.template.ProjectTemplateSearchGridDto;
import com.dipta.project.dto.user.UserProjectCollection;
import com.dipta.project.dto.workflow.ProjectDTO;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.project.ProjectConfigNotFoundException;
import com.dipta.project.exception.project.ProjectCreationFailedException;
import com.dipta.project.exception.project.ProjectDoesNotExistsException;
import com.dipta.project.exception.project.SaveProjectConfigException;

/**
 * 
 * @author saurabh.agarwal
 *
 */
public interface IProjectDao extends DaoBaseInterface {
	
}
