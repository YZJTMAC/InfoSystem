<%@ page pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherChangeInfo.js"></script> 
<div class="tabformtitle"><span class="l">变更信息汇总</span> <span class="r"></span></div>
    
    <div class="contentBox">
    <table border="0" id="diferent" cellspacing="0" cellpadding="0" style="display:block;" class="tab1">
    </table>
    </div>
    
    <div class="tabformtitle"><span class="l">基本信息</span> <span class="r"></span></div>
    
    <div class="contentBox">
    <table border="0" cellspacing="0" cellpadding="0" style="display:block;" class="tab1">
      <tr>
        <td id="teacherOldName_htm" width="85">曾用名：</td> 
        <td width="202" id="teacherOldName"></td>
        <td width="27">&nbsp;</td>
        <td id="teacherNameSpelling_htm" width="73">姓名全拼：</td>
        <td width="213" id="teacherNameSpelling"></td>
      </tr>
      <tr>
        <td id="teacherBornDate_htm">出生日期：</td>
        <td id="teacherBornDate"></td>
        <td>&nbsp;</td>
        <td id="teacherPoliticalStatus_htm">政治面貌：</td>
        <td id="teacherPoliticalStatus"></td>
      </tr>
      <tr>
        <td id="teacherNativePlace_htm">籍 贯：</td>
        <td id="teacherNativePlace"></td>
        <td>&nbsp;</td>
        <td id="teacherNation_htm">民 族：</td>
        <td id="teacherNation"></td>
      </tr>
      <tr>
        <td id="teacherPhoneNum_htm">手机号码：</td>
        <td id="teacherPhoneNum"></td>
        <td>&nbsp;</td>
        <td id="teacherCallNum_htm">联系电话：</td>
        <td id="teacherCallNum"></td>
      </tr>
      <tr>
        <td id="teacherQq_htm">QQ：</td>
        <td id="teacherQq"></td>
        <td>&nbsp;</td>
        <td id="teacherEmail_htm">Email：</td>
        <td id="teacherEmail"></td>
      </tr>
      <tr>
        <td id="teacherFamilyLocal_htm">家庭住址：</td>
        <td id="teacherFamilyLocal"></td>
        <td>&nbsp;</td>
        <td id="teacherMaritalStatus_htm">婚姻状况：</td>
        <td id="teacherMaritalStatus"></td>
      </tr>
      <tr>
        <td id="teacherHealthCondition_htm">健康状况</td>
        <td id="teacherHealthCondition"></td>
        <td>&nbsp;</td>
        <td id="partyTime_htm">入党时间：</td>
        <td id="partyTime"></td>
      </tr>
    </table>
    </div>
    
     <div class="tabformtitle"><span class="l">教育经历</span> <span class="r"></span></div>
    
    <div class="contentBox">
    <table border="0" id="educationId" cellspacing="0" cellpadding="0" style="display:block;" class="tab1">
      </table>
    </div>
    
    
    
   <div class="tabformtitle"><span class="l">工作信息</span> <span class="r"></span></div>
    
    <div class="contentBox">
    <table width="645" border="0" cellpadding="0" cellspacing="0" class="tab1" style="display:block;">
      <tr>
        <td width="139" id="jobQualification_htm">教师资格种类：</td>
        <td width="169" id="jobQualification"></td>
        <td width="10">&nbsp;</td>
        <td width="113" id="jobCertificateDate_htm">获教师资格证时间：</td>
        <td width="169" id="jobCertificateDate"></td>
      </tr>
      <tr>
        <td id="jobCertificateNum_htm">教师资格证书号：</td>
        <td id="jobCertificateNum"></td>
        <td>&nbsp;</td>
        <td id="jobWorkTime_htm">参加工作时间：</td>
        <td id="jobWorkTime"></td>
      </tr>
       <tr>
        <td width="139" id="adjustName_htm">教师编制：</td>
        <td width="169" id="adjustName"></td>
        <td width="10">&nbsp;</td>
        <td width="113" id="">&nbsp;</td>
        <td width="169" id="">&nbsp;</td>
      </tr>
      <tr>
        <td id="jobWorkDate_htm">本校任教起始时间：</td>
        <td id="jobWorkDate"></td>
        <td>&nbsp;</td>
        <td id="jobCommentPosition_htm">(评)教师职称：</td>
        <td id="jobCommentPosition"></td>
      </tr>
      <tr>
        <td id="jobCommentDate_htm">(评)职称时间：</td>
        <td id="jobCommentDate"></td>
        <td>&nbsp;</td>
        <td id="jobRecruitmentPosition_htm">(聘)教师职称：</td>
        <td id="jobRecruitmentPosition"></td>
      </tr>
      <tr>
        <td id="jobRecruitmentDate_htm">(聘)职称时间：</td>
        <td id="jobRecruitmentDate"></td>
        <td>&nbsp;</td>
        <td id="jobSchoolAdministrationOffice_htm">学校行政职务：</td>
        <td id="jobSchoolAdministrationOffice"></td>
      </tr>
      <tr>
        <td id="jobFormerTeachingSection_htm">当前任教学段：</td>
        <td id="jobFormerTeachingSection"></td>
        <td>&nbsp;</td>
        <td id="jobFormerTeachingSubject_htm">当前任教学科：</td>
        <td id="jobFormerTeachingSubject"></td>
      </tr>
      <tr>
        <td id="jobSubjectLeader_htm">学科带头人：</td>
        <td id="jobSubjectLeader"></td>
        <td>&nbsp;</td>
        <td id="jobCoreTeacher_htm">骨干教师：</td>
        <td id="jobCoreTeacher"></td>
      </tr>
      <tr>
        <td id="jobWhetherTeacher_htm">是否为班主任：</td>
        <td id="jobWhetherTeacher"></td>
        <td>&nbsp;</td>
        <td id="jobWhetherGradeTeacher_htm">是否为特级教师：</td>
        <td id="jobWhetherGradeTeacher"></td>
      </tr>
      <tr>
        <td id="jobCountyRuralTeacher_htm">国培计划农村骨干教师：</td>
        <td id="jobCountyRuralTeacher"></td>
        <td>&nbsp;</td>
        <td id="jobPrivateSchoolTeacher_htm">民办学校专职教师：</td>
        <td id="jobPrivateSchoolTeacher"></td>
      </tr>
      <tr>
        <td id="jobSpecialTeacher_htm">特岗教师：</td>
        <td id="jobSpecialTeacher"></td>
        <td>&nbsp;</td>
        <td id="jdfldw_htm">借调分流单位:</td>
        <td id="jdfldw"></td>
      </tr>
      <tr>
        <td id="eliteTraining_htm">是否名校长培养对象:</td>
        <td id="eliteTraining"></td>
        <td>&nbsp;</td>
        <td id="teachingMaster_htm">是否教学名师： </td>
        <td id="teachingMaster"></td>
      </tr>
      <tr>
        <td id="postGrade_htm">聘任岗位等级时间:</td>
        <td id="postGrade"></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
    
    <div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" ></div>
    </div> 
    <!-- 
     <ul class="forminfo">
    
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="返回" onclick="window.open('teacherMegT_1.6.html','rightFrame')"/></li>
    </ul>
     -->