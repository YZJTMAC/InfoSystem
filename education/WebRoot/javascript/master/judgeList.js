<td>$date.format("yyyy-MM-dd",$!projectSummary.projectEndDate)</td>
				<td>$!projectSummary.projectTrainPeriod</td>		
				<td>$!projectSummary.projectCharge</td>		
				<td>$!projectSummary.projectExpectedNum</td>		
				<td>$!projectSummary.projectLiveNum</td>		
				<td>$!projectSummary.predictTotalAmount</td>		
				<td>$!projectSummary.projectRealTotalAmount</td>	
				<td>#if($!projectSummary.projectStatus == 0 ) 审批中或者草稿中  #elseif($!projectSummary.projectStatus == 1) 进行中  #elseif($!projectSummary.projectStatus == 2) 已结束  #elseif($!projectSummary.projectStatus == 3) 正在走完结流程  #elseif($!projectSummary.projectStatus == 4) 待完结  #end</td>		
				<td>#if($projectSummary.projectProtocolName) 有  #else 无 #end</td>
				<!--项目实际到款总额-->
				#foreach($projectYearSum in $projectSummary.projectYearSummarys)
					<td>#if(!$!projectYearSum.paymentamount) - #else $!projectYearSum.paymentamount #end</td>
				#end
				<td>$!projectSummary.realPaymentAmount</td>
				<td>$!projectSummary.predictLaterPayment</td>
				<td>$!projectSummary.predictReceiveAmount</td>
				<!--累计收入-->
				#foreach($projectYearSum in $projectSummary.projectYearSummarys)
					#if($velocityCount > 3)
					<td>#if(!$!projectYearSum.incomeamount) - #else $!projectYearSum.incomeamount #end</td>
					#end
				#end
				<td>$!projectSummary.realIncomeAmount</td>
				<td>$!projectSummary.proFundProportion</td>
				<td>$!projectSummary.laterFundProportion</td>
				<td>$!projectSummary.proFundAmount</td>
				<td>$!projectSummary.laterFundAmount</td>
				<!--支付经费金额-->
				#foreach($projectYearSum in $projectSummary.projectYearSummarys)
					<td>#if(!$!projectYearSum.fundYearMoney) - #else $!projectYearSum.fundYearMoney #end</td>
				#end
				<td>$!projectSummary.realFundAmount</td>
				<td style="#if($!projectSummary.nopayFundAmount<0)color:red; #end" >$!projectSummary.nopayFundAmount</td>
				<!--运营成本-->
				<td>#if(!$!projectSummary.predictBudget) 0.00 #else $!projectSummary.predictBudget #end</td>
				#foreach($projectYearSum in $projectSummary.projectYearSummarys)
					<td>#if(!$!projectYearSum.budgetamount) - #else $!projectYearSum.budgetamount #end</td>
				#end
				<td>$!projectSummary.realBudgetAmount</td>
				<!--结转成本-->
				#foreach($projectYearSum in $projectSummary.projectYearSummarys)
					<td>#if(!$!projectYearSum.overamount) - #else $!projectYearSum.overamount #end</td>
				#end
				<td>$!projectSummary.realCostAmount</td>
				<!--开票金额-->
				#foreach($projectYearSum in $projectSummary.projectYearSummarys)
					<td>#if(!$!projectYearSum.invoiceamount) - #else $!projectYearSum.invoiceamount #end</td>
				#end
				<td>$!projectSummary.realInvoiceAmount</td>
				<td>$!projectSummary.noInvoiceAmount</td>
				<td style="#if($!projectSummary.fundError<0)color:red; #end" >$!projectSummary.fundError</td>
				<td>$!projectSummary.note</td>
				<td>$!projectSummary.url</td>