package com.dipta.project.dao.crossReference;

import java.util.ArrayList;
import java.util.List;

import com.dipta.project.dao.base.DaoBaseInterface;
import com.dipta.project.dto.crossReference.EtlFeedMatchingDetailDto;
import com.dipta.project.dto.crossReference.EtlFileMetaDataDto;
import com.dipta.project.dto.crossReference.EtlIDRuleDetailDto;
import com.dipta.project.dto.crossReference.EtlIDRuleMasterDto;
import com.dipta.project.dto.crossReference.EtlMatchMasterColumnsCollectionDto;
import com.dipta.project.dto.crossReference.EtlMatchMasterColumnsDto;
import com.dipta.project.dto.crossReference.EtlPrestageMapDto;
import com.dipta.project.dto.crossReference.EtlPrestageMasterDto;
import com.dipta.project.dto.crossReference.EtlStageFieldMapDto;
import com.dipta.project.dto.crossReference.EtlTransformMasterDto;
import com.dipta.project.dto.crossReference.FeedMasterDto;
import com.dipta.project.dto.crossReference.FeedMasterDtoCollection;
import com.dipta.project.dto.crossReference.ProjectFeedDto;
import com.dipta.project.dto.crossReference.ReplaceCategoryCollection;
import com.dipta.project.dto.crossReference.ReplaceCategoryDto;
import com.dipta.project.dto.project.config.ProjectConfigXrefDto;
import com.dipta.project.dto.workflow.ProjectDTO;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.crossReference.DuplicateFeedTypeException;
import com.dipta.project.exception.crossReference.DuplicateMappingNameException;

/**
 * @author Ashish.Patel
 *
 */
public interface ICrossRefDao extends DaoBaseInterface {
	

}
