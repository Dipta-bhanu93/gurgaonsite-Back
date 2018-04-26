package com.dipta.project.exception.base;

import com.dipta.project.exception.common.InvalidFileException;
import com.dipta.project.exception.common.InvalidKeyException;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public interface IErrorCode {
	String getErrorCode() throws InvalidKeyException,InvalidFileException;
}
