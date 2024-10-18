package com.example.projectbase.service;

import com.example.projectbase.domain.dto.request.TabCreateDto;
import com.example.projectbase.domain.dto.request.TabRenameDto;
import com.example.projectbase.domain.dto.response.CommonResponseDto;
import com.example.projectbase.domain.dto.response.TabResponseDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface TabService {
    TabResponseDto createTab(TabCreateDto tabCreateDto) throws ValidationException;
    List<TabResponseDto> getTabsByUserId(String userId);
    TabResponseDto renameTab(TabRenameDto tabRenameDto);
    CommonResponseDto deleteTab(String tabId);
}
