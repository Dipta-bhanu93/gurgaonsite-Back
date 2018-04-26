package com.dipta.project.dto.dashboard;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.dipta.project.serializers.JsonDateSerializer;
import com.dipta.project.serializers.XmlDateAdapter;

@XmlRootElement(name = "WorkItemNotificationDto")
@JsonRootName(value = "WorkItemNotificationDto")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({Date.class})
public class WorkItemNotificationDto {
	@Getter	@Setter	@XmlElement(name = "TicketId")	@JsonProperty(value = "TicketId")
	private Long ticketId;
	@Getter	@Setter	@XmlElement(name = "Notification")	@JsonProperty(value = "Notification")
	private String notification;
	@Getter
	@Setter
	@XmlElement(name = "UpdatedDate")
	@JsonProperty(value = "UpdatedDate")
	@JsonSerialize(using=JsonDateSerializer.class)
	@XmlJavaTypeAdapter(XmlDateAdapter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private Date updatedDate;
}
