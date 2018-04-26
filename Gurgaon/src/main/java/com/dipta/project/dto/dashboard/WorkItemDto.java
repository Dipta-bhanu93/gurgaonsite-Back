package com.dipta.project.dto.dashboard;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
//import com.dipta.project.dto.ticketManagement.NotificationDto;

@XmlRootElement(name = "WorkItemDto")
@JsonRootName(value = "WorkItemDto")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ArrayList.class,WorkItemTicketDto.class,WorkItemNotificationDto.class,WorkItemWorkFlowDto.class})
public class WorkItemDto {
@Getter	@Setter	@XmlElement(name = "tickets")	@JsonProperty(value = "tickets")
private ArrayList<WorkItemTicketDto> tickets=new ArrayList<>();
//@Getter	@Setter	@XmlElement(name = "notifications")	@JsonProperty(value = "notifications")
//private ArrayList<NotificationDto> notifications=new ArrayList<>();
@Getter	@Setter	@XmlElement(name = "workflows")	@JsonProperty(value = "workflows")
private ArrayList<WorkItemWorkFlowDto> workflows=new ArrayList<>();
@Getter @Setter @XmlElement(name = "UnreadCount") @JsonProperty(value = "UnreadCount") private int unreadCount;
}
