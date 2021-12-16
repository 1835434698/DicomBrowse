/*      */ package org.dcm4che3.data;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Keyword
/*      */ {
/*      */   public static String valueOf(int tag) {
/*   49 */     if ((tag & 0xFFFF) == 0 && (tag & 0xFFFD0000) != 0)
/*      */     {
/*   51 */       return "GroupLength"; } 
/*   52 */     if ((tag & 0x10000) != 0) {
/*   53 */       return ((tag & 0xFF00) == 0 && (tag & 0xF0) != 0) ? "PrivateCreatorID" : "";
/*      */     }
/*      */ 
/*      */     
/*   57 */     if ((tag & 0xFFFFFF00) == 2109696)
/*   58 */       return "SourceImageIDs"; 
/*   59 */     int tmp = tag & 0xFFE00000;
/*   60 */     if (tmp == 1342177280 || tmp == 1610612736) {
/*   61 */       tag &= 0xFFE0FFFF;
/*   62 */     } else if ((tag & 0xFF000000) == 2130706432 && (tag & 0xFFFF0000) != 2145386496) {
/*      */       
/*   64 */       tag &= 0xFF00FFFF;
/*   65 */     }  switch (tag) {
/*      */       case 0:
/*   67 */         return "CommandGroupLength";
/*      */       case 1:
/*   69 */         return "CommandLengthToEnd";
/*      */       case 2:
/*   71 */         return "AffectedSOPClassUID";
/*      */       case 3:
/*   73 */         return "RequestedSOPClassUID";
/*      */       case 16:
/*   75 */         return "CommandRecognitionCode";
/*      */       case 256:
/*   77 */         return "CommandField";
/*      */       case 272:
/*   79 */         return "MessageID";
/*      */       case 288:
/*   81 */         return "MessageIDBeingRespondedTo";
/*      */       case 512:
/*   83 */         return "Initiator";
/*      */       case 768:
/*   85 */         return "Receiver";
/*      */       case 1024:
/*   87 */         return "FindLocation";
/*      */       case 1536:
/*   89 */         return "MoveDestination";
/*      */       case 1792:
/*   91 */         return "Priority";
/*      */       case 2048:
/*   93 */         return "CommandDataSetType";
/*      */       case 2128:
/*   95 */         return "NumberOfMatches";
/*      */       case 2144:
/*   97 */         return "ResponseSequenceNumber";
/*      */       case 2304:
/*   99 */         return "Status";
/*      */       case 2305:
/*  101 */         return "OffendingElement";
/*      */       case 2306:
/*  103 */         return "ErrorComment";
/*      */       case 2307:
/*  105 */         return "ErrorID";
/*      */       case 4096:
/*  107 */         return "AffectedSOPInstanceUID";
/*      */       case 4097:
/*  109 */         return "RequestedSOPInstanceUID";
/*      */       case 4098:
/*  111 */         return "EventTypeID";
/*      */       case 4101:
/*  113 */         return "AttributeIdentifierList";
/*      */       case 4104:
/*  115 */         return "ActionTypeID";
/*      */       case 4128:
/*  117 */         return "NumberOfRemainingSuboperations";
/*      */       case 4129:
/*  119 */         return "NumberOfCompletedSuboperations";
/*      */       case 4130:
/*  121 */         return "NumberOfFailedSuboperations";
/*      */       case 4131:
/*  123 */         return "NumberOfWarningSuboperations";
/*      */       case 4144:
/*  125 */         return "MoveOriginatorApplicationEntityTitle";
/*      */       case 4145:
/*  127 */         return "MoveOriginatorMessageID";
/*      */       case 16384:
/*  129 */         return "DialogReceiver";
/*      */       case 16400:
/*  131 */         return "TerminalType";
/*      */       case 20496:
/*  133 */         return "MessageSetID";
/*      */       case 20512:
/*  135 */         return "EndMessageID";
/*      */       case 20752:
/*  137 */         return "DisplayFormat";
/*      */       case 20768:
/*  139 */         return "PagePositionID";
/*      */       case 20784:
/*  141 */         return "TextFormatID";
/*      */       case 20800:
/*  143 */         return "NormalReverse";
/*      */       case 20816:
/*  145 */         return "AddGrayScale";
/*      */       case 20832:
/*  147 */         return "Borders";
/*      */       case 20848:
/*  149 */         return "Copies";
/*      */       case 20864:
/*  151 */         return "CommandMagnificationType";
/*      */       case 20880:
/*  153 */         return "Erase";
/*      */       case 20896:
/*  155 */         return "Print";
/*      */       case 20912:
/*  157 */         return "Overlays";
/*      */       case 131072:
/*  159 */         return "FileMetaInformationGroupLength";
/*      */       case 131073:
/*  161 */         return "FileMetaInformationVersion";
/*      */       case 131074:
/*  163 */         return "MediaStorageSOPClassUID";
/*      */       case 131075:
/*  165 */         return "MediaStorageSOPInstanceUID";
/*      */       case 131088:
/*  167 */         return "TransferSyntaxUID";
/*      */       case 131090:
/*  169 */         return "ImplementationClassUID";
/*      */       case 131091:
/*  171 */         return "ImplementationVersionName";
/*      */       case 131094:
/*  173 */         return "SourceApplicationEntityTitle";
/*      */       case 131095:
/*  175 */         return "SendingApplicationEntityTitle";
/*      */       case 131096:
/*  177 */         return "ReceivingApplicationEntityTitle";
/*      */       case 131328:
/*  179 */         return "PrivateInformationCreatorUID";
/*      */       case 131330:
/*  181 */         return "PrivateInformation";
/*      */       case 266544:
/*  183 */         return "FileSetID";
/*      */       case 266561:
/*  185 */         return "FileSetDescriptorFileID";
/*      */       case 266562:
/*  187 */         return "SpecificCharacterSetOfFileSetDescriptorFile";
/*      */       case 266752:
/*  189 */         return "OffsetOfTheFirstDirectoryRecordOfTheRootDirectoryEntity";
/*      */       case 266754:
/*  191 */         return "OffsetOfTheLastDirectoryRecordOfTheRootDirectoryEntity";
/*      */       case 266770:
/*  193 */         return "FileSetConsistencyFlag";
/*      */       case 266784:
/*  195 */         return "DirectoryRecordSequence";
/*      */       case 267264:
/*  197 */         return "OffsetOfTheNextDirectoryRecord";
/*      */       case 267280:
/*  199 */         return "RecordInUseFlag";
/*      */       case 267296:
/*  201 */         return "OffsetOfReferencedLowerLevelDirectoryEntity";
/*      */       case 267312:
/*  203 */         return "DirectoryRecordType";
/*      */       case 267314:
/*  205 */         return "PrivateRecordUID";
/*      */       case 267520:
/*  207 */         return "ReferencedFileID";
/*      */       case 267524:
/*  209 */         return "MRDRDirectoryRecordOffset";
/*      */       case 267536:
/*  211 */         return "ReferencedSOPClassUIDInFile";
/*      */       case 267537:
/*  213 */         return "ReferencedSOPInstanceUIDInFile";
/*      */       case 267538:
/*  215 */         return "ReferencedTransferSyntaxUIDInFile";
/*      */       case 267546:
/*  217 */         return "ReferencedRelatedGeneralSOPClassUIDInFile";
/*      */       case 267776:
/*  219 */         return "NumberOfReferences";
/*      */       case 524289:
/*  221 */         return "LengthToEnd";
/*      */       case 524293:
/*  223 */         return "SpecificCharacterSet";
/*      */       case 524294:
/*  225 */         return "LanguageCodeSequence";
/*      */       case 524296:
/*  227 */         return "ImageType";
/*      */       case 524304:
/*  229 */         return "RecognitionCode";
/*      */       case 524306:
/*  231 */         return "InstanceCreationDate";
/*      */       case 524307:
/*  233 */         return "InstanceCreationTime";
/*      */       case 524308:
/*  235 */         return "InstanceCreatorUID";
/*      */       case 524309:
/*  237 */         return "InstanceCoercionDateTime";
/*      */       case 524310:
/*  239 */         return "SOPClassUID";
/*      */       case 524312:
/*  241 */         return "SOPInstanceUID";
/*      */       case 524314:
/*  243 */         return "RelatedGeneralSOPClassUID";
/*      */       case 524315:
/*  245 */         return "OriginalSpecializedSOPClassUID";
/*      */       case 524320:
/*  247 */         return "StudyDate";
/*      */       case 524321:
/*  249 */         return "SeriesDate";
/*      */       case 524322:
/*  251 */         return "AcquisitionDate";
/*      */       case 524323:
/*  253 */         return "ContentDate";
/*      */       case 524324:
/*  255 */         return "OverlayDate";
/*      */       case 524325:
/*  257 */         return "CurveDate";
/*      */       case 524330:
/*  259 */         return "AcquisitionDateTime";
/*      */       case 524336:
/*  261 */         return "StudyTime";
/*      */       case 524337:
/*  263 */         return "SeriesTime";
/*      */       case 524338:
/*  265 */         return "AcquisitionTime";
/*      */       case 524339:
/*  267 */         return "ContentTime";
/*      */       case 524340:
/*  269 */         return "OverlayTime";
/*      */       case 524341:
/*  271 */         return "CurveTime";
/*      */       case 524352:
/*  273 */         return "DataSetType";
/*      */       case 524353:
/*  275 */         return "DataSetSubtype";
/*      */       case 524354:
/*  277 */         return "NuclearMedicineSeriesType";
/*      */       case 524368:
/*  279 */         return "AccessionNumber";
/*      */       case 524369:
/*  281 */         return "IssuerOfAccessionNumberSequence";
/*      */       case 524370:
/*  283 */         return "QueryRetrieveLevel";
/*      */       case 524371:
/*  285 */         return "QueryRetrieveView";
/*      */       case 524372:
/*  287 */         return "RetrieveAETitle";
/*      */       case 524374:
/*  289 */         return "InstanceAvailability";
/*      */       case 524376:
/*  291 */         return "FailedSOPInstanceUIDList";
/*      */       case 524384:
/*  293 */         return "Modality";
/*      */       case 524385:
/*  295 */         return "ModalitiesInStudy";
/*      */       case 524386:
/*  297 */         return "SOPClassesInStudy";
/*      */       case 524388:
/*  299 */         return "ConversionType";
/*      */       case 524392:
/*  301 */         return "PresentationIntentType";
/*      */       case 524400:
/*  303 */         return "Manufacturer";
/*      */       case 524416:
/*  305 */         return "InstitutionName";
/*      */       case 524417:
/*  307 */         return "InstitutionAddress";
/*      */       case 524418:
/*  309 */         return "InstitutionCodeSequence";
/*      */       case 524432:
/*  311 */         return "ReferringPhysicianName";
/*      */       case 524434:
/*  313 */         return "ReferringPhysicianAddress";
/*      */       case 524436:
/*  315 */         return "ReferringPhysicianTelephoneNumbers";
/*      */       case 524438:
/*  317 */         return "ReferringPhysicianIdentificationSequence";
/*      */       case 524544:
/*  319 */         return "CodeValue";
/*      */       case 524545:
/*  321 */         return "ExtendedCodeValue";
/*      */       case 524546:
/*  323 */         return "CodingSchemeDesignator";
/*      */       case 524547:
/*  325 */         return "CodingSchemeVersion";
/*      */       case 524548:
/*  327 */         return "CodeMeaning";
/*      */       case 524549:
/*  329 */         return "MappingResource";
/*      */       case 524550:
/*  331 */         return "ContextGroupVersion";
/*      */       case 524551:
/*  333 */         return "ContextGroupLocalVersion";
/*      */       case 524552:
/*  335 */         return "ExtendedCodeMeaning";
/*      */       case 524555:
/*  337 */         return "ContextGroupExtensionFlag";
/*      */       case 524556:
/*  339 */         return "CodingSchemeUID";
/*      */       case 524557:
/*  341 */         return "ContextGroupExtensionCreatorUID";
/*      */       case 524559:
/*  343 */         return "ContextIdentifier";
/*      */       case 524560:
/*  345 */         return "CodingSchemeIdentificationSequence";
/*      */       case 524562:
/*  347 */         return "CodingSchemeRegistry";
/*      */       case 524564:
/*  349 */         return "CodingSchemeExternalID";
/*      */       case 524565:
/*  351 */         return "CodingSchemeName";
/*      */       case 524566:
/*  353 */         return "CodingSchemeResponsibleOrganization";
/*      */       case 524567:
/*  355 */         return "ContextUID";
/*      */       case 524568:
/*  357 */         return "MappingResourceUID";
/*      */       case 524569:
/*  359 */         return "LongCodeValue";
/*      */       case 524576:
/*  361 */         return "URNCodeValue";
/*      */       case 524577:
/*  363 */         return "EquivalentCodeSequence";
/*      */       case 524801:
/*  365 */         return "TimezoneOffsetFromUTC";
/*      */       case 528384:
/*  367 */         return "NetworkID";
/*      */       case 528400:
/*  369 */         return "StationName";
/*      */       case 528432:
/*  371 */         return "StudyDescription";
/*      */       case 528434:
/*  373 */         return "ProcedureCodeSequence";
/*      */       case 528446:
/*  375 */         return "SeriesDescription";
/*      */       case 528447:
/*  377 */         return "SeriesDescriptionCodeSequence";
/*      */       case 528448:
/*  379 */         return "InstitutionalDepartmentName";
/*      */       case 528456:
/*  381 */         return "PhysiciansOfRecord";
/*      */       case 528457:
/*  383 */         return "PhysiciansOfRecordIdentificationSequence";
/*      */       case 528464:
/*  385 */         return "PerformingPhysicianName";
/*      */       case 528466:
/*  387 */         return "PerformingPhysicianIdentificationSequence";
/*      */       case 528480:
/*  389 */         return "NameOfPhysiciansReadingStudy";
/*      */       case 528482:
/*  391 */         return "PhysiciansReadingStudyIdentificationSequence";
/*      */       case 528496:
/*  393 */         return "OperatorsName";
/*      */       case 528498:
/*  395 */         return "OperatorIdentificationSequence";
/*      */       case 528512:
/*  397 */         return "AdmittingDiagnosesDescription";
/*      */       case 528516:
/*  399 */         return "AdmittingDiagnosesCodeSequence";
/*      */       case 528528:
/*  401 */         return "ManufacturerModelName";
/*      */       case 528640:
/*  403 */         return "ReferencedResultsSequence";
/*      */       case 528656:
/*  405 */         return "ReferencedStudySequence";
/*      */       case 528657:
/*  407 */         return "ReferencedPerformedProcedureStepSequence";
/*      */       case 528661:
/*  409 */         return "ReferencedSeriesSequence";
/*      */       case 528672:
/*  411 */         return "ReferencedPatientSequence";
/*      */       case 528677:
/*  413 */         return "ReferencedVisitSequence";
/*      */       case 528688:
/*  415 */         return "ReferencedOverlaySequence";
/*      */       case 528692:
/*  417 */         return "ReferencedStereometricInstanceSequence";
/*      */       case 528698:
/*  419 */         return "ReferencedWaveformSequence";
/*      */       case 528704:
/*  421 */         return "ReferencedImageSequence";
/*      */       case 528709:
/*  423 */         return "ReferencedCurveSequence";
/*      */       case 528714:
/*  425 */         return "ReferencedInstanceSequence";
/*      */       case 528715:
/*  427 */         return "ReferencedRealWorldValueMappingInstanceSequence";
/*      */       case 528720:
/*  429 */         return "ReferencedSOPClassUID";
/*      */       case 528725:
/*  431 */         return "ReferencedSOPInstanceUID";
/*      */       case 528730:
/*  433 */         return "SOPClassesSupported";
/*      */       case 528736:
/*  435 */         return "ReferencedFrameNumber";
/*      */       case 528737:
/*  437 */         return "SimpleFrameList";
/*      */       case 528738:
/*  439 */         return "CalculatedFrameList";
/*      */       case 528739:
/*  441 */         return "TimeRange";
/*      */       case 528740:
/*  443 */         return "FrameExtractionSequence";
/*      */       case 528743:
/*  445 */         return "MultiFrameSourceSOPInstanceUID";
/*      */       case 528784:
/*  447 */         return "RetrieveURL";
/*      */       case 528789:
/*  449 */         return "TransactionUID";
/*      */       case 528790:
/*  451 */         return "WarningReason";
/*      */       case 528791:
/*  453 */         return "FailureReason";
/*      */       case 528792:
/*  455 */         return "FailedSOPSequence";
/*      */       case 528793:
/*  457 */         return "ReferencedSOPSequence";
/*      */       case 528896:
/*  459 */         return "StudiesContainingOtherReferencedInstancesSequence";
/*      */       case 528976:
/*  461 */         return "RelatedSeriesSequence";
/*      */       case 532752:
/*  463 */         return "LossyImageCompressionRetired";
/*      */       case 532753:
/*  465 */         return "DerivationDescription";
/*      */       case 532754:
/*  467 */         return "SourceImageSequence";
/*      */       case 532768:
/*  469 */         return "StageName";
/*      */       case 532770:
/*  471 */         return "StageNumber";
/*      */       case 532772:
/*  473 */         return "NumberOfStages";
/*      */       case 532775:
/*  475 */         return "ViewName";
/*      */       case 532776:
/*  477 */         return "ViewNumber";
/*      */       case 532777:
/*  479 */         return "NumberOfEventTimers";
/*      */       case 532778:
/*  481 */         return "NumberOfViewsInStage";
/*      */       case 532784:
/*  483 */         return "EventElapsedTimes";
/*      */       case 532786:
/*  485 */         return "EventTimerNames";
/*      */       case 532787:
/*  487 */         return "EventTimerSequence";
/*      */       case 532788:
/*  489 */         return "EventTimeOffset";
/*      */       case 532789:
/*  491 */         return "EventCodeSequence";
/*      */       case 532802:
/*  493 */         return "StartTrim";
/*      */       case 532803:
/*  495 */         return "StopTrim";
/*      */       case 532804:
/*  497 */         return "RecommendedDisplayFrameRate";
/*      */       case 532992:
/*  499 */         return "TransducerPosition";
/*      */       case 532996:
/*  501 */         return "TransducerOrientation";
/*      */       case 533000:
/*  503 */         return "AnatomicStructure";
/*      */       case 533016:
/*  505 */         return "AnatomicRegionSequence";
/*      */       case 533024:
/*  507 */         return "AnatomicRegionModifierSequence";
/*      */       case 533032:
/*  509 */         return "PrimaryAnatomicStructureSequence";
/*      */       case 533033:
/*  511 */         return "AnatomicStructureSpaceOrRegionSequence";
/*      */       case 533040:
/*  513 */         return "PrimaryAnatomicStructureModifierSequence";
/*      */       case 533056:
/*  515 */         return "TransducerPositionSequence";
/*      */       case 533058:
/*  517 */         return "TransducerPositionModifierSequence";
/*      */       case 533060:
/*  519 */         return "TransducerOrientationSequence";
/*      */       case 533062:
/*  521 */         return "TransducerOrientationModifierSequence";
/*      */       case 533073:
/*  523 */         return "AnatomicStructureSpaceOrRegionCodeSequenceTrial";
/*      */       case 533075:
/*  525 */         return "AnatomicPortalOfEntranceCodeSequenceTrial";
/*      */       case 533077:
/*  527 */         return "AnatomicApproachDirectionCodeSequenceTrial";
/*      */       case 533078:
/*  529 */         return "AnatomicPerspectiveDescriptionTrial";
/*      */       case 533079:
/*  531 */         return "AnatomicPerspectiveCodeSequenceTrial";
/*      */       case 533080:
/*  533 */         return "AnatomicLocationOfExaminingInstrumentDescriptionTrial";
/*      */       case 533081:
/*  535 */         return "AnatomicLocationOfExaminingInstrumentCodeSequenceTrial";
/*      */       case 533082:
/*  537 */         return "AnatomicStructureSpaceOrRegionModifierCodeSequenceTrial";
/*      */       case 533084:
/*  539 */         return "OnAxisBackgroundAnatomicStructureCodeSequenceTrial";
/*      */       case 536577:
/*  541 */         return "AlternateRepresentationSequence";
/*      */       case 536592:
/*  543 */         return "IrradiationEventUID";
/*      */       case 536593:
/*  545 */         return "SourceIrradiationEventSequence";
/*      */       case 536594:
/*  547 */         return "RadiopharmaceuticalAdministrationEventUID";
/*      */       case 540672:
/*  549 */         return "IdentifyingComments";
/*      */       case 561159:
/*  551 */         return "FrameType";
/*      */       case 561298:
/*  553 */         return "ReferencedImageEvidenceSequence";
/*      */       case 561441:
/*  555 */         return "ReferencedRawDataSequence";
/*      */       case 561443:
/*  557 */         return "CreatorVersionUID";
/*      */       case 561444:
/*  559 */         return "DerivationImageSequence";
/*      */       case 561492:
/*  561 */         return "SourceImageEvidenceSequence";
/*      */       case 561669:
/*  563 */         return "PixelPresentation";
/*      */       case 561670:
/*  565 */         return "VolumetricProperties";
/*      */       case 561671:
/*  567 */         return "VolumeBasedCalculationTechnique";
/*      */       case 561672:
/*  569 */         return "ComplexImageComponent";
/*      */       case 561673:
/*  571 */         return "AcquisitionContrast";
/*      */       case 561685:
/*  573 */         return "DerivationCodeSequence";
/*      */       case 561719:
/*  575 */         return "ReferencedPresentationStateSequence";
/*      */       case 562192:
/*  577 */         return "ReferencedOtherPlaneSequence";
/*      */       case 562264:
/*  579 */         return "FrameDisplaySequence";
/*      */       case 562265:
/*  581 */         return "RecommendedDisplayFrameRateInFloat";
/*      */       case 562272:
/*  583 */         return "SkipFrameRangeFlag";
/*      */       case 1048592:
/*  585 */         return "PatientName";
/*      */       case 1048608:
/*  587 */         return "PatientID";
/*      */       case 1048609:
/*  589 */         return "IssuerOfPatientID";
/*      */       case 1048610:
/*  591 */         return "TypeOfPatientID";
/*      */       case 1048612:
/*  593 */         return "IssuerOfPatientIDQualifiersSequence";
/*      */       case 1048624:
/*  595 */         return "PatientBirthDate";
/*      */       case 1048626:
/*  597 */         return "PatientBirthTime";
/*      */       case 1048640:
/*  599 */         return "PatientSex";
/*      */       case 1048656:
/*  601 */         return "PatientInsurancePlanCodeSequence";
/*      */       case 1048833:
/*  603 */         return "PatientPrimaryLanguageCodeSequence";
/*      */       case 1048834:
/*  605 */         return "PatientPrimaryLanguageModifierCodeSequence";
/*      */       case 1049088:
/*  607 */         return "QualityControlSubject";
/*      */       case 1049089:
/*  609 */         return "QualityControlSubjectTypeCodeSequence";
/*      */       case 1052672:
/*  611 */         return "OtherPatientIDs";
/*      */       case 1052673:
/*  613 */         return "OtherPatientNames";
/*      */       case 1052674:
/*  615 */         return "OtherPatientIDsSequence";
/*      */       case 1052677:
/*  617 */         return "PatientBirthName";
/*      */       case 1052688:
/*  619 */         return "PatientAge";
/*      */       case 1052704:
/*  621 */         return "PatientSize";
/*      */       case 1052705:
/*  623 */         return "PatientSizeCodeSequence";
/*      */       case 1052720:
/*  625 */         return "PatientWeight";
/*      */       case 1052736:
/*  627 */         return "PatientAddress";
/*      */       case 1052752:
/*  629 */         return "InsurancePlanIdentification";
/*      */       case 1052768:
/*  631 */         return "PatientMotherBirthName";
/*      */       case 1052800:
/*  633 */         return "MilitaryRank";
/*      */       case 1052801:
/*  635 */         return "BranchOfService";
/*      */       case 1052816:
/*  637 */         return "MedicalRecordLocator";
/*      */       case 1052928:
/*  639 */         return "ReferencedPatientPhotoSequence";
/*      */       case 1056768:
/*  641 */         return "MedicalAlerts";
/*      */       case 1057040:
/*  643 */         return "Allergies";
/*      */       case 1057104:
/*  645 */         return "CountryOfResidence";
/*      */       case 1057106:
/*  647 */         return "RegionOfResidence";
/*      */       case 1057108:
/*  649 */         return "PatientTelephoneNumbers";
/*      */       case 1057120:
/*  651 */         return "EthnicGroup";
/*      */       case 1057152:
/*  653 */         return "Occupation";
/*      */       case 1057184:
/*  655 */         return "SmokingStatus";
/*      */       case 1057200:
/*  657 */         return "AdditionalPatientHistory";
/*      */       case 1057216:
/*  659 */         return "PregnancyStatus";
/*      */       case 1057232:
/*  661 */         return "LastMenstrualDate";
/*      */       case 1057264:
/*  663 */         return "PatientReligiousPreference";
/*      */       case 1057281:
/*  665 */         return "PatientSpeciesDescription";
/*      */       case 1057282:
/*  667 */         return "PatientSpeciesCodeSequence";
/*      */       case 1057283:
/*  669 */         return "PatientSexNeutered";
/*      */       case 1057296:
/*  671 */         return "AnatomicalOrientationType";
/*      */       case 1057426:
/*  673 */         return "PatientBreedDescription";
/*      */       case 1057427:
/*  675 */         return "PatientBreedCodeSequence";
/*      */       case 1057428:
/*  677 */         return "BreedRegistrationSequence";
/*      */       case 1057429:
/*  679 */         return "BreedRegistrationNumber";
/*      */       case 1057430:
/*  681 */         return "BreedRegistryCodeSequence";
/*      */       case 1057431:
/*  683 */         return "ResponsiblePerson";
/*      */       case 1057432:
/*  685 */         return "ResponsiblePersonRole";
/*      */       case 1057433:
/*  687 */         return "ResponsibleOrganization";
/*      */       case 1064960:
/*  689 */         return "PatientComments";
/*      */       case 1086513:
/*  691 */         return "ExaminedBodyThickness";
/*      */       case 1179664:
/*  693 */         return "ClinicalTrialSponsorName";
/*      */       case 1179680:
/*  695 */         return "ClinicalTrialProtocolID";
/*      */       case 1179681:
/*  697 */         return "ClinicalTrialProtocolName";
/*      */       case 1179696:
/*  699 */         return "ClinicalTrialSiteID";
/*      */       case 1179697:
/*  701 */         return "ClinicalTrialSiteName";
/*      */       case 1179712:
/*  703 */         return "ClinicalTrialSubjectID";
/*      */       case 1179714:
/*  705 */         return "ClinicalTrialSubjectReadingID";
/*      */       case 1179728:
/*  707 */         return "ClinicalTrialTimePointID";
/*      */       case 1179729:
/*  709 */         return "ClinicalTrialTimePointDescription";
/*      */       case 1179744:
/*  711 */         return "ClinicalTrialCoordinatingCenterName";
/*      */       case 1179746:
/*  713 */         return "PatientIdentityRemoved";
/*      */       case 1179747:
/*  715 */         return "DeidentificationMethod";
/*      */       case 1179748:
/*  717 */         return "DeidentificationMethodCodeSequence";
/*      */       case 1179761:
/*  719 */         return "ClinicalTrialSeriesID";
/*      */       case 1179762:
/*  721 */         return "ClinicalTrialSeriesDescription";
/*      */       case 1179777:
/*  723 */         return "ClinicalTrialProtocolEthicsCommitteeName";
/*      */       case 1179778:
/*  725 */         return "ClinicalTrialProtocolEthicsCommitteeApprovalNumber";
/*      */       case 1179779:
/*  727 */         return "ConsentForClinicalTrialUseSequence";
/*      */       case 1179780:
/*  729 */         return "DistributionType";
/*      */       case 1179781:
/*  731 */         return "ConsentForDistributionFlag";
/*      */       case 1310755:
/*  733 */         return "CADFileFormat";
/*      */       case 1310756:
/*  735 */         return "ComponentReferenceSystem";
/*      */       case 1310757:
/*  737 */         return "ComponentManufacturingProcedure";
/*      */       case 1310760:
/*  739 */         return "ComponentManufacturer";
/*      */       case 1310768:
/*  741 */         return "MaterialThickness";
/*      */       case 1310770:
/*  743 */         return "MaterialPipeDiameter";
/*      */       case 1310772:
/*  745 */         return "MaterialIsolationDiameter";
/*      */       case 1310786:
/*  747 */         return "MaterialGrade";
/*      */       case 1310788:
/*  749 */         return "MaterialPropertiesDescription";
/*      */       case 1310789:
/*  751 */         return "MaterialPropertiesFileFormatRetired";
/*      */       case 1310790:
/*  753 */         return "MaterialNotes";
/*      */       case 1310800:
/*  755 */         return "ComponentShape";
/*      */       case 1310802:
/*  757 */         return "CurvatureType";
/*      */       case 1310804:
/*  759 */         return "OuterDiameter";
/*      */       case 1310806:
/*  761 */         return "InnerDiameter";
/*      */       case 1314832:
/*  763 */         return "ActualEnvironmentalConditions";
/*      */       case 1314848:
/*  765 */         return "ExpiryDate";
/*      */       case 1314880:
/*  767 */         return "EnvironmentalConditions";
/*      */       case 1318914:
/*  769 */         return "EvaluatorSequence";
/*      */       case 1318916:
/*  771 */         return "EvaluatorNumber";
/*      */       case 1318918:
/*  773 */         return "EvaluatorName";
/*      */       case 1318920:
/*  775 */         return "EvaluationAttempt";
/*      */       case 1318930:
/*  777 */         return "IndicationSequence";
/*      */       case 1318932:
/*  779 */         return "IndicationNumber";
/*      */       case 1318934:
/*  781 */         return "IndicationLabel";
/*      */       case 1318936:
/*  783 */         return "IndicationDescription";
/*      */       case 1318938:
/*  785 */         return "IndicationType";
/*      */       case 1318940:
/*  787 */         return "IndicationDisposition";
/*      */       case 1318942:
/*  789 */         return "IndicationROISequence";
/*      */       case 1318960:
/*  791 */         return "IndicationPhysicalPropertySequence";
/*      */       case 1318962:
/*  793 */         return "PropertyLabel";
/*      */       case 1319426:
/*  795 */         return "CoordinateSystemNumberOfAxes";
/*      */       case 1319428:
/*  797 */         return "CoordinateSystemAxesSequence";
/*      */       case 1319430:
/*  799 */         return "CoordinateSystemAxisDescription";
/*      */       case 1319432:
/*  801 */         return "CoordinateSystemDataSetMapping";
/*      */       case 1319434:
/*  803 */         return "CoordinateSystemAxisNumber";
/*      */       case 1319436:
/*  805 */         return "CoordinateSystemAxisType";
/*      */       case 1319438:
/*  807 */         return "CoordinateSystemAxisUnits";
/*      */       case 1319440:
/*  809 */         return "CoordinateSystemAxisValues";
/*      */       case 1319456:
/*  811 */         return "CoordinateSystemTransformSequence";
/*      */       case 1319458:
/*  813 */         return "TransformDescription";
/*      */       case 1319460:
/*  815 */         return "TransformNumberOfAxes";
/*      */       case 1319462:
/*  817 */         return "TransformOrderOfAxes";
/*      */       case 1319464:
/*  819 */         return "TransformedAxisUnits";
/*      */       case 1319466:
/*  821 */         return "CoordinateSystemTransformRotationAndScaleMatrix";
/*      */       case 1319468:
/*  823 */         return "CoordinateSystemTransformTranslationMatrix";
/*      */       case 1323025:
/*  825 */         return "InternalDetectorFrameTime";
/*      */       case 1323026:
/*  827 */         return "NumberOfFramesIntegrated";
/*      */       case 1323040:
/*  829 */         return "DetectorTemperatureSequence";
/*      */       case 1323042:
/*  831 */         return "SensorName";
/*      */       case 1323044:
/*  833 */         return "HorizontalOffsetOfSensor";
/*      */       case 1323046:
/*  835 */         return "VerticalOffsetOfSensor";
/*      */       case 1323048:
/*  837 */         return "SensorTemperature";
/*      */       case 1323072:
/*  839 */         return "DarkCurrentSequence";
/*      */       case 1323088:
/*  841 */         return "DarkCurrentCounts";
/*      */       case 1323104:
/*  843 */         return "GainCorrectionReferenceSequence";
/*      */       case 1323120:
/*  845 */         return "AirCounts";
/*      */       case 1323121:
/*  847 */         return "KVUsedInGainCalibration";
/*      */       case 1323122:
/*  849 */         return "MAUsedInGainCalibration";
/*      */       case 1323123:
/*  851 */         return "NumberOfFramesUsedForIntegration";
/*      */       case 1323124:
/*  853 */         return "FilterMaterialUsedInGainCalibration";
/*      */       case 1323125:
/*  855 */         return "FilterThicknessUsedInGainCalibration";
/*      */       case 1323126:
/*  857 */         return "DateOfGainCalibration";
/*      */       case 1323127:
/*  859 */         return "TimeOfGainCalibration";
/*      */       case 1323136:
/*  861 */         return "BadPixelImage";
/*      */       case 1323161:
/*  863 */         return "CalibrationNotes";
/*      */       case 1327106:
/*  865 */         return "PulserEquipmentSequence";
/*      */       case 1327108:
/*  867 */         return "PulserType";
/*      */       case 1327110:
/*  869 */         return "PulserNotes";
/*      */       case 1327112:
/*  871 */         return "ReceiverEquipmentSequence";
/*      */       case 1327114:
/*  873 */         return "AmplifierType";
/*      */       case 1327116:
/*  875 */         return "ReceiverNotes";
/*      */       case 1327118:
/*  877 */         return "PreAmplifierEquipmentSequence";
/*      */       case 1327119:
/*  879 */         return "PreAmplifierNotes";
/*      */       case 1327120:
/*  881 */         return "TransmitTransducerSequence";
/*      */       case 1327121:
/*  883 */         return "ReceiveTransducerSequence";
/*      */       case 1327122:
/*  885 */         return "NumberOfElements";
/*      */       case 1327123:
/*  887 */         return "ElementShape";
/*      */       case 1327124:
/*  889 */         return "ElementDimensionA";
/*      */       case 1327125:
/*  891 */         return "ElementDimensionB";
/*      */       case 1327126:
/*  893 */         return "ElementPitchA";
/*      */       case 1327127:
/*  895 */         return "MeasuredBeamDimensionA";
/*      */       case 1327128:
/*  897 */         return "MeasuredBeamDimensionB";
/*      */       case 1327129:
/*  899 */         return "LocationOfMeasuredBeamDiameter";
/*      */       case 1327130:
/*  901 */         return "NominalFrequency";
/*      */       case 1327131:
/*  903 */         return "MeasuredCenterFrequency";
/*      */       case 1327132:
/*  905 */         return "MeasuredBandwidth";
/*      */       case 1327133:
/*  907 */         return "ElementPitchB";
/*      */       case 1327136:
/*  909 */         return "PulserSettingsSequence";
/*      */       case 1327138:
/*  911 */         return "PulseWidth";
/*      */       case 1327140:
/*  913 */         return "ExcitationFrequency";
/*      */       case 1327142:
/*  915 */         return "ModulationType";
/*      */       case 1327144:
/*  917 */         return "Damping";
/*      */       case 1327152:
/*  919 */         return "ReceiverSettingsSequence";
/*      */       case 1327153:
/*  921 */         return "AcquiredSoundpathLength";
/*      */       case 1327154:
/*  923 */         return "AcquisitionCompressionType";
/*      */       case 1327155:
/*  925 */         return "AcquisitionSampleSize";
/*      */       case 1327156:
/*  927 */         return "RectifierSmoothing";
/*      */       case 1327157:
/*  929 */         return "DACSequence";
/*      */       case 1327158:
/*  931 */         return "DACType";
/*      */       case 1327160:
/*  933 */         return "DACGainPoints";
/*      */       case 1327162:
/*  935 */         return "DACTimePoints";
/*      */       case 1327164:
/*  937 */         return "DACAmplitude";
/*      */       case 1327168:
/*  939 */         return "PreAmplifierSettingsSequence";
/*      */       case 1327184:
/*  941 */         return "TransmitTransducerSettingsSequence";
/*      */       case 1327185:
/*  943 */         return "ReceiveTransducerSettingsSequence";
/*      */       case 1327186:
/*  945 */         return "IncidentAngle";
/*      */       case 1327188:
/*  947 */         return "CouplingTechnique";
/*      */       case 1327190:
/*  949 */         return "CouplingMedium";
/*      */       case 1327191:
/*  951 */         return "CouplingVelocity";
/*      */       case 1327192:
/*  953 */         return "ProbeCenterLocationX";
/*      */       case 1327193:
/*  955 */         return "ProbeCenterLocationZ";
/*      */       case 1327194:
/*  957 */         return "SoundPathLength";
/*      */       case 1327196:
/*  959 */         return "DelayLawIdentifier";
/*      */       case 1327200:
/*  961 */         return "GateSettingsSequence";
/*      */       case 1327202:
/*  963 */         return "GateThreshold";
/*      */       case 1327204:
/*  965 */         return "VelocityOfSound";
/*      */       case 1327216:
/*  967 */         return "CalibrationSettingsSequence";
/*      */       case 1327218:
/*  969 */         return "CalibrationProcedure";
/*      */       case 1327220:
/*  971 */         return "ProcedureVersion";
/*      */       case 1327222:
/*  973 */         return "ProcedureCreationDate";
/*      */       case 1327224:
/*  975 */         return "ProcedureExpirationDate";
/*      */       case 1327226:
/*  977 */         return "ProcedureLastModifiedDate";
/*      */       case 1327228:
/*  979 */         return "CalibrationTime";
/*      */       case 1327230:
/*  981 */         return "CalibrationDate";
/*      */       case 1327232:
/*  983 */         return "ProbeDriveEquipmentSequence";
/*      */       case 1327233:
/*  985 */         return "DriveType";
/*      */       case 1327234:
/*  987 */         return "ProbeDriveNotes";
/*      */       case 1327235:
/*  989 */         return "DriveProbeSequence";
/*      */       case 1327236:
/*  991 */         return "ProbeInductance";
/*      */       case 1327237:
/*  993 */         return "ProbeResistance";
/*      */       case 1327238:
/*  995 */         return "ReceiveProbeSequence";
/*      */       case 1327239:
/*  997 */         return "ProbeDriveSettingsSequence";
/*      */       case 1327240:
/*  999 */         return "BridgeResistors";
/*      */       case 1327241:
/* 1001 */         return "ProbeOrientationAngle";
/*      */       case 1327243:
/* 1003 */         return "UserSelectedGainY";
/*      */       case 1327244:
/* 1005 */         return "UserSelectedPhase";
/*      */       case 1327245:
/* 1007 */         return "UserSelectedOffsetX";
/*      */       case 1327246:
/* 1009 */         return "UserSelectedOffsetY";
/*      */       case 1327249:
/* 1011 */         return "ChannelSettingsSequence";
/*      */       case 1327250:
/* 1013 */         return "ChannelThreshold";
/*      */       case 1327258:
/* 1015 */         return "ScannerSettingsSequence";
/*      */       case 1327259:
/* 1017 */         return "ScanProcedure";
/*      */       case 1327260:
/* 1019 */         return "TranslationRateX";
/*      */       case 1327261:
/* 1021 */         return "TranslationRateY";
/*      */       case 1327263:
/* 1023 */         return "ChannelOverlap";
/*      */       case 1327264:
/* 1025 */         return "ImageQualityIndicatorType";
/*      */       case 1327265:
/* 1027 */         return "ImageQualityIndicatorMaterial";
/*      */       case 1327266:
/* 1029 */         return "ImageQualityIndicatorSize";
/*      */       case 1331202:
/* 1031 */         return "LINACEnergy";
/*      */       case 1331204:
/* 1033 */         return "LINACOutput";
/*      */       case 1331456:
/* 1035 */         return "ActiveAperture";
/*      */       case 1331457:
/* 1037 */         return "TotalAperture";
/*      */       case 1331458:
/* 1039 */         return "ApertureElevation";
/*      */       case 1331459:
/* 1041 */         return "MainLobeAngle";
/*      */       case 1331460:
/* 1043 */         return "MainRoofAngle";
/*      */       case 1331461:
/* 1045 */         return "ConnectorType";
/*      */       case 1331462:
/* 1047 */         return "WedgeModelNumber";
/*      */       case 1331463:
/* 1049 */         return "WedgeAngleFloat";
/*      */       case 1331464:
/* 1051 */         return "WedgeRoofAngle";
/*      */       case 1331465:
/* 1053 */         return "WedgeElement1Position";
/*      */       case 1331466:
/* 1055 */         return "WedgeMaterialVelocity";
/*      */       case 1331467:
/* 1057 */         return "WedgeMaterial";
/*      */       case 1331468:
/* 1059 */         return "WedgeOffsetZ";
/*      */       case 1331469:
/* 1061 */         return "WedgeOriginOffsetX";
/*      */       case 1331470:
/* 1063 */         return "WedgeTimeDelay";
/*      */       case 1331471:
/* 1065 */         return "WedgeName";
/*      */       case 1331472:
/* 1067 */         return "WedgeManufacturerName";
/*      */       case 1331473:
/* 1069 */         return "WedgeDescription";
/*      */       case 1331474:
/* 1071 */         return "NominalBeamAngle";
/*      */       case 1331475:
/* 1073 */         return "WedgeOffsetX";
/*      */       case 1331476:
/* 1075 */         return "WedgeOffsetY";
/*      */       case 1331477:
/* 1077 */         return "WedgeTotalLength";
/*      */       case 1331478:
/* 1079 */         return "WedgeInContactLength";
/*      */       case 1331479:
/* 1081 */         return "WedgeFrontGap";
/*      */       case 1331480:
/* 1083 */         return "WedgeTotalHeight";
/*      */       case 1331481:
/* 1085 */         return "WedgeFrontHeight";
/*      */       case 1331482:
/* 1087 */         return "WedgeRearHeight";
/*      */       case 1331483:
/* 1089 */         return "WedgeTotalWidth";
/*      */       case 1331484:
/* 1091 */         return "WedgeInContactWidth";
/*      */       case 1331485:
/* 1093 */         return "WedgeChamferHeight";
/*      */       case 1331486:
/* 1095 */         return "WedgeCurve";
/*      */       case 1331487:
/* 1097 */         return "RadiusAlongWedge";
/*      */       case 1572880:
/* 1099 */         return "ContrastBolusAgent";
/*      */       case 1572882:
/* 1101 */         return "ContrastBolusAgentSequence";
/*      */       case 1572883:
/* 1103 */         return "ContrastBolusT1Relaxivity";
/*      */       case 1572884:
/* 1105 */         return "ContrastBolusAdministrationRouteSequence";
/*      */       case 1572885:
/* 1107 */         return "BodyPartExamined";
/*      */       case 1572896:
/* 1109 */         return "ScanningSequence";
/*      */       case 1572897:
/* 1111 */         return "SequenceVariant";
/*      */       case 1572898:
/* 1113 */         return "ScanOptions";
/*      */       case 1572899:
/* 1115 */         return "MRAcquisitionType";
/*      */       case 1572900:
/* 1117 */         return "SequenceName";
/*      */       case 1572901:
/* 1119 */         return "AngioFlag";
/*      */       case 1572902:
/* 1121 */         return "InterventionDrugInformationSequence";
/*      */       case 1572903:
/* 1123 */         return "InterventionDrugStopTime";
/*      */       case 1572904:
/* 1125 */         return "InterventionDrugDose";
/*      */       case 1572905:
/* 1127 */         return "InterventionDrugCodeSequence";
/*      */       case 1572906:
/* 1129 */         return "AdditionalDrugSequence";
/*      */       case 1572912:
/* 1131 */         return "Radionuclide";
/*      */       case 1572913:
/* 1133 */         return "Radiopharmaceutical";
/*      */       case 1572914:
/* 1135 */         return "EnergyWindowCenterline";
/*      */       case 1572915:
/* 1137 */         return "EnergyWindowTotalWidth";
/*      */       case 1572916:
/* 1139 */         return "InterventionDrugName";
/*      */       case 1572917:
/* 1141 */         return "InterventionDrugStartTime";
/*      */       case 1572918:
/* 1143 */         return "InterventionSequence";
/*      */       case 1572919:
/* 1145 */         return "TherapyType";
/*      */       case 1572920:
/* 1147 */         return "InterventionStatus";
/*      */       case 1572921:
/* 1149 */         return "TherapyDescription";
/*      */       case 1572922:
/* 1151 */         return "InterventionDescription";
/*      */       case 1572928:
/* 1153 */         return "CineRate";
/*      */       case 1572930:
/* 1155 */         return "InitialCineRunState";
/*      */       case 1572944:
/* 1157 */         return "SliceThickness";
/*      */       case 1572960:
/* 1159 */         return "KVP";
/*      */       case 1572976:
/* 1161 */         return "CountsAccumulated";
/*      */       case 1572977:
/* 1163 */         return "AcquisitionTerminationCondition";
/*      */       case 1572978:
/* 1165 */         return "EffectiveDuration";
/*      */       case 1572979:
/* 1167 */         return "AcquisitionStartCondition";
/*      */       case 1572980:
/* 1169 */         return "AcquisitionStartConditionData";
/*      */       case 1572981:
/* 1171 */         return "AcquisitionTerminationConditionData";
/*      */       case 1572992:
/* 1173 */         return "RepetitionTime";
/*      */       case 1572993:
/* 1175 */         return "EchoTime";
/*      */       case 1572994:
/* 1177 */         return "InversionTime";
/*      */       case 1572995:
/* 1179 */         return "NumberOfAverages";
/*      */       case 1572996:
/* 1181 */         return "ImagingFrequency";
/*      */       case 1572997:
/* 1183 */         return "ImagedNucleus";
/*      */       case 1572998:
/* 1185 */         return "EchoNumbers";
/*      */       case 1572999:
/* 1187 */         return "MagneticFieldStrength";
/*      */       case 1573000:
/* 1189 */         return "SpacingBetweenSlices";
/*      */       case 1573001:
/* 1191 */         return "NumberOfPhaseEncodingSteps";
/*      */       case 1573008:
/* 1193 */         return "DataCollectionDiameter";
/*      */       case 1573009:
/* 1195 */         return "EchoTrainLength";
/*      */       case 1573011:
/* 1197 */         return "PercentSampling";
/*      */       case 1573012:
/* 1199 */         return "PercentPhaseFieldOfView";
/*      */       case 1573013:
/* 1201 */         return "PixelBandwidth";
/*      */       case 1576960:
/* 1203 */         return "DeviceSerialNumber";
/*      */       case 1576962:
/* 1205 */         return "DeviceUID";
/*      */       case 1576963:
/* 1207 */         return "DeviceID";
/*      */       case 1576964:
/* 1209 */         return "PlateID";
/*      */       case 1576965:
/* 1211 */         return "GeneratorID";
/*      */       case 1576966:
/* 1213 */         return "GridID";
/*      */       case 1576967:
/* 1215 */         return "CassetteID";
/*      */       case 1576968:
/* 1217 */         return "GantryID";
/*      */       case 1576976:
/* 1219 */         return "SecondaryCaptureDeviceID";
/*      */       case 1576977:
/* 1221 */         return "HardcopyCreationDeviceID";
/*      */       case 1576978:
/* 1223 */         return "DateOfSecondaryCapture";
/*      */       case 1576980:
/* 1225 */         return "TimeOfSecondaryCapture";
/*      */       case 1576982:
/* 1227 */         return "SecondaryCaptureDeviceManufacturer";
/*      */       case 1576983:
/* 1229 */         return "HardcopyDeviceManufacturer";
/*      */       case 1576984:
/* 1231 */         return "SecondaryCaptureDeviceManufacturerModelName";
/*      */       case 1576985:
/* 1233 */         return "SecondaryCaptureDeviceSoftwareVersions";
/*      */       case 1576986:
/* 1235 */         return "HardcopyDeviceSoftwareVersion";
/*      */       case 1576987:
/* 1237 */         return "HardcopyDeviceManufacturerModelName";
/*      */       case 1576992:
/* 1239 */         return "SoftwareVersions";
/*      */       case 1576994:
/* 1241 */         return "VideoImageFormatAcquired";
/*      */       case 1576995:
/* 1243 */         return "DigitalImageFormatAcquired";
/*      */       case 1577008:
/* 1245 */         return "ProtocolName";
/*      */       case 1577024:
/* 1247 */         return "ContrastBolusRoute";
/*      */       case 1577025:
/* 1249 */         return "ContrastBolusVolume";
/*      */       case 1577026:
/* 1251 */         return "ContrastBolusStartTime";
/*      */       case 1577027:
/* 1253 */         return "ContrastBolusStopTime";
/*      */       case 1577028:
/* 1255 */         return "ContrastBolusTotalDose";
/*      */       case 1577029:
/* 1257 */         return "SyringeCounts";
/*      */       case 1577030:
/* 1259 */         return "ContrastFlowRate";
/*      */       case 1577031:
/* 1261 */         return "ContrastFlowDuration";
/*      */       case 1577032:
/* 1263 */         return "ContrastBolusIngredient";
/*      */       case 1577033:
/* 1265 */         return "ContrastBolusIngredientConcentration";
/*      */       case 1577040:
/* 1267 */         return "SpatialResolution";
/*      */       case 1577056:
/* 1269 */         return "TriggerTime";
/*      */       case 1577057:
/* 1271 */         return "TriggerSourceOrType";
/*      */       case 1577058:
/* 1273 */         return "NominalInterval";
/*      */       case 1577059:
/* 1275 */         return "FrameTime";
/*      */       case 1577060:
/* 1277 */         return "CardiacFramingType";
/*      */       case 1577061:
/* 1279 */         return "FrameTimeVector";
/*      */       case 1577062:
/* 1281 */         return "FrameDelay";
/*      */       case 1577063:
/* 1283 */         return "ImageTriggerDelay";
/*      */       case 1577064:
/* 1285 */         return "MultiplexGroupTimeOffset";
/*      */       case 1577065:
/* 1287 */         return "TriggerTimeOffset";
/*      */       case 1577066:
/* 1289 */         return "SynchronizationTrigger";
/*      */       case 1577068:
/* 1291 */         return "SynchronizationChannel";
/*      */       case 1577070:
/* 1293 */         return "TriggerSamplePosition";
/*      */       case 1577072:
/* 1295 */         return "RadiopharmaceuticalRoute";
/*      */       case 1577073:
/* 1297 */         return "RadiopharmaceuticalVolume";
/*      */       case 1577074:
/* 1299 */         return "RadiopharmaceuticalStartTime";
/*      */       case 1577075:
/* 1301 */         return "RadiopharmaceuticalStopTime";
/*      */       case 1577076:
/* 1303 */         return "RadionuclideTotalDose";
/*      */       case 1577077:
/* 1305 */         return "RadionuclideHalfLife";
/*      */       case 1577078:
/* 1307 */         return "RadionuclidePositronFraction";
/*      */       case 1577079:
/* 1309 */         return "RadiopharmaceuticalSpecificActivity";
/*      */       case 1577080:
/* 1311 */         return "RadiopharmaceuticalStartDateTime";
/*      */       case 1577081:
/* 1313 */         return "RadiopharmaceuticalStopDateTime";
/*      */       case 1577088:
/* 1315 */         return "BeatRejectionFlag";
/*      */       case 1577089:
/* 1317 */         return "LowRRValue";
/*      */       case 1577090:
/* 1319 */         return "HighRRValue";
/*      */       case 1577091:
/* 1321 */         return "IntervalsAcquired";
/*      */       case 1577092:
/* 1323 */         return "IntervalsRejected";
/*      */       case 1577093:
/* 1325 */         return "PVCRejection";
/*      */       case 1577094:
/* 1327 */         return "SkipBeats";
/*      */       case 1577096:
/* 1329 */         return "HeartRate";
/*      */       case 1577104:
/* 1331 */         return "CardiacNumberOfImages";
/*      */       case 1577108:
/* 1333 */         return "TriggerWindow";
/*      */       case 1577216:
/* 1335 */         return "ReconstructionDiameter";
/*      */       case 1577232:
/* 1337 */         return "DistanceSourceToDetector";
/*      */       case 1577233:
/* 1339 */         return "DistanceSourceToPatient";
/*      */       case 1577236:
/* 1341 */         return "EstimatedRadiographicMagnificationFactor";
/*      */       case 1577248:
/* 1343 */         return "GantryDetectorTilt";
/*      */       case 1577249:
/* 1345 */         return "GantryDetectorSlew";
/*      */       case 1577264:
/* 1347 */         return "TableHeight";
/*      */       case 1577265:
/* 1349 */         return "TableTraverse";
/*      */       case 1577268:
/* 1351 */         return "TableMotion";
/*      */       case 1577269:
/* 1353 */         return "TableVerticalIncrement";
/*      */       case 1577270:
/* 1355 */         return "TableLateralIncrement";
/*      */       case 1577271:
/* 1357 */         return "TableLongitudinalIncrement";
/*      */       case 1577272:
/* 1359 */         return "TableAngle";
/*      */       case 1577274:
/* 1361 */         return "TableType";
/*      */       case 1577280:
/* 1363 */         return "RotationDirection";
/*      */       case 1577281:
/* 1365 */         return "AngularPosition";
/*      */       case 1577282:
/* 1367 */         return "RadialPosition";
/*      */       case 1577283:
/* 1369 */         return "ScanArc";
/*      */       case 1577284:
/* 1371 */         return "AngularStep";
/*      */       case 1577285:
/* 1373 */         return "CenterOfRotationOffset";
/*      */       case 1577286:
/* 1375 */         return "RotationOffset";
/*      */       case 1577287:
/* 1377 */         return "FieldOfViewShape";
/*      */       case 1577289:
/* 1379 */         return "FieldOfViewDimensions";
/*      */       case 1577296:
/* 1381 */         return "ExposureTime";
/*      */       case 1577297:
/* 1383 */         return "XRayTubeCurrent";
/*      */       case 1577298:
/* 1385 */         return "Exposure";
/*      */       case 1577299:
/* 1387 */         return "ExposureInuAs";
/*      */       case 1577300:
/* 1389 */         return "AveragePulseWidth";
/*      */       case 1577301:
/* 1391 */         return "RadiationSetting";
/*      */       case 1577302:
/* 1393 */         return "RectificationType";
/*      */       case 1577306:
/* 1395 */         return "RadiationMode";
/*      */       case 1577310:
/* 1397 */         return "ImageAndFluoroscopyAreaDoseProduct";
/*      */       case 1577312:
/* 1399 */         return "FilterType";
/*      */       case 1577313:
/* 1401 */         return "TypeOfFilters";
/*      */       case 1577314:
/* 1403 */         return "IntensifierSize";
/*      */       case 1577316:
/* 1405 */         return "ImagerPixelSpacing";
/*      */       case 1577318:
/* 1407 */         return "Grid";
/*      */       case 1577328:
/* 1409 */         return "GeneratorPower";
/*      */       case 1577344:
/* 1411 */         return "CollimatorGridName";
/*      */       case 1577345:
/* 1413 */         return "CollimatorType";
/*      */       case 1577346:
/* 1415 */         return "FocalDistance";
/*      */       case 1577347:
/* 1417 */         return "XFocusCenter";
/*      */       case 1577348:
/* 1419 */         return "YFocusCenter";
/*      */       case 1577360:
/* 1421 */         return "FocalSpots";
/*      */       case 1577361:
/* 1423 */         return "AnodeTargetMaterial";
/*      */       case 1577376:
/* 1425 */         return "BodyPartThickness";
/*      */       case 1577378:
/* 1427 */         return "CompressionForce";
/*      */       case 1577380:
/* 1429 */         return "PaddleDescription";
/*      */       case 1577472:
/* 1431 */         return "DateOfLastCalibration";
/*      */       case 1577473:
/* 1433 */         return "TimeOfLastCalibration";
/*      */       case 1577474:
/* 1435 */         return "DateTimeOfLastCalibration";
/*      */       case 1577488:
/* 1437 */         return "ConvolutionKernel";
/*      */       case 1577536:
/* 1439 */         return "UpperLowerPixelValues";
/*      */       case 1577538:
/* 1441 */         return "ActualFrameDuration";
/*      */       case 1577539:
/* 1443 */         return "CountRate";
/*      */       case 1577540:
/* 1445 */         return "PreferredPlaybackSequencing";
/*      */       case 1577552:
/* 1447 */         return "ReceiveCoilName";
/*      */       case 1577553:
/* 1449 */         return "TransmitCoilName";
/*      */       case 1577568:
/* 1451 */         return "PlateType";
/*      */       case 1577569:
/* 1453 */         return "PhosphorType";
/*      */       case 1577728:
/* 1455 */         return "ScanVelocity";
/*      */       case 1577729:
/* 1457 */         return "WholeBodyTechnique";
/*      */       case 1577730:
/* 1459 */         return "ScanLength";
/*      */       case 1577744:
/* 1461 */         return "AcquisitionMatrix";
/*      */       case 1577746:
/* 1463 */         return "InPlanePhaseEncodingDirection";
/*      */       case 1577748:
/* 1465 */         return "FlipAngle";
/*      */       case 1577749:
/* 1467 */         return "VariableFlipAngleFlag";
/*      */       case 1577750:
/* 1469 */         return "SAR";
/*      */       case 1577752:
/* 1471 */         return "dBdt";
/*      */       case 1577984:
/* 1473 */         return "AcquisitionDeviceProcessingDescription";
/*      */       case 1577985:
/* 1475 */         return "AcquisitionDeviceProcessingCode";
/*      */       case 1577986:
/* 1477 */         return "CassetteOrientation";
/*      */       case 1577987:
/* 1479 */         return "CassetteSize";
/*      */       case 1577988:
/* 1481 */         return "ExposuresOnPlate";
/*      */       case 1577989:
/* 1483 */         return "RelativeXRayExposure";
/*      */       case 1578001:
/* 1485 */         return "ExposureIndex";
/*      */       case 1578002:
/* 1487 */         return "TargetExposureIndex";
/*      */       case 1578003:
/* 1489 */         return "DeviationIndex";
/*      */       case 1578064:
/* 1491 */         return "ColumnAngulation";
/*      */       case 1578080:
/* 1493 */         return "TomoLayerHeight";
/*      */       case 1578096:
/* 1495 */         return "TomoAngle";
/*      */       case 1578112:
/* 1497 */         return "TomoTime";
/*      */       case 1578128:
/* 1499 */         return "TomoType";
/*      */       case 1578129:
/* 1501 */         return "TomoClass";
/*      */       case 1578133:
/* 1503 */         return "NumberOfTomosynthesisSourceImages";
/*      */       case 1578240:
/* 1505 */         return "PositionerMotion";
/*      */       case 1578248:
/* 1507 */         return "PositionerType";
/*      */       case 1578256:
/* 1509 */         return "PositionerPrimaryAngle";
/*      */       case 1578257:
/* 1511 */         return "PositionerSecondaryAngle";
/*      */       case 1578272:
/* 1513 */         return "PositionerPrimaryAngleIncrement";
/*      */       case 1578273:
/* 1515 */         return "PositionerSecondaryAngleIncrement";
/*      */       case 1578288:
/* 1517 */         return "DetectorPrimaryAngle";
/*      */       case 1578289:
/* 1519 */         return "DetectorSecondaryAngle";
/*      */       case 1578496:
/* 1521 */         return "ShutterShape";
/*      */       case 1578498:
/* 1523 */         return "ShutterLeftVerticalEdge";
/*      */       case 1578500:
/* 1525 */         return "ShutterRightVerticalEdge";
/*      */       case 1578502:
/* 1527 */         return "ShutterUpperHorizontalEdge";
/*      */       case 1578504:
/* 1529 */         return "ShutterLowerHorizontalEdge";
/*      */       case 1578512:
/* 1531 */         return "CenterOfCircularShutter";
/*      */       case 1578514:
/* 1533 */         return "RadiusOfCircularShutter";
/*      */       case 1578528:
/* 1535 */         return "VerticesOfThePolygonalShutter";
/*      */       case 1578530:
/* 1537 */         return "ShutterPresentationValue";
/*      */       case 1578531:
/* 1539 */         return "ShutterOverlayGroup";
/*      */       case 1578532:
/* 1541 */         return "ShutterPresentationColorCIELabValue";
/*      */       case 1578752:
/* 1543 */         return "CollimatorShape";
/*      */       case 1578754:
/* 1545 */         return "CollimatorLeftVerticalEdge";
/*      */       case 1578756:
/* 1547 */         return "CollimatorRightVerticalEdge";
/*      */       case 1578758:
/* 1549 */         return "CollimatorUpperHorizontalEdge";
/*      */       case 1578760:
/* 1551 */         return "CollimatorLowerHorizontalEdge";
/*      */       case 1578768:
/* 1553 */         return "CenterOfCircularCollimator";
/*      */       case 1578770:
/* 1555 */         return "RadiusOfCircularCollimator";
/*      */       case 1578784:
/* 1557 */         return "VerticesOfThePolygonalCollimator";
/*      */       case 1579008:
/* 1559 */         return "AcquisitionTimeSynchronized";
/*      */       case 1579009:
/* 1561 */         return "TimeSource";
/*      */       case 1579010:
/* 1563 */         return "TimeDistributionProtocol";
/*      */       case 1579011:
/* 1565 */         return "NTPSourceAddress";
/*      */       case 1581057:
/* 1567 */         return "PageNumberVector";
/*      */       case 1581058:
/* 1569 */         return "FrameLabelVector";
/*      */       case 1581059:
/* 1571 */         return "FramePrimaryAngleVector";
/*      */       case 1581060:
/* 1573 */         return "FrameSecondaryAngleVector";
/*      */       case 1581061:
/* 1575 */         return "SliceLocationVector";
/*      */       case 1581062:
/* 1577 */         return "DisplayWindowLabelVector";
/*      */       case 1581072:
/* 1579 */         return "NominalScannedPixelSpacing";
/*      */       case 1581088:
/* 1581 */         return "DigitizingDeviceTransportDirection";
/*      */       case 1581104:
/* 1583 */         return "RotationOfScannedFilm";
/*      */       case 1581121:
/* 1585 */         return "BiopsyTargetSequence";
/*      */       case 1581122:
/* 1587 */         return "TargetUID";
/*      */       case 1581123:
/* 1589 */         return "LocalizingCursorPosition";
/*      */       case 1581124:
/* 1591 */         return "CalculatedTargetPosition";
/*      */       case 1581125:
/* 1593 */         return "TargetLabel";
/*      */       case 1581126:
/* 1595 */         return "DisplayedZValue";
/*      */       case 1585408:
/* 1597 */         return "IVUSAcquisition";
/*      */       case 1585409:
/* 1599 */         return "IVUSPullbackRate";
/*      */       case 1585410:
/* 1601 */         return "IVUSGatedRate";
/*      */       case 1585411:
/* 1603 */         return "IVUSPullbackStartFrameNumber";
/*      */       case 1585412:
/* 1605 */         return "IVUSPullbackStopFrameNumber";
/*      */       case 1585413:
/* 1607 */         return "LesionNumber";
/*      */       case 1589248:
/* 1609 */         return "AcquisitionComments";
/*      */       case 1593344:
/* 1611 */         return "OutputPower";
/*      */       case 1593360:
/* 1613 */         return "TransducerData";
/*      */       case 1593362:
/* 1615 */         return "FocusDepth";
/*      */       case 1593376:
/* 1617 */         return "ProcessingFunction";
/*      */       case 1593377:
/* 1619 */         return "PostprocessingFunction";
/*      */       case 1593378:
/* 1621 */         return "MechanicalIndex";
/*      */       case 1593380:
/* 1623 */         return "BoneThermalIndex";
/*      */       case 1593382:
/* 1625 */         return "CranialThermalIndex";
/*      */       case 1593383:
/* 1627 */         return "SoftTissueThermalIndex";
/*      */       case 1593384:
/* 1629 */         return "SoftTissueFocusThermalIndex";
/*      */       case 1593385:
/* 1631 */         return "SoftTissueSurfaceThermalIndex";
/*      */       case 1593392:
/* 1633 */         return "DynamicRange";
/*      */       case 1593408:
/* 1635 */         return "TotalGain";
/*      */       case 1593424:
/* 1637 */         return "DepthOfScanField";
/*      */       case 1593600:
/* 1639 */         return "PatientPosition";
/*      */       case 1593601:
/* 1641 */         return "ViewPosition";
/*      */       case 1593604:
/* 1643 */         return "ProjectionEponymousNameCodeSequence";
/*      */       case 1593872:
/* 1645 */         return "ImageTransformationMatrix";
/*      */       case 1593874:
/* 1647 */         return "ImageTranslationVector";
/*      */       case 1597440:
/* 1649 */         return "Sensitivity";
/*      */       case 1597457:
/* 1651 */         return "SequenceOfUltrasoundRegions";
/*      */       case 1597458:
/* 1653 */         return "RegionSpatialFormat";
/*      */       case 1597460:
/* 1655 */         return "RegionDataType";
/*      */       case 1597462:
/* 1657 */         return "RegionFlags";
/*      */       case 1597464:
/* 1659 */         return "RegionLocationMinX0";
/*      */       case 1597466:
/* 1661 */         return "RegionLocationMinY0";
/*      */       case 1597468:
/* 1663 */         return "RegionLocationMaxX1";
/*      */       case 1597470:
/* 1665 */         return "RegionLocationMaxY1";
/*      */       case 1597472:
/* 1667 */         return "ReferencePixelX0";
/*      */       case 1597474:
/* 1669 */         return "ReferencePixelY0";
/*      */       case 1597476:
/* 1671 */         return "PhysicalUnitsXDirection";
/*      */       case 1597478:
/* 1673 */         return "PhysicalUnitsYDirection";
/*      */       case 1597480:
/* 1675 */         return "ReferencePixelPhysicalValueX";
/*      */       case 1597482:
/* 1677 */         return "ReferencePixelPhysicalValueY";
/*      */       case 1597484:
/* 1679 */         return "PhysicalDeltaX";
/*      */       case 1597486:
/* 1681 */         return "PhysicalDeltaY";
/*      */       case 1597488:
/* 1683 */         return "TransducerFrequency";
/*      */       case 1597489:
/* 1685 */         return "TransducerType";
/*      */       case 1597490:
/* 1687 */         return "PulseRepetitionFrequency";
/*      */       case 1597492:
/* 1689 */         return "DopplerCorrectionAngle";
/*      */       case 1597494:
/* 1691 */         return "SteeringAngle";
/*      */       case 1597496:
/* 1693 */         return "DopplerSampleVolumeXPositionRetired";
/*      */       case 1597497:
/* 1695 */         return "DopplerSampleVolumeXPosition";
/*      */       case 1597498:
/* 1697 */         return "DopplerSampleVolumeYPositionRetired";
/*      */       case 1597499:
/* 1699 */         return "DopplerSampleVolumeYPosition";
/*      */       case 1597500:
/* 1701 */         return "TMLinePositionX0Retired";
/*      */       case 1597501:
/* 1703 */         return "TMLinePositionX0";
/*      */       case 1597502:
/* 1705 */         return "TMLinePositionY0Retired";
/*      */       case 1597503:
/* 1707 */         return "TMLinePositionY0";
/*      */       case 1597504:
/* 1709 */         return "TMLinePositionX1Retired";
/*      */       case 1597505:
/* 1711 */         return "TMLinePositionX1";
/*      */       case 1597506:
/* 1713 */         return "TMLinePositionY1Retired";
/*      */       case 1597507:
/* 1715 */         return "TMLinePositionY1";
/*      */       case 1597508:
/* 1717 */         return "PixelComponentOrganization";
/*      */       case 1597510:
/* 1719 */         return "PixelComponentMask";
/*      */       case 1597512:
/* 1721 */         return "PixelComponentRangeStart";
/*      */       case 1597514:
/* 1723 */         return "PixelComponentRangeStop";
/*      */       case 1597516:
/* 1725 */         return "PixelComponentPhysicalUnits";
/*      */       case 1597518:
/* 1727 */         return "PixelComponentDataType";
/*      */       case 1597520:
/* 1729 */         return "NumberOfTableBreakPoints";
/*      */       case 1597522:
/* 1731 */         return "TableOfXBreakPoints";
/*      */       case 1597524:
/* 1733 */         return "TableOfYBreakPoints";
/*      */       case 1597526:
/* 1735 */         return "NumberOfTableEntries";
/*      */       case 1597528:
/* 1737 */         return "TableOfPixelValues";
/*      */       case 1597530:
/* 1739 */         return "TableOfParameterValues";
/*      */       case 1597536:
/* 1741 */         return "RWaveTimeVector";
/*      */       case 1601536:
/* 1743 */         return "DetectorConditionsNominalFlag";
/*      */       case 1601537:
/* 1745 */         return "DetectorTemperature";
/*      */       case 1601540:
/* 1747 */         return "DetectorType";
/*      */       case 1601541:
/* 1749 */         return "DetectorConfiguration";
/*      */       case 1601542:
/* 1751 */         return "DetectorDescription";
/*      */       case 1601544:
/* 1753 */         return "DetectorMode";
/*      */       case 1601546:
/* 1755 */         return "DetectorID";
/*      */       case 1601548:
/* 1757 */         return "DateOfLastDetectorCalibration";
/*      */       case 1601550:
/* 1759 */         return "TimeOfLastDetectorCalibration";
/*      */       case 1601552:
/* 1761 */         return "ExposuresOnDetectorSinceLastCalibration";
/*      */       case 1601553:
/* 1763 */         return "ExposuresOnDetectorSinceManufactured";
/*      */       case 1601554:
/* 1765 */         return "DetectorTimeSinceLastExposure";
/*      */       case 1601556:
/* 1767 */         return "DetectorActiveTime";
/*      */       case 1601558:
/* 1769 */         return "DetectorActivationOffsetFromExposure";
/*      */       case 1601562:
/* 1771 */         return "DetectorBinning";
/*      */       case 1601568:
/* 1773 */         return "DetectorElementPhysicalSize";
/*      */       case 1601570:
/* 1775 */         return "DetectorElementSpacing";
/*      */       case 1601572:
/* 1777 */         return "DetectorActiveShape";
/*      */       case 1601574:
/* 1779 */         return "DetectorActiveDimensions";
/*      */       case 1601576:
/* 1781 */         return "DetectorActiveOrigin";
/*      */       case 1601578:
/* 1783 */         return "DetectorManufacturerName";
/*      */       case 1601579:
/* 1785 */         return "DetectorManufacturerModelName";
/*      */       case 1601584:
/* 1787 */         return "FieldOfViewOrigin";
/*      */       case 1601586:
/* 1789 */         return "FieldOfViewRotation";
/*      */       case 1601588:
/* 1791 */         return "FieldOfViewHorizontalFlip";
/*      */       case 1601590:
/* 1793 */         return "PixelDataAreaOriginRelativeToFOV";
/*      */       case 1601592:
/* 1795 */         return "PixelDataAreaRotationAngleRelativeToFOV";
/*      */       case 1601600:
/* 1797 */         return "GridAbsorbingMaterial";
/*      */       case 1601601:
/* 1799 */         return "GridSpacingMaterial";
/*      */       case 1601602:
/* 1801 */         return "GridThickness";
/*      */       case 1601604:
/* 1803 */         return "GridPitch";
/*      */       case 1601606:
/* 1805 */         return "GridAspectRatio";
/*      */       case 1601608:
/* 1807 */         return "GridPeriod";
/*      */       case 1601612:
/* 1809 */         return "GridFocalDistance";
/*      */       case 1601616:
/* 1811 */         return "FilterMaterial";
/*      */       case 1601618:
/* 1813 */         return "FilterThicknessMinimum";
/*      */       case 1601620:
/* 1815 */         return "FilterThicknessMaximum";
/*      */       case 1601622:
/* 1817 */         return "FilterBeamPathLengthMinimum";
/*      */       case 1601624:
/* 1819 */         return "FilterBeamPathLengthMaximum";
/*      */       case 1601632:
/* 1821 */         return "ExposureControlMode";
/*      */       case 1601634:
/* 1823 */         return "ExposureControlModeDescription";
/*      */       case 1601636:
/* 1825 */         return "ExposureStatus";
/*      */       case 1601637:
/* 1827 */         return "PhototimerSetting";
/*      */       case 1605968:
/* 1829 */         return "ExposureTimeInuS";
/*      */       case 1605969:
/* 1831 */         return "XRayTubeCurrentInuA";
/*      */       case 1609732:
/* 1833 */         return "ContentQualification";
/*      */       case 1609733:
/* 1835 */         return "PulseSequenceName";
/*      */       case 1609734:
/* 1837 */         return "MRImagingModifierSequence";
/*      */       case 1609736:
/* 1839 */         return "EchoPulseSequence";
/*      */       case 1609737:
/* 1841 */         return "InversionRecovery";
/*      */       case 1609744:
/* 1843 */         return "FlowCompensation";
/*      */       case 1609745:
/* 1845 */         return "MultipleSpinEcho";
/*      */       case 1609746:
/* 1847 */         return "MultiPlanarExcitation";
/*      */       case 1609748:
/* 1849 */         return "PhaseContrast";
/*      */       case 1609749:
/* 1851 */         return "TimeOfFlightContrast";
/*      */       case 1609750:
/* 1853 */         return "Spoiling";
/*      */       case 1609751:
/* 1855 */         return "SteadyStatePulseSequence";
/*      */       case 1609752:
/* 1857 */         return "EchoPlanarPulseSequence";
/*      */       case 1609753:
/* 1859 */         return "TagAngleFirstAxis";
/*      */       case 1609760:
/* 1861 */         return "MagnetizationTransfer";
/*      */       case 1609761:
/* 1863 */         return "T2Preparation";
/*      */       case 1609762:
/* 1865 */         return "BloodSignalNulling";
/*      */       case 1609764:
/* 1867 */         return "SaturationRecovery";
/*      */       case 1609765:
/* 1869 */         return "SpectrallySelectedSuppression";
/*      */       case 1609766:
/* 1871 */         return "SpectrallySelectedExcitation";
/*      */       case 1609767:
/* 1873 */         return "SpatialPresaturation";
/*      */       case 1609768:
/* 1875 */         return "Tagging";
/*      */       case 1609769:
/* 1877 */         return "OversamplingPhase";
/*      */       case 1609776:
/* 1879 */         return "TagSpacingFirstDimension";
/*      */       case 1609778:
/* 1881 */         return "GeometryOfKSpaceTraversal";
/*      */       case 1609779:
/* 1883 */         return "SegmentedKSpaceTraversal";
/*      */       case 1609780:
/* 1885 */         return "RectilinearPhaseEncodeReordering";
/*      */       case 1609781:
/* 1887 */         return "TagThickness";
/*      */       case 1609782:
/* 1889 */         return "PartialFourierDirection";
/*      */       case 1609783:
/* 1891 */         return "CardiacSynchronizationTechnique";
/*      */       case 1609793:
/* 1893 */         return "ReceiveCoilManufacturerName";
/*      */       case 1609794:
/* 1895 */         return "MRReceiveCoilSequence";
/*      */       case 1609795:
/* 1897 */         return "ReceiveCoilType";
/*      */       case 1609796:
/* 1899 */         return "QuadratureReceiveCoil";
/*      */       case 1609797:
/* 1901 */         return "MultiCoilDefinitionSequence";
/*      */       case 1609798:
/* 1903 */         return "MultiCoilConfiguration";
/*      */       case 1609799:
/* 1905 */         return "MultiCoilElementName";
/*      */       case 1609800:
/* 1907 */         return "MultiCoilElementUsed";
/*      */       case 1609801:
/* 1909 */         return "MRTransmitCoilSequence";
/*      */       case 1609808:
/* 1911 */         return "TransmitCoilManufacturerName";
/*      */       case 1609809:
/* 1913 */         return "TransmitCoilType";
/*      */       case 1609810:
/* 1915 */         return "SpectralWidth";
/*      */       case 1609811:
/* 1917 */         return "ChemicalShiftReference";
/*      */       case 1609812:
/* 1919 */         return "VolumeLocalizationTechnique";
/*      */       case 1609816:
/* 1921 */         return "MRAcquisitionFrequencyEncodingSteps";
/*      */       case 1609817:
/* 1923 */         return "Decoupling";
/*      */       case 1609824:
/* 1925 */         return "DecoupledNucleus";
/*      */       case 1609825:
/* 1927 */         return "DecouplingFrequency";
/*      */       case 1609826:
/* 1929 */         return "DecouplingMethod";
/*      */       case 1609827:
/* 1931 */         return "DecouplingChemicalShiftReference";
/*      */       case 1609828:
/* 1933 */         return "KSpaceFiltering";
/*      */       case 1609829:
/* 1935 */         return "TimeDomainFiltering";
/*      */       case 1609830:
/* 1937 */         return "NumberOfZeroFills";
/*      */       case 1609831:
/* 1939 */         return "BaselineCorrection";
/*      */       case 1609833:
/* 1941 */         return "ParallelReductionFactorInPlane";
/*      */       case 1609840:
/* 1943 */         return "CardiacRRIntervalSpecified";
/*      */       case 1609843:
/* 1945 */         return "AcquisitionDuration";
/*      */       case 1609844:
/* 1947 */         return "FrameAcquisitionDateTime";
/*      */       case 1609845:
/* 1949 */         return "DiffusionDirectionality";
/*      */       case 1609846:
/* 1951 */         return "DiffusionGradientDirectionSequence";
/*      */       case 1609847:
/* 1953 */         return "ParallelAcquisition";
/*      */       case 1609848:
/* 1955 */         return "ParallelAcquisitionTechnique";
/*      */       case 1609849:
/* 1957 */         return "InversionTimes";
/*      */       case 1609856:
/* 1959 */         return "MetaboliteMapDescription";
/*      */       case 1609857:
/* 1961 */         return "PartialFourier";
/*      */       case 1609858:
/* 1963 */         return "EffectiveEchoTime";
/*      */       case 1609859:
/* 1965 */         return "MetaboliteMapCodeSequence";
/*      */       case 1609860:
/* 1967 */         return "ChemicalShiftSequence";
/*      */       case 1609861:
/* 1969 */         return "CardiacSignalSource";
/*      */       case 1609863:
/* 1971 */         return "DiffusionBValue";
/*      */       case 1609865:
/* 1973 */         return "DiffusionGradientOrientation";
/*      */       case 1609872:
/* 1975 */         return "VelocityEncodingDirection";
/*      */       case 1609873:
/* 1977 */         return "VelocityEncodingMinimumValue";
/*      */       case 1609874:
/* 1979 */         return "VelocityEncodingAcquisitionSequence";
/*      */       case 1609875:
/* 1981 */         return "NumberOfKSpaceTrajectories";
/*      */       case 1609876:
/* 1983 */         return "CoverageOfKSpace";
/*      */       case 1609877:
/* 1985 */         return "SpectroscopyAcquisitionPhaseRows";
/*      */       case 1609878:
/* 1987 */         return "ParallelReductionFactorInPlaneRetired";
/*      */       case 1609880:
/* 1989 */         return "TransmitterFrequency";
/*      */       case 1609984:
/* 1991 */         return "ResonantNucleus";
/*      */       case 1609985:
/* 1993 */         return "FrequencyCorrection";
/*      */       case 1609987:
/* 1995 */         return "MRSpectroscopyFOVGeometrySequence";
/*      */       case 1609988:
/* 1997 */         return "SlabThickness";
/*      */       case 1609989:
/* 1999 */         return "SlabOrientation";
/*      */       case 1609990:
/* 2001 */         return "MidSlabPosition";
/*      */       case 1609991:
/* 2003 */         return "MRSpatialSaturationSequence";
/*      */       case 1610002:
/* 2005 */         return "MRTimingAndRelatedParametersSequence";
/*      */       case 1610004:
/* 2007 */         return "MREchoSequence";
/*      */       case 1610005:
/* 2009 */         return "MRModifierSequence";
/*      */       case 1610007:
/* 2011 */         return "MRDiffusionSequence";
/*      */       case 1610008:
/* 2013 */         return "CardiacSynchronizationSequence";
/*      */       case 1610009:
/* 2015 */         return "MRAveragesSequence";
/*      */       case 1610021:
/* 2017 */         return "MRFOVGeometrySequence";
/*      */       case 1610022:
/* 2019 */         return "VolumeLocalizationSequence";
/*      */       case 1610023:
/* 2021 */         return "SpectroscopyAcquisitionDataColumns";
/*      */       case 1610055:
/* 2023 */         return "DiffusionAnisotropyType";
/*      */       case 1610065:
/* 2025 */         return "FrameReferenceDateTime";
/*      */       case 1610066:
/* 2027 */         return "MRMetaboliteMapSequence";
/*      */       case 1610069:
/* 2029 */         return "ParallelReductionFactorOutOfPlane";
/*      */       case 1610073:
/* 2031 */         return "SpectroscopyAcquisitionOutOfPlanePhaseSteps";
/*      */       case 1610086:
/* 2033 */         return "BulkMotionStatus";
/*      */       case 1610088:
/* 2035 */         return "ParallelReductionFactorSecondInPlane";
/*      */       case 1610089:
/* 2037 */         return "CardiacBeatRejectionTechnique";
/*      */       case 1610096:
/* 2039 */         return "RespiratoryMotionCompensationTechnique";
/*      */       case 1610097:
/* 2041 */         return "RespiratorySignalSource";
/*      */       case 1610098:
/* 2043 */         return "BulkMotionCompensationTechnique";
/*      */       case 1610099:
/* 2045 */         return "BulkMotionSignalSource";
/*      */       case 1610100:
/* 2047 */         return "ApplicableSafetyStandardAgency";
/*      */       case 1610101:
/* 2049 */         return "ApplicableSafetyStandardDescription";
/*      */       case 1610102:
/* 2051 */         return "OperatingModeSequence";
/*      */       case 1610103:
/* 2053 */         return "OperatingModeType";
/*      */       case 1610104:
/* 2055 */         return "OperatingMode";
/*      */       case 1610105:
/* 2057 */         return "SpecificAbsorptionRateDefinition";
/*      */       case 1610112:
/* 2059 */         return "GradientOutputType";
/*      */       case 1610113:
/* 2061 */         return "SpecificAbsorptionRateValue";
/*      */       case 1610114:
/* 2063 */         return "GradientOutput";
/*      */       case 1610115:
/* 2065 */         return "FlowCompensationDirection";
/*      */       case 1610116:
/* 2067 */         return "TaggingDelay";
/*      */       case 1610117:
/* 2069 */         return "RespiratoryMotionCompensationTechniqueDescription";
/*      */       case 1610118:
/* 2071 */         return "RespiratorySignalSourceID";
/*      */       case 1610133:
/* 2073 */         return "ChemicalShiftMinimumIntegrationLimitInHz";
/*      */       case 1610134:
/* 2075 */         return "ChemicalShiftMaximumIntegrationLimitInHz";
/*      */       case 1610135:
/* 2077 */         return "MRVelocityEncodingSequence";
/*      */       case 1610136:
/* 2079 */         return "FirstOrderPhaseCorrection";
/*      */       case 1610137:
/* 2081 */         return "WaterReferencedPhaseCorrection";
/*      */       case 1610240:
/* 2083 */         return "MRSpectroscopyAcquisitionType";
/*      */       case 1610260:
/* 2085 */         return "RespiratoryCyclePosition";
/*      */       case 1610263:
/* 2087 */         return "VelocityEncodingMaximumValue";
/*      */       case 1610264:
/* 2089 */         return "TagSpacingSecondDimension";
/*      */       case 1610265:
/* 2091 */         return "TagAngleSecondAxis";
/*      */       case 1610272:
/* 2093 */         return "FrameAcquisitionDuration";
/*      */       case 1610278:
/* 2095 */         return "MRImageFrameTypeSequence";
/*      */       case 1610279:
/* 2097 */         return "MRSpectroscopyFrameTypeSequence";
/*      */       case 1610289:
/* 2099 */         return "MRAcquisitionPhaseEncodingStepsInPlane";
/*      */       case 1610290:
/* 2101 */         return "MRAcquisitionPhaseEncodingStepsOutOfPlane";
/*      */       case 1610292:
/* 2103 */         return "SpectroscopyAcquisitionPhaseColumns";
/*      */       case 1610294:
/* 2105 */         return "CardiacCyclePosition";
/*      */       case 1610297:
/* 2107 */         return "SpecificAbsorptionRateSequence";
/*      */       case 1610304:
/* 2109 */         return "RFEchoTrainLength";
/*      */       case 1610305:
/* 2111 */         return "GradientEchoTrainLength";
/*      */       case 1610320:
/* 2113 */         return "ArterialSpinLabelingContrast";
/*      */       case 1610321:
/* 2115 */         return "MRArterialSpinLabelingSequence";
/*      */       case 1610322:
/* 2117 */         return "ASLTechniqueDescription";
/*      */       case 1610323:
/* 2119 */         return "ASLSlabNumber";
/*      */       case 1610324:
/* 2121 */         return "ASLSlabThickness";
/*      */       case 1610325:
/* 2123 */         return "ASLSlabOrientation";
/*      */       case 1610326:
/* 2125 */         return "ASLMidSlabPosition";
/*      */       case 1610327:
/* 2127 */         return "ASLContext";
/*      */       case 1610328:
/* 2129 */         return "ASLPulseTrainDuration";
/*      */       case 1610329:
/* 2131 */         return "ASLCrusherFlag";
/*      */       case 1610330:
/* 2133 */         return "ASLCrusherFlowLimit";
/*      */       case 1610331:
/* 2135 */         return "ASLCrusherDescription";
/*      */       case 1610332:
/* 2137 */         return "ASLBolusCutoffFlag";
/*      */       case 1610333:
/* 2139 */         return "ASLBolusCutoffTimingSequence";
/*      */       case 1610334:
/* 2141 */         return "ASLBolusCutoffTechnique";
/*      */       case 1610335:
/* 2143 */         return "ASLBolusCutoffDelayTime";
/*      */       case 1610336:
/* 2145 */         return "ASLSlabSequence";
/*      */       case 1610389:
/* 2147 */         return "ChemicalShiftMinimumIntegrationLimitInppm";
/*      */       case 1610390:
/* 2149 */         return "ChemicalShiftMaximumIntegrationLimitInppm";
/*      */       case 1610391:
/* 2151 */         return "WaterReferenceAcquisition";
/*      */       case 1610392:
/* 2153 */         return "EchoPeakPosition";
/*      */       case 1610497:
/* 2155 */         return "CTAcquisitionTypeSequence";
/*      */       case 1610498:
/* 2157 */         return "AcquisitionType";
/*      */       case 1610499:
/* 2159 */         return "TubeAngle";
/*      */       case 1610500:
/* 2161 */         return "CTAcquisitionDetailsSequence";
/*      */       case 1610501:
/* 2163 */         return "RevolutionTime";
/*      */       case 1610502:
/* 2165 */         return "SingleCollimationWidth";
/*      */       case 1610503:
/* 2167 */         return "TotalCollimationWidth";
/*      */       case 1610504:
/* 2169 */         return "CTTableDynamicsSequence";
/*      */       case 1610505:
/* 2171 */         return "TableSpeed";
/*      */       case 1610512:
/* 2173 */         return "TableFeedPerRotation";
/*      */       case 1610513:
/* 2175 */         return "SpiralPitchFactor";
/*      */       case 1610514:
/* 2177 */         return "CTGeometrySequence";
/*      */       case 1610515:
/* 2179 */         return "DataCollectionCenterPatient";
/*      */       case 1610516:
/* 2181 */         return "CTReconstructionSequence";
/*      */       case 1610517:
/* 2183 */         return "ReconstructionAlgorithm";
/*      */       case 1610518:
/* 2185 */         return "ConvolutionKernelGroup";
/*      */       case 1610519:
/* 2187 */         return "ReconstructionFieldOfView";
/*      */       case 1610520:
/* 2189 */         return "ReconstructionTargetCenterPatient";
/*      */       case 1610521:
/* 2191 */         return "ReconstructionAngle";
/*      */       case 1610528:
/* 2193 */         return "ImageFilter";
/*      */       case 1610529:
/* 2195 */         return "CTExposureSequence";
/*      */       case 1610530:
/* 2197 */         return "ReconstructionPixelSpacing";
/*      */       case 1610531:
/* 2199 */         return "ExposureModulationType";
/*      */       case 1610532:
/* 2201 */         return "EstimatedDoseSaving";
/*      */       case 1610533:
/* 2203 */         return "CTXRayDetailsSequence";
/*      */       case 1610534:
/* 2205 */         return "CTPositionSequence";
/*      */       case 1610535:
/* 2207 */         return "TablePosition";
/*      */       case 1610536:
/* 2209 */         return "ExposureTimeInms";
/*      */       case 1610537:
/* 2211 */         return "CTImageFrameTypeSequence";
/*      */       case 1610544:
/* 2213 */         return "XRayTubeCurrentInmA";
/*      */       case 1610546:
/* 2215 */         return "ExposureInmAs";
/*      */       case 1610547:
/* 2217 */         return "ConstantVolumeFlag";
/*      */       case 1610548:
/* 2219 */         return "FluoroscopyFlag";
/*      */       case 1610549:
/* 2221 */         return "DistanceSourceToDataCollectionCenter";
/*      */       case 1610551:
/* 2223 */         return "ContrastBolusAgentNumber";
/*      */       case 1610552:
/* 2225 */         return "ContrastBolusIngredientCodeSequence";
/*      */       case 1610560:
/* 2227 */         return "ContrastAdministrationProfileSequence";
/*      */       case 1610561:
/* 2229 */         return "ContrastBolusUsageSequence";
/*      */       case 1610562:
/* 2231 */         return "ContrastBolusAgentAdministered";
/*      */       case 1610563:
/* 2233 */         return "ContrastBolusAgentDetected";
/*      */       case 1610564:
/* 2235 */         return "ContrastBolusAgentPhase";
/*      */       case 1610565:
/* 2237 */         return "CTDIvol";
/*      */       case 1610566:
/* 2239 */         return "CTDIPhantomTypeCodeSequence";
/*      */       case 1610577:
/* 2241 */         return "CalciumScoringMassFactorPatient";
/*      */       case 1610578:
/* 2243 */         return "CalciumScoringMassFactorDevice";
/*      */       case 1610579:
/* 2245 */         return "EnergyWeightingFactor";
/*      */       case 1610592:
/* 2247 */         return "CTAdditionalXRaySourceSequence";
/*      */       case 1610753:
/* 2249 */         return "ProjectionPixelCalibrationSequence";
/*      */       case 1610754:
/* 2251 */         return "DistanceSourceToIsocenter";
/*      */       case 1610755:
/* 2253 */         return "DistanceObjectToTableTop";
/*      */       case 1610756:
/* 2255 */         return "ObjectPixelSpacingInCenterOfBeam";
/*      */       case 1610757:
/* 2257 */         return "PositionerPositionSequence";
/*      */       case 1610758:
/* 2259 */         return "TablePositionSequence";
/*      */       case 1610759:
/* 2261 */         return "CollimatorShapeSequence";
/*      */       case 1610768:
/* 2263 */         return "PlanesInAcquisition";
/*      */       case 1610770:
/* 2265 */         return "XAXRFFrameCharacteristicsSequence";
/*      */       case 1610775:
/* 2267 */         return "FrameAcquisitionSequence";
/*      */       case 1610784:
/* 2269 */         return "XRayReceptorType";
/*      */       case 1610787:
/* 2271 */         return "AcquisitionProtocolName";
/*      */       case 1610788:
/* 2273 */         return "AcquisitionProtocolDescription";
/*      */       case 1610789:
/* 2275 */         return "ContrastBolusIngredientOpaque";
/*      */       case 1610790:
/* 2277 */         return "DistanceReceptorPlaneToDetectorHousing";
/*      */       case 1610791:
/* 2279 */         return "IntensifierActiveShape";
/*      */       case 1610792:
/* 2281 */         return "IntensifierActiveDimensions";
/*      */       case 1610793:
/* 2283 */         return "PhysicalDetectorSize";
/*      */       case 1610800:
/* 2285 */         return "PositionOfIsocenterProjection";
/*      */       case 1610802:
/* 2287 */         return "FieldOfViewSequence";
/*      */       case 1610803:
/* 2289 */         return "FieldOfViewDescription";
/*      */       case 1610804:
/* 2291 */         return "ExposureControlSensingRegionsSequence";
/*      */       case 1610805:
/* 2293 */         return "ExposureControlSensingRegionShape";
/*      */       case 1610806:
/* 2295 */         return "ExposureControlSensingRegionLeftVerticalEdge";
/*      */       case 1610807:
/* 2297 */         return "ExposureControlSensingRegionRightVerticalEdge";
/*      */       case 1610808:
/* 2299 */         return "ExposureControlSensingRegionUpperHorizontalEdge";
/*      */       case 1610809:
/* 2301 */         return "ExposureControlSensingRegionLowerHorizontalEdge";
/*      */       case 1610816:
/* 2303 */         return "CenterOfCircularExposureControlSensingRegion";
/*      */       case 1610817:
/* 2305 */         return "RadiusOfCircularExposureControlSensingRegion";
/*      */       case 1610818:
/* 2307 */         return "VerticesOfThePolygonalExposureControlSensingRegion";
/*      */       case 1610823:
/* 2309 */         return "ColumnAngulationPatient";
/*      */       case 1610825:
/* 2311 */         return "BeamAngle";
/*      */       case 1610833:
/* 2313 */         return "FrameDetectorParametersSequence";
/*      */       case 1610834:
/* 2315 */         return "CalculatedAnatomyThickness";
/*      */       case 1610837:
/* 2317 */         return "CalibrationSequence";
/*      */       case 1610838:
/* 2319 */         return "ObjectThicknessSequence";
/*      */       case 1610839:
/* 2321 */         return "PlaneIdentification";
/*      */       case 1610849:
/* 2323 */         return "FieldOfViewDimensionsInFloat";
/*      */       case 1610850:
/* 2325 */         return "IsocenterReferenceSystemSequence";
/*      */       case 1610851:
/* 2327 */         return "PositionerIsocenterPrimaryAngle";
/*      */       case 1610852:
/* 2329 */         return "PositionerIsocenterSecondaryAngle";
/*      */       case 1610853:
/* 2331 */         return "PositionerIsocenterDetectorRotationAngle";
/*      */       case 1610854:
/* 2333 */         return "TableXPositionToIsocenter";
/*      */       case 1610855:
/* 2335 */         return "TableYPositionToIsocenter";
/*      */       case 1610856:
/* 2337 */         return "TableZPositionToIsocenter";
/*      */       case 1610857:
/* 2339 */         return "TableHorizontalRotationAngle";
/*      */       case 1610864:
/* 2341 */         return "TableHeadTiltAngle";
/*      */       case 1610865:
/* 2343 */         return "TableCradleTiltAngle";
/*      */       case 1610866:
/* 2345 */         return "FrameDisplayShutterSequence";
/*      */       case 1610867:
/* 2347 */         return "AcquiredImageAreaDoseProduct";
/*      */       case 1610868:
/* 2349 */         return "CArmPositionerTabletopRelationship";
/*      */       case 1610870:
/* 2351 */         return "XRayGeometrySequence";
/*      */       case 1610871:
/* 2353 */         return "IrradiationEventIdentificationSequence";
/*      */       case 1611012:
/* 2355 */         return "XRay3DFrameTypeSequence";
/*      */       case 1611014:
/* 2357 */         return "ContributingSourcesSequence";
/*      */       case 1611015:
/* 2359 */         return "XRay3DAcquisitionSequence";
/*      */       case 1611016:
/* 2361 */         return "PrimaryPositionerScanArc";
/*      */       case 1611017:
/* 2363 */         return "SecondaryPositionerScanArc";
/*      */       case 1611024:
/* 2365 */         return "PrimaryPositionerScanStartAngle";
/*      */       case 1611025:
/* 2367 */         return "SecondaryPositionerScanStartAngle";
/*      */       case 1611028:
/* 2369 */         return "PrimaryPositionerIncrement";
/*      */       case 1611029:
/* 2371 */         return "SecondaryPositionerIncrement";
/*      */       case 1611030:
/* 2373 */         return "StartAcquisitionDateTime";
/*      */       case 1611031:
/* 2375 */         return "EndAcquisitionDateTime";
/*      */       case 1611032:
/* 2377 */         return "PrimaryPositionerIncrementSign";
/*      */       case 1611033:
/* 2379 */         return "SecondaryPositionerIncrementSign";
/*      */       case 1611044:
/* 2381 */         return "ApplicationName";
/*      */       case 1611045:
/* 2383 */         return "ApplicationVersion";
/*      */       case 1611046:
/* 2385 */         return "ApplicationManufacturer";
/*      */       case 1611047:
/* 2387 */         return "AlgorithmType";
/*      */       case 1611048:
/* 2389 */         return "AlgorithmDescription";
/*      */       case 1611056:
/* 2391 */         return "XRay3DReconstructionSequence";
/*      */       case 1611057:
/* 2393 */         return "ReconstructionDescription";
/*      */       case 1611064:
/* 2395 */         return "PerProjectionAcquisitionSequence";
/*      */       case 1611073:
/* 2397 */         return "DetectorPositionSequence";
/*      */       case 1611074:
/* 2399 */         return "XRayAcquisitionDoseSequence";
/*      */       case 1611075:
/* 2401 */         return "XRaySourceIsocenterPrimaryAngle";
/*      */       case 1611076:
/* 2403 */         return "XRaySourceIsocenterSecondaryAngle";
/*      */       case 1611077:
/* 2405 */         return "BreastSupportIsocenterPrimaryAngle";
/*      */       case 1611078:
/* 2407 */         return "BreastSupportIsocenterSecondaryAngle";
/*      */       case 1611079:
/* 2409 */         return "BreastSupportXPositionToIsocenter";
/*      */       case 1611080:
/* 2411 */         return "BreastSupportYPositionToIsocenter";
/*      */       case 1611081:
/* 2413 */         return "BreastSupportZPositionToIsocenter";
/*      */       case 1611088:
/* 2415 */         return "DetectorIsocenterPrimaryAngle";
/*      */       case 1611089:
/* 2417 */         return "DetectorIsocenterSecondaryAngle";
/*      */       case 1611090:
/* 2419 */         return "DetectorXPositionToIsocenter";
/*      */       case 1611091:
/* 2421 */         return "DetectorYPositionToIsocenter";
/*      */       case 1611092:
/* 2423 */         return "DetectorZPositionToIsocenter";
/*      */       case 1611093:
/* 2425 */         return "XRayGridSequence";
/*      */       case 1611094:
/* 2427 */         return "XRayFilterSequence";
/*      */       case 1611095:
/* 2429 */         return "DetectorActiveAreaTLHCPosition";
/*      */       case 1611096:
/* 2431 */         return "DetectorActiveAreaOrientation";
/*      */       case 1611097:
/* 2433 */         return "PositionerPrimaryAngleDirection";
/*      */       case 1611265:
/* 2435 */         return "DiffusionBMatrixSequence";
/*      */       case 1611266:
/* 2437 */         return "DiffusionBValueXX";
/*      */       case 1611267:
/* 2439 */         return "DiffusionBValueXY";
/*      */       case 1611268:
/* 2441 */         return "DiffusionBValueXZ";
/*      */       case 1611269:
/* 2443 */         return "DiffusionBValueYY";
/*      */       case 1611270:
/* 2445 */         return "DiffusionBValueYZ";
/*      */       case 1611271:
/* 2447 */         return "DiffusionBValueZZ";
/*      */       case 1611521:
/* 2449 */         return "DecayCorrectionDateTime";
/*      */       case 1611541:
/* 2451 */         return "StartDensityThreshold";
/*      */       case 1611542:
/* 2453 */         return "StartRelativeDensityDifferenceThreshold";
/*      */       case 1611543:
/* 2455 */         return "StartCardiacTriggerCountThreshold";
/*      */       case 1611544:
/* 2457 */         return "StartRespiratoryTriggerCountThreshold";
/*      */       case 1611545:
/* 2459 */         return "TerminationCountsThreshold";
/*      */       case 1611552:
/* 2461 */         return "TerminationDensityThreshold";
/*      */       case 1611553:
/* 2463 */         return "TerminationRelativeDensityThreshold";
/*      */       case 1611554:
/* 2465 */         return "TerminationTimeThreshold";
/*      */       case 1611555:
/* 2467 */         return "TerminationCardiacTriggerCountThreshold";
/*      */       case 1611556:
/* 2469 */         return "TerminationRespiratoryTriggerCountThreshold";
/*      */       case 1611557:
/* 2471 */         return "DetectorGeometry";
/*      */       case 1611558:
/* 2473 */         return "TransverseDetectorSeparation";
/*      */       case 1611559:
/* 2475 */         return "AxialDetectorDimension";
/*      */       case 1611561:
/* 2477 */         return "RadiopharmaceuticalAgentNumber";
/*      */       case 1611570:
/* 2479 */         return "PETFrameAcquisitionSequence";
/*      */       case 1611571:
/* 2481 */         return "PETDetectorMotionDetailsSequence";
/*      */       case 1611572:
/* 2483 */         return "PETTableDynamicsSequence";
/*      */       case 1611573:
/* 2485 */         return "PETPositionSequence";
/*      */       case 1611574:
/* 2487 */         return "PETFrameCorrectionFactorsSequence";
/*      */       case 1611575:
/* 2489 */         return "RadiopharmaceuticalUsageSequence";
/*      */       case 1611576:
/* 2491 */         return "AttenuationCorrectionSource";
/*      */       case 1611577:
/* 2493 */         return "NumberOfIterations";
/*      */       case 1611584:
/* 2495 */         return "NumberOfSubsets";
/*      */       case 1611593:
/* 2497 */         return "PETReconstructionSequence";
/*      */       case 1611601:
/* 2499 */         return "PETFrameTypeSequence";
/*      */       case 1611605:
/* 2501 */         return "TimeOfFlightInformationUsed";
/*      */       case 1611606:
/* 2503 */         return "ReconstructionType";
/*      */       case 1611608:
/* 2505 */         return "DecayCorrected";
/*      */       case 1611609:
/* 2507 */         return "AttenuationCorrected";
/*      */       case 1611616:
/* 2509 */         return "ScatterCorrected";
/*      */       case 1611617:
/* 2511 */         return "DeadTimeCorrected";
/*      */       case 1611618:
/* 2513 */         return "GantryMotionCorrected";
/*      */       case 1611619:
/* 2515 */         return "PatientMotionCorrected";
/*      */       case 1611620:
/* 2517 */         return "CountLossNormalizationCorrected";
/*      */       case 1611621:
/* 2519 */         return "RandomsCorrected";
/*      */       case 1611622:
/* 2521 */         return "NonUniformRadialSamplingCorrected";
/*      */       case 1611623:
/* 2523 */         return "SensitivityCalibrated";
/*      */       case 1611624:
/* 2525 */         return "DetectorNormalizationCorrection";
/*      */       case 1611625:
/* 2527 */         return "IterativeReconstructionMethod";
/*      */       case 1611632:
/* 2529 */         return "AttenuationCorrectionTemporalRelationship";
/*      */       case 1611633:
/* 2531 */         return "PatientPhysiologicalStateSequence";
/*      */       case 1611634:
/* 2533 */         return "PatientPhysiologicalStateCodeSequence";
/*      */       case 1611777:
/* 2535 */         return "DepthsOfFocus";
/*      */       case 1611779:
/* 2537 */         return "ExcludedIntervalsSequence";
/*      */       case 1611780:
/* 2539 */         return "ExclusionStartDateTime";
/*      */       case 1611781:
/* 2541 */         return "ExclusionDuration";
/*      */       case 1611782:
/* 2543 */         return "USImageDescriptionSequence";
/*      */       case 1611783:
/* 2545 */         return "ImageDataTypeSequence";
/*      */       case 1611784:
/* 2547 */         return "DataType";
/*      */       case 1611785:
/* 2549 */         return "TransducerScanPatternCodeSequence";
/*      */       case 1611787:
/* 2551 */         return "AliasedDataType";
/*      */       case 1611788:
/* 2553 */         return "PositionMeasuringDeviceUsed";
/*      */       case 1611789:
/* 2555 */         return "TransducerGeometryCodeSequence";
/*      */       case 1611790:
/* 2557 */         return "TransducerBeamSteeringCodeSequence";
/*      */       case 1611791:
/* 2559 */         return "TransducerApplicationCodeSequence";
/*      */       case 1611792:
/* 2561 */         return "ZeroVelocityPixelValue";
/*      */       case 1613825:
/* 2563 */         return "ContributingEquipmentSequence";
/*      */       case 1613826:
/* 2565 */         return "ContributionDateTime";
/*      */       case 1613827:
/* 2567 */         return "ContributionDescription";
/*      */       case 2097165:
/* 2569 */         return "StudyInstanceUID";
/*      */       case 2097166:
/* 2571 */         return "SeriesInstanceUID";
/*      */       case 2097168:
/* 2573 */         return "StudyID";
/*      */       case 2097169:
/* 2575 */         return "SeriesNumber";
/*      */       case 2097170:
/* 2577 */         return "AcquisitionNumber";
/*      */       case 2097171:
/* 2579 */         return "InstanceNumber";
/*      */       case 2097172:
/* 2581 */         return "IsotopeNumber";
/*      */       case 2097173:
/* 2583 */         return "PhaseNumber";
/*      */       case 2097174:
/* 2585 */         return "IntervalNumber";
/*      */       case 2097175:
/* 2587 */         return "TimeSlotNumber";
/*      */       case 2097176:
/* 2589 */         return "AngleNumber";
/*      */       case 2097177:
/* 2591 */         return "ItemNumber";
/*      */       case 2097184:
/* 2593 */         return "PatientOrientation";
/*      */       case 2097186:
/* 2595 */         return "OverlayNumber";
/*      */       case 2097188:
/* 2597 */         return "CurveNumber";
/*      */       case 2097190:
/* 2599 */         return "LUTNumber";
/*      */       case 2097200:
/* 2601 */         return "ImagePosition";
/*      */       case 2097202:
/* 2603 */         return "ImagePositionPatient";
/*      */       case 2097205:
/* 2605 */         return "ImageOrientation";
/*      */       case 2097207:
/* 2607 */         return "ImageOrientationPatient";
/*      */       case 2097232:
/* 2609 */         return "Location";
/*      */       case 2097234:
/* 2611 */         return "FrameOfReferenceUID";
/*      */       case 2097248:
/* 2613 */         return "Laterality";
/*      */       case 2097250:
/* 2615 */         return "ImageLaterality";
/*      */       case 2097264:
/* 2617 */         return "ImageGeometryType";
/*      */       case 2097280:
/* 2619 */         return "MaskingImage";
/*      */       case 2097322:
/* 2621 */         return "ReportNumber";
/*      */       case 2097408:
/* 2623 */         return "TemporalPositionIdentifier";
/*      */       case 2097413:
/* 2625 */         return "NumberOfTemporalPositions";
/*      */       case 2097424:
/* 2627 */         return "TemporalResolution";
/*      */       case 2097664:
/* 2629 */         return "SynchronizationFrameOfReferenceUID";
/*      */       case 2097730:
/* 2631 */         return "SOPInstanceUIDOfConcatenationSource";
/*      */       case 2101248:
/* 2633 */         return "SeriesInStudy";
/*      */       case 2101249:
/* 2635 */         return "AcquisitionsInSeries";
/*      */       case 2101250:
/* 2637 */         return "ImagesInAcquisition";
/*      */       case 2101251:
/* 2639 */         return "ImagesInSeries";
/*      */       case 2101252:
/* 2641 */         return "AcquisitionsInStudy";
/*      */       case 2101253:
/* 2643 */         return "ImagesInStudy";
/*      */       case 2101280:
/* 2645 */         return "Reference";
/*      */       case 2101312:
/* 2647 */         return "PositionReferenceIndicator";
/*      */       case 2101313:
/* 2649 */         return "SliceLocation";
/*      */       case 2101360:
/* 2651 */         return "OtherStudyNumbers";
/*      */       case 2101760:
/* 2653 */         return "NumberOfPatientRelatedStudies";
/*      */       case 2101762:
/* 2655 */         return "NumberOfPatientRelatedSeries";
/*      */       case 2101764:
/* 2657 */         return "NumberOfPatientRelatedInstances";
/*      */       case 2101766:
/* 2659 */         return "NumberOfStudyRelatedSeries";
/*      */       case 2101768:
/* 2661 */         return "NumberOfStudyRelatedInstances";
/*      */       case 2101769:
/* 2663 */         return "NumberOfSeriesRelatedInstances";
/*      */       case 2109696:
/* 2665 */         return "SourceImageIDs";
/*      */       case 2110465:
/* 2667 */         return "ModifyingDeviceID";
/*      */       case 2110466:
/* 2669 */         return "ModifiedImageID";
/*      */       case 2110467:
/* 2671 */         return "ModifiedImageDate";
/*      */       case 2110468:
/* 2673 */         return "ModifyingDeviceManufacturer";
/*      */       case 2110469:
/* 2675 */         return "ModifiedImageTime";
/*      */       case 2110470:
/* 2677 */         return "ModifiedImageDescription";
/*      */       case 2113536:
/* 2679 */         return "ImageComments";
/*      */       case 2117632:
/* 2681 */         return "OriginalImageIdentification";
/*      */       case 2117634:
/* 2683 */         return "OriginalImageIdentificationNomenclature";
/*      */       case 2134102:
/* 2685 */         return "StackID";
/*      */       case 2134103:
/* 2687 */         return "InStackPositionNumber";
/*      */       case 2134129:
/* 2689 */         return "FrameAnatomySequence";
/*      */       case 2134130:
/* 2691 */         return "FrameLaterality";
/*      */       case 2134289:
/* 2693 */         return "FrameContentSequence";
/*      */       case 2134291:
/* 2695 */         return "PlanePositionSequence";
/*      */       case 2134294:
/* 2697 */         return "PlaneOrientationSequence";
/*      */       case 2134312:
/* 2699 */         return "TemporalPositionIndex";
/*      */       case 2134355:
/* 2701 */         return "NominalCardiacTriggerDelayTime";
/*      */       case 2134356:
/* 2703 */         return "NominalCardiacTriggerTimePriorToRPeak";
/*      */       case 2134357:
/* 2705 */         return "ActualCardiacTriggerTimePriorToRPeak";
/*      */       case 2134358:
/* 2707 */         return "FrameAcquisitionNumber";
/*      */       case 2134359:
/* 2709 */         return "DimensionIndexValues";
/*      */       case 2134360:
/* 2711 */         return "FrameComments";
/*      */       case 2134369:
/* 2713 */         return "ConcatenationUID";
/*      */       case 2134370:
/* 2715 */         return "InConcatenationNumber";
/*      */       case 2134371:
/* 2717 */         return "InConcatenationTotalNumber";
/*      */       case 2134372:
/* 2719 */         return "DimensionOrganizationUID";
/*      */       case 2134373:
/* 2721 */         return "DimensionIndexPointer";
/*      */       case 2134375:
/* 2723 */         return "FunctionalGroupPointer";
/*      */       case 2134384:
/* 2725 */         return "UnassignedSharedConvertedAttributesSequence";
/*      */       case 2134385:
/* 2727 */         return "UnassignedPerFrameConvertedAttributesSequence";
/*      */       case 2134386:
/* 2729 */         return "ConversionSourceAttributesSequence";
/*      */       case 2134547:
/* 2731 */         return "DimensionIndexPrivateCreator";
/*      */       case 2134561:
/* 2733 */         return "DimensionOrganizationSequence";
/*      */       case 2134562:
/* 2735 */         return "DimensionIndexSequence";
/*      */       case 2134568:
/* 2737 */         return "ConcatenationFrameOffsetNumber";
/*      */       case 2134584:
/* 2739 */         return "FunctionalGroupPrivateCreator";
/*      */       case 2134593:
/* 2741 */         return "NominalPercentageOfCardiacPhase";
/*      */       case 2134597:
/* 2743 */         return "NominalPercentageOfRespiratoryPhase";
/*      */       case 2134598:
/* 2745 */         return "StartingRespiratoryAmplitude";
/*      */       case 2134599:
/* 2747 */         return "StartingRespiratoryPhase";
/*      */       case 2134600:
/* 2749 */         return "EndingRespiratoryAmplitude";
/*      */       case 2134601:
/* 2751 */         return "EndingRespiratoryPhase";
/*      */       case 2134608:
/* 2753 */         return "RespiratoryTriggerType";
/*      */       case 2134609:
/* 2755 */         return "RRIntervalTimeNominal";
/*      */       case 2134610:
/* 2757 */         return "ActualCardiacTriggerDelayTime";
/*      */       case 2134611:
/* 2759 */         return "RespiratorySynchronizationSequence";
/*      */       case 2134612:
/* 2761 */         return "RespiratoryIntervalTime";
/*      */       case 2134613:
/* 2763 */         return "NominalRespiratoryTriggerDelayTime";
/*      */       case 2134614:
/* 2765 */         return "RespiratoryTriggerDelayThreshold";
/*      */       case 2134615:
/* 2767 */         return "ActualRespiratoryTriggerDelayTime";
/*      */       case 2134785:
/* 2769 */         return "ImagePositionVolume";
/*      */       case 2134786:
/* 2771 */         return "ImageOrientationVolume";
/*      */       case 2134791:
/* 2773 */         return "UltrasoundAcquisitionGeometry";
/*      */       case 2134792:
/* 2775 */         return "ApexPosition";
/*      */       case 2134793:
/* 2777 */         return "VolumeToTransducerMappingMatrix";
/*      */       case 2134794:
/* 2779 */         return "VolumeToTableMappingMatrix";
/*      */       case 2134795:
/* 2781 */         return "VolumeToTransducerRelationship";
/*      */       case 2134796:
/* 2783 */         return "PatientFrameOfReferenceSource";
/*      */       case 2134797:
/* 2785 */         return "TemporalPositionTimeOffset";
/*      */       case 2134798:
/* 2787 */         return "PlanePositionVolumeSequence";
/*      */       case 2134799:
/* 2789 */         return "PlaneOrientationVolumeSequence";
/*      */       case 2134800:
/* 2791 */         return "TemporalPositionSequence";
/*      */       case 2134801:
/* 2793 */         return "DimensionOrganizationType";
/*      */       case 2134802:
/* 2795 */         return "VolumeFrameOfReferenceUID";
/*      */       case 2134803:
/* 2797 */         return "TableFrameOfReferenceUID";
/*      */       case 2135073:
/* 2799 */         return "DimensionDescriptionLabel";
/*      */       case 2135120:
/* 2801 */         return "PatientOrientationInFrameSequence";
/*      */       case 2135123:
/* 2803 */         return "FrameLabel";
/*      */       case 2135320:
/* 2805 */         return "AcquisitionIndex";
/*      */       case 2135337:
/* 2807 */         return "ContributingSOPInstancesReferenceSequence";
/*      */       case 2135350:
/* 2809 */         return "ReconstructionIndex";
/*      */       case 2228225:
/* 2811 */         return "LightPathFilterPassThroughWavelength";
/*      */       case 2228226:
/* 2813 */         return "LightPathFilterPassBand";
/*      */       case 2228227:
/* 2815 */         return "ImagePathFilterPassThroughWavelength";
/*      */       case 2228228:
/* 2817 */         return "ImagePathFilterPassBand";
/*      */       case 2228229:
/* 2819 */         return "PatientEyeMovementCommanded";
/*      */       case 2228230:
/* 2821 */         return "PatientEyeMovementCommandCodeSequence";
/*      */       case 2228231:
/* 2823 */         return "SphericalLensPower";
/*      */       case 2228232:
/* 2825 */         return "CylinderLensPower";
/*      */       case 2228233:
/* 2827 */         return "CylinderAxis";
/*      */       case 2228234:
/* 2829 */         return "EmmetropicMagnification";
/*      */       case 2228235:
/* 2831 */         return "IntraOcularPressure";
/*      */       case 2228236:
/* 2833 */         return "HorizontalFieldOfView";
/*      */       case 2228237:
/* 2835 */         return "PupilDilated";
/*      */       case 2228238:
/* 2837 */         return "DegreeOfDilation";
/*      */       case 2228240:
/* 2839 */         return "StereoBaselineAngle";
/*      */       case 2228241:
/* 2841 */         return "StereoBaselineDisplacement";
/*      */       case 2228242:
/* 2843 */         return "StereoHorizontalPixelOffset";
/*      */       case 2228243:
/* 2845 */         return "StereoVerticalPixelOffset";
/*      */       case 2228244:
/* 2847 */         return "StereoRotation";
/*      */       case 2228245:
/* 2849 */         return "AcquisitionDeviceTypeCodeSequence";
/*      */       case 2228246:
/* 2851 */         return "IlluminationTypeCodeSequence";
/*      */       case 2228247:
/* 2853 */         return "LightPathFilterTypeStackCodeSequence";
/*      */       case 2228248:
/* 2855 */         return "ImagePathFilterTypeStackCodeSequence";
/*      */       case 2228249:
/* 2857 */         return "LensesCodeSequence";
/*      */       case 2228250:
/* 2859 */         return "ChannelDescriptionCodeSequence";
/*      */       case 2228251:
/* 2861 */         return "RefractiveStateSequence";
/*      */       case 2228252:
/* 2863 */         return "MydriaticAgentCodeSequence";
/*      */       case 2228253:
/* 2865 */         return "RelativeImagePositionCodeSequence";
/*      */       case 2228254:
/* 2867 */         return "CameraAngleOfView";
/*      */       case 2228256:
/* 2869 */         return "StereoPairsSequence";
/*      */       case 2228257:
/* 2871 */         return "LeftImageSequence";
/*      */       case 2228258:
/* 2873 */         return "RightImageSequence";
/*      */       case 2228272:
/* 2875 */         return "AxialLengthOfTheEye";
/*      */       case 2228273:
/* 2877 */         return "OphthalmicFrameLocationSequence";
/*      */       case 2228274:
/* 2879 */         return "ReferenceCoordinates";
/*      */       case 2228277:
/* 2881 */         return "DepthSpatialResolution";
/*      */       case 2228278:
/* 2883 */         return "MaximumDepthDistortion";
/*      */       case 2228279:
/* 2885 */         return "AlongScanSpatialResolution";
/*      */       case 2228280:
/* 2887 */         return "MaximumAlongScanDistortion";
/*      */       case 2228281:
/* 2889 */         return "OphthalmicImageOrientation";
/*      */       case 2228289:
/* 2891 */         return "DepthOfTransverseImage";
/*      */       case 2228290:
/* 2893 */         return "MydriaticAgentConcentrationUnitsSequence";
/*      */       case 2228296:
/* 2895 */         return "AcrossScanSpatialResolution";
/*      */       case 2228297:
/* 2897 */         return "MaximumAcrossScanDistortion";
/*      */       case 2228302:
/* 2899 */         return "MydriaticAgentConcentration";
/*      */       case 2228309:
/* 2901 */         return "IlluminationWaveLength";
/*      */       case 2228310:
/* 2903 */         return "IlluminationPower";
/*      */       case 2228311:
/* 2905 */         return "IlluminationBandwidth";
/*      */       case 2228312:
/* 2907 */         return "MydriaticAgentSequence";
/*      */       case 2232327:
/* 2909 */         return "OphthalmicAxialMeasurementsRightEyeSequence";
/*      */       case 2232328:
/* 2911 */         return "OphthalmicAxialMeasurementsLeftEyeSequence";
/*      */       case 2232329:
/* 2913 */         return "OphthalmicAxialMeasurementsDeviceType";
/*      */       case 2232336:
/* 2915 */         return "OphthalmicAxialLengthMeasurementsType";
/*      */       case 2232338:
/* 2917 */         return "OphthalmicAxialLengthSequence";
/*      */       case 2232345:
/* 2919 */         return "OphthalmicAxialLength";
/*      */       case 2232356:
/* 2921 */         return "LensStatusCodeSequence";
/*      */       case 2232357:
/* 2923 */         return "VitreousStatusCodeSequence";
/*      */       case 2232360:
/* 2925 */         return "IOLFormulaCodeSequence";
/*      */       case 2232361:
/* 2927 */         return "IOLFormulaDetail";
/*      */       case 2232371:
/* 2929 */         return "KeratometerIndex";
/*      */       case 2232373:
/* 2931 */         return "SourceOfOphthalmicAxialLengthCodeSequence";
/*      */       case 2232375:
/* 2933 */         return "TargetRefraction";
/*      */       case 2232377:
/* 2935 */         return "RefractiveProcedureOccurred";
/*      */       case 2232384:
/* 2937 */         return "RefractiveSurgeryTypeCodeSequence";
/*      */       case 2232388:
/* 2939 */         return "OphthalmicUltrasoundMethodCodeSequence";
/*      */       case 2232400:
/* 2941 */         return "OphthalmicAxialLengthMeasurementsSequence";
/*      */       case 2232403:
/* 2943 */         return "IOLPower";
/*      */       case 2232404:
/* 2945 */         return "PredictedRefractiveError";
/*      */       case 2232409:
/* 2947 */         return "OphthalmicAxialLengthVelocity";
/*      */       case 2232421:
/* 2949 */         return "LensStatusDescription";
/*      */       case 2232422:
/* 2951 */         return "VitreousStatusDescription";
/*      */       case 2232464:
/* 2953 */         return "IOLPowerSequence";
/*      */       case 2232466:
/* 2955 */         return "LensConstantSequence";
/*      */       case 2232467:
/* 2957 */         return "IOLManufacturer";
/*      */       case 2232468:
/* 2959 */         return "LensConstantDescription";
/*      */       case 2232469:
/* 2961 */         return "ImplantName";
/*      */       case 2232470:
/* 2963 */         return "KeratometryMeasurementTypeCodeSequence";
/*      */       case 2232471:
/* 2965 */         return "ImplantPartNumber";
/*      */       case 2232576:
/* 2967 */         return "ReferencedOphthalmicAxialMeasurementsSequence";
/*      */       case 2232577:
/* 2969 */         return "OphthalmicAxialLengthMeasurementsSegmentNameCodeSequence";
/*      */       case 2232579:
/* 2971 */         return "RefractiveErrorBeforeRefractiveSurgeryCodeSequence";
/*      */       case 2232609:
/* 2973 */         return "IOLPowerForExactEmmetropia";
/*      */       case 2232610:
/* 2975 */         return "IOLPowerForExactTargetRefraction";
/*      */       case 2232613:
/* 2977 */         return "AnteriorChamberDepthDefinitionCodeSequence";
/*      */       case 2232615:
/* 2979 */         return "LensThicknessSequence";
/*      */       case 2232616:
/* 2981 */         return "AnteriorChamberDepthSequence";
/*      */       case 2232624:
/* 2983 */         return "LensThickness";
/*      */       case 2232625:
/* 2985 */         return "AnteriorChamberDepth";
/*      */       case 2232626:
/* 2987 */         return "SourceOfLensThicknessDataCodeSequence";
/*      */       case 2232627:
/* 2989 */         return "SourceOfAnteriorChamberDepthDataCodeSequence";
/*      */       case 2232628:
/* 2991 */         return "SourceOfRefractiveMeasurementsSequence";
/*      */       case 2232629:
/* 2993 */         return "SourceOfRefractiveMeasurementsCodeSequence";
/*      */       case 2232640:
/* 2995 */         return "OphthalmicAxialLengthMeasurementModified";
/*      */       case 2232656:
/* 2997 */         return "OphthalmicAxialLengthDataSourceCodeSequence";
/*      */       case 2232659:
/* 2999 */         return "OphthalmicAxialLengthAcquisitionMethodCodeSequence";
/*      */       case 2232661:
/* 3001 */         return "SignalToNoiseRatio";
/*      */       case 2232665:
/* 3003 */         return "OphthalmicAxialLengthDataSourceDescription";
/*      */       case 2232848:
/* 3005 */         return "OphthalmicAxialLengthMeasurementsTotalLengthSequence";
/*      */       case 2232849:
/* 3007 */         return "OphthalmicAxialLengthMeasurementsSegmentalLengthSequence";
/*      */       case 2232850:
/* 3009 */         return "OphthalmicAxialLengthMeasurementsLengthSummationSequence";
/*      */       case 2232864:
/* 3011 */         return "UltrasoundOphthalmicAxialLengthMeasurementsSequence";
/*      */       case 2232869:
/* 3013 */         return "OpticalOphthalmicAxialLengthMeasurementsSequence";
/*      */       case 2232880:
/* 3015 */         return "UltrasoundSelectedOphthalmicAxialLengthSequence";
/*      */       case 2232912:
/* 3017 */         return "OphthalmicAxialLengthSelectionMethodCodeSequence";
/*      */       case 2232917:
/* 3019 */         return "OpticalSelectedOphthalmicAxialLengthSequence";
/*      */       case 2232919:
/* 3021 */         return "SelectedSegmentalOphthalmicAxialLengthSequence";
/*      */       case 2232928:
/* 3023 */         return "SelectedTotalOphthalmicAxialLengthSequence";
/*      */       case 2232930:
/* 3025 */         return "OphthalmicAxialLengthQualityMetricSequence";
/*      */       case 2232933:
/* 3027 */         return "OphthalmicAxialLengthQualityMetricTypeCodeSequence";
/*      */       case 2232947:
/* 3029 */         return "OphthalmicAxialLengthQualityMetricTypeDescription";
/*      */       case 2233088:
/* 3031 */         return "IntraocularLensCalculationsRightEyeSequence";
/*      */       case 2233104:
/* 3033 */         return "IntraocularLensCalculationsLeftEyeSequence";
/*      */       case 2233136:
/* 3035 */         return "ReferencedOphthalmicAxialLengthMeasurementQCImageSequence";
/*      */       case 2233365:
/* 3037 */         return "OphthalmicMappingDeviceType";
/*      */       case 2233376:
/* 3039 */         return "AcquisitionMethodCodeSequence";
/*      */       case 2233379:
/* 3041 */         return "AcquisitionMethodAlgorithmSequence";
/*      */       case 2233398:
/* 3043 */         return "OphthalmicThicknessMapTypeCodeSequence";
/*      */       case 2233411:
/* 3045 */         return "OphthalmicThicknessMappingNormalsSequence";
/*      */       case 2233413:
/* 3047 */         return "RetinalThicknessDefinitionCodeSequence";
/*      */       case 2233424:
/* 3049 */         return "PixelValueMappingToCodedConceptSequence";
/*      */       case 2233426:
/* 3051 */         return "MappedPixelValue";
/*      */       case 2233428:
/* 3053 */         return "PixelValueMappingExplanation";
/*      */       case 2233432:
/* 3055 */         return "OphthalmicThicknessMapQualityThresholdSequence";
/*      */       case 2233440:
/* 3057 */         return "OphthalmicThicknessMapThresholdQualityRating";
/*      */       case 2233443:
/* 3059 */         return "AnatomicStructureReferencePoint";
/*      */       case 2233445:
/* 3061 */         return "RegistrationToLocalizerSequence";
/*      */       case 2233446:
/* 3063 */         return "RegisteredLocalizerUnits";
/*      */       case 2233447:
/* 3065 */         return "RegisteredLocalizerTopLeftHandCorner";
/*      */       case 2233448:
/* 3067 */         return "RegisteredLocalizerBottomRightHandCorner";
/*      */       case 2233456:
/* 3069 */         return "OphthalmicThicknessMapQualityRatingSequence";
/*      */       case 2233458:
/* 3071 */         return "RelevantOPTAttributesSequence";
/*      */       case 2359312:
/* 3073 */         return "VisualFieldHorizontalExtent";
/*      */       case 2359313:
/* 3075 */         return "VisualFieldVerticalExtent";
/*      */       case 2359314:
/* 3077 */         return "VisualFieldShape";
/*      */       case 2359318:
/* 3079 */         return "ScreeningTestModeCodeSequence";
/*      */       case 2359320:
/* 3081 */         return "MaximumStimulusLuminance";
/*      */       case 2359328:
/* 3083 */         return "BackgroundLuminance";
/*      */       case 2359329:
/* 3085 */         return "StimulusColorCodeSequence";
/*      */       case 2359332:
/* 3087 */         return "BackgroundIlluminationColorCodeSequence";
/*      */       case 2359333:
/* 3089 */         return "StimulusArea";
/*      */       case 2359336:
/* 3091 */         return "StimulusPresentationTime";
/*      */       case 2359346:
/* 3093 */         return "FixationSequence";
/*      */       case 2359347:
/* 3095 */         return "FixationMonitoringCodeSequence";
/*      */       case 2359348:
/* 3097 */         return "VisualFieldCatchTrialSequence";
/*      */       case 2359349:
/* 3099 */         return "FixationCheckedQuantity";
/*      */       case 2359350:
/* 3101 */         return "PatientNotProperlyFixatedQuantity";
/*      */       case 2359351:
/* 3103 */         return "PresentedVisualStimuliDataFlag";
/*      */       case 2359352:
/* 3105 */         return "NumberOfVisualStimuli";
/*      */       case 2359353:
/* 3107 */         return "ExcessiveFixationLossesDataFlag";
/*      */       case 2359360:
/* 3109 */         return "ExcessiveFixationLosses";
/*      */       case 2359362:
/* 3111 */         return "StimuliRetestingQuantity";
/*      */       case 2359364:
/* 3113 */         return "CommentsOnPatientPerformanceOfVisualField";
/*      */       case 2359365:
/* 3115 */         return "FalseNegativesEstimateFlag";
/*      */       case 2359366:
/* 3117 */         return "FalseNegativesEstimate";
/*      */       case 2359368:
/* 3119 */         return "NegativeCatchTrialsQuantity";
/*      */       case 2359376:
/* 3121 */         return "FalseNegativesQuantity";
/*      */       case 2359377:
/* 3123 */         return "ExcessiveFalseNegativesDataFlag";
/*      */       case 2359378:
/* 3125 */         return "ExcessiveFalseNegatives";
/*      */       case 2359379:
/* 3127 */         return "FalsePositivesEstimateFlag";
/*      */       case 2359380:
/* 3129 */         return "FalsePositivesEstimate";
/*      */       case 2359381:
/* 3131 */         return "CatchTrialsDataFlag";
/*      */       case 2359382:
/* 3133 */         return "PositiveCatchTrialsQuantity";
/*      */       case 2359383:
/* 3135 */         return "TestPointNormalsDataFlag";
/*      */       case 2359384:
/* 3137 */         return "TestPointNormalsSequence";
/*      */       case 2359385:
/* 3139 */         return "GlobalDeviationProbabilityNormalsFlag";
/*      */       case 2359392:
/* 3141 */         return "FalsePositivesQuantity";
/*      */       case 2359393:
/* 3143 */         return "ExcessiveFalsePositivesDataFlag";
/*      */       case 2359394:
/* 3145 */         return "ExcessiveFalsePositives";
/*      */       case 2359395:
/* 3147 */         return "VisualFieldTestNormalsFlag";
/*      */       case 2359396:
/* 3149 */         return "ResultsNormalsSequence";
/*      */       case 2359397:
/* 3151 */         return "AgeCorrectedSensitivityDeviationAlgorithmSequence";
/*      */       case 2359398:
/* 3153 */         return "GlobalDeviationFromNormal";
/*      */       case 2359399:
/* 3155 */         return "GeneralizedDefectSensitivityDeviationAlgorithmSequence";
/*      */       case 2359400:
/* 3157 */         return "LocalizedDeviationFromNormal";
/*      */       case 2359401:
/* 3159 */         return "PatientReliabilityIndicator";
/*      */       case 2359408:
/* 3161 */         return "VisualFieldMeanSensitivity";
/*      */       case 2359409:
/* 3163 */         return "GlobalDeviationProbability";
/*      */       case 2359410:
/* 3165 */         return "LocalDeviationProbabilityNormalsFlag";
/*      */       case 2359411:
/* 3167 */         return "LocalizedDeviationProbability";
/*      */       case 2359412:
/* 3169 */         return "ShortTermFluctuationCalculated";
/*      */       case 2359413:
/* 3171 */         return "ShortTermFluctuation";
/*      */       case 2359414:
/* 3173 */         return "ShortTermFluctuationProbabilityCalculated";
/*      */       case 2359415:
/* 3175 */         return "ShortTermFluctuationProbability";
/*      */       case 2359416:
/* 3177 */         return "CorrectedLocalizedDeviationFromNormalCalculated";
/*      */       case 2359417:
/* 3179 */         return "CorrectedLocalizedDeviationFromNormal";
/*      */       case 2359424:
/* 3181 */         return "CorrectedLocalizedDeviationFromNormalProbabilityCalculated";
/*      */       case 2359425:
/* 3183 */         return "CorrectedLocalizedDeviationFromNormalProbability";
/*      */       case 2359427:
/* 3185 */         return "GlobalDeviationProbabilitySequence";
/*      */       case 2359429:
/* 3187 */         return "LocalizedDeviationProbabilitySequence";
/*      */       case 2359430:
/* 3189 */         return "FovealSensitivityMeasured";
/*      */       case 2359431:
/* 3191 */         return "FovealSensitivity";
/*      */       case 2359432:
/* 3193 */         return "VisualFieldTestDuration";
/*      */       case 2359433:
/* 3195 */         return "VisualFieldTestPointSequence";
/*      */       case 2359440:
/* 3197 */         return "VisualFieldTestPointXCoordinate";
/*      */       case 2359441:
/* 3199 */         return "VisualFieldTestPointYCoordinate";
/*      */       case 2359442:
/* 3201 */         return "AgeCorrectedSensitivityDeviationValue";
/*      */       case 2359443:
/* 3203 */         return "StimulusResults";
/*      */       case 2359444:
/* 3205 */         return "SensitivityValue";
/*      */       case 2359445:
/* 3207 */         return "RetestStimulusSeen";
/*      */       case 2359446:
/* 3209 */         return "RetestSensitivityValue";
/*      */       case 2359447:
/* 3211 */         return "VisualFieldTestPointNormalsSequence";
/*      */       case 2359448:
/* 3213 */         return "QuantifiedDefect";
/*      */       case 2359552:
/* 3215 */         return "AgeCorrectedSensitivityDeviationProbabilityValue";
/*      */       case 2359554:
/* 3217 */         return "GeneralizedDefectCorrectedSensitivityDeviationFlag";
/*      */       case 2359555:
/* 3219 */         return "GeneralizedDefectCorrectedSensitivityDeviationValue";
/*      */       case 2359556:
/* 3221 */         return "GeneralizedDefectCorrectedSensitivityDeviationProbabilityValue";
/*      */       case 2359557:
/* 3223 */         return "MinimumSensitivityValue";
/*      */       case 2359558:
/* 3225 */         return "BlindSpotLocalized";
/*      */       case 2359559:
/* 3227 */         return "BlindSpotXCoordinate";
/*      */       case 2359560:
/* 3229 */         return "BlindSpotYCoordinate";
/*      */       case 2359568:
/* 3231 */         return "VisualAcuityMeasurementSequence";
/*      */       case 2359570:
/* 3233 */         return "RefractiveParametersUsedOnPatientSequence";
/*      */       case 2359571:
/* 3235 */         return "MeasurementLaterality";
/*      */       case 2359572:
/* 3237 */         return "OphthalmicPatientClinicalInformationLeftEyeSequence";
/*      */       case 2359573:
/* 3239 */         return "OphthalmicPatientClinicalInformationRightEyeSequence";
/*      */       case 2359575:
/* 3241 */         return "FovealPointNormativeDataFlag";
/*      */       case 2359576:
/* 3243 */         return "FovealPointProbabilityValue";
/*      */       case 2359584:
/* 3245 */         return "ScreeningBaselineMeasured";
/*      */       case 2359586:
/* 3247 */         return "ScreeningBaselineMeasuredSequence";
/*      */       case 2359588:
/* 3249 */         return "ScreeningBaselineType";
/*      */       case 2359590:
/* 3251 */         return "ScreeningBaselineValue";
/*      */       case 2359810:
/* 3253 */         return "AlgorithmSource";
/*      */       case 2360070:
/* 3255 */         return "DataSetName";
/*      */       case 2360071:
/* 3257 */         return "DataSetVersion";
/*      */       case 2360072:
/* 3259 */         return "DataSetSource";
/*      */       case 2360073:
/* 3261 */         return "DataSetDescription";
/*      */       case 2360087:
/* 3263 */         return "VisualFieldTestReliabilityGlobalIndexSequence";
/*      */       case 2360096:
/* 3265 */         return "VisualFieldGlobalResultsIndexSequence";
/*      */       case 2360101:
/* 3267 */         return "DataObservationSequence";
/*      */       case 2360120:
/* 3269 */         return "IndexNormalsFlag";
/*      */       case 2360129:
/* 3271 */         return "IndexProbability";
/*      */       case 2360132:
/* 3273 */         return "IndexProbabilitySequence";
/*      */       case 2621442:
/* 3275 */         return "SamplesPerPixel";
/*      */       case 2621443:
/* 3277 */         return "SamplesPerPixelUsed";
/*      */       case 2621444:
/* 3279 */         return "PhotometricInterpretation";
/*      */       case 2621445:
/* 3281 */         return "ImageDimensions";
/*      */       case 2621446:
/* 3283 */         return "PlanarConfiguration";
/*      */       case 2621448:
/* 3285 */         return "NumberOfFrames";
/*      */       case 2621449:
/* 3287 */         return "FrameIncrementPointer";
/*      */       case 2621450:
/* 3289 */         return "FrameDimensionPointer";
/*      */       case 2621456:
/* 3291 */         return "Rows";
/*      */       case 2621457:
/* 3293 */         return "Columns";
/*      */       case 2621458:
/* 3295 */         return "Planes";
/*      */       case 2621460:
/* 3297 */         return "UltrasoundColorDataPresent";
/*      */       case 2621488:
/* 3299 */         return "PixelSpacing";
/*      */       case 2621489:
/* 3301 */         return "ZoomFactor";
/*      */       case 2621490:
/* 3303 */         return "ZoomCenter";
/*      */       case 2621492:
/* 3305 */         return "PixelAspectRatio";
/*      */       case 2621504:
/* 3307 */         return "ImageFormat";
/*      */       case 2621520:
/* 3309 */         return "ManipulatedImage";
/*      */       case 2621521:
/* 3311 */         return "CorrectedImage";
/*      */       case 2621535:
/* 3313 */         return "CompressionRecognitionCode";
/*      */       case 2621536:
/* 3315 */         return "CompressionCode";
/*      */       case 2621537:
/* 3317 */         return "CompressionOriginator";
/*      */       case 2621538:
/* 3319 */         return "CompressionLabel";
/*      */       case 2621539:
/* 3321 */         return "CompressionDescription";
/*      */       case 2621541:
/* 3323 */         return "CompressionSequence";
/*      */       case 2621542:
/* 3325 */         return "CompressionStepPointers";
/*      */       case 2621544:
/* 3327 */         return "RepeatInterval";
/*      */       case 2621545:
/* 3329 */         return "BitsGrouped";
/*      */       case 2621552:
/* 3331 */         return "PerimeterTable";
/*      */       case 2621553:
/* 3333 */         return "PerimeterValue";
/*      */       case 2621568:
/* 3335 */         return "PredictorRows";
/*      */       case 2621569:
/* 3337 */         return "PredictorColumns";
/*      */       case 2621570:
/* 3339 */         return "PredictorConstants";
/*      */       case 2621584:
/* 3341 */         return "BlockedPixels";
/*      */       case 2621585:
/* 3343 */         return "BlockRows";
/*      */       case 2621586:
/* 3345 */         return "BlockColumns";
/*      */       case 2621587:
/* 3347 */         return "RowOverlap";
/*      */       case 2621588:
/* 3349 */         return "ColumnOverlap";
/*      */       case 2621696:
/* 3351 */         return "BitsAllocated";
/*      */       case 2621697:
/* 3353 */         return "BitsStored";
/*      */       case 2621698:
/* 3355 */         return "HighBit";
/*      */       case 2621699:
/* 3357 */         return "PixelRepresentation";
/*      */       case 2621700:
/* 3359 */         return "SmallestValidPixelValue";
/*      */       case 2621701:
/* 3361 */         return "LargestValidPixelValue";
/*      */       case 2621702:
/* 3363 */         return "SmallestImagePixelValue";
/*      */       case 2621703:
/* 3365 */         return "LargestImagePixelValue";
/*      */       case 2621704:
/* 3367 */         return "SmallestPixelValueInSeries";
/*      */       case 2621705:
/* 3369 */         return "LargestPixelValueInSeries";
/*      */       case 2621712:
/* 3371 */         return "SmallestImagePixelValueInPlane";
/*      */       case 2621713:
/* 3373 */         return "LargestImagePixelValueInPlane";
/*      */       case 2621728:
/* 3375 */         return "PixelPaddingValue";
/*      */       case 2621729:
/* 3377 */         return "PixelPaddingRangeLimit";
/*      */       case 2621730:
/* 3379 */         return "FloatPixelPaddingValue";
/*      */       case 2621731:
/* 3381 */         return "DoubleFloatPixelPaddingValue";
/*      */       case 2621732:
/* 3383 */         return "FloatPixelPaddingRangeLimit";
/*      */       case 2621733:
/* 3385 */         return "DoubleFloatPixelPaddingRangeLimit";
/*      */       case 2621952:
/* 3387 */         return "ImageLocation";
/*      */       case 2622208:
/* 3389 */         return "QualityControlImage";
/*      */       case 2622209:
/* 3391 */         return "BurnedInAnnotation";
/*      */       case 2622210:
/* 3393 */         return "RecognizableVisualFeatures";
/*      */       case 2622211:
/* 3395 */         return "LongitudinalTemporalInformationModified";
/*      */       case 2622212:
/* 3397 */         return "ReferencedColorPaletteInstanceUID";
/*      */       case 2622464:
/* 3399 */         return "TransformLabel";
/*      */       case 2622465:
/* 3401 */         return "TransformVersionNumber";
/*      */       case 2622466:
/* 3403 */         return "NumberOfTransformSteps";
/*      */       case 2622467:
/* 3405 */         return "SequenceOfCompressedData";
/*      */       case 2622468:
/* 3407 */         return "DetailsOfCoefficients";
/*      */       case 2623232:
/* 3409 */         return "DCTLabel";
/*      */       case 2623233:
/* 3411 */         return "DataBlockDescription";
/*      */       case 2623234:
/* 3413 */         return "DataBlock";
/*      */       case 2623248:
/* 3415 */         return "NormalizationFactorFormat";
/*      */       case 2623264:
/* 3417 */         return "ZonalMapNumberFormat";
/*      */       case 2623265:
/* 3419 */         return "ZonalMapLocation";
/*      */       case 2623266:
/* 3421 */         return "ZonalMapFormat";
/*      */       case 2623280:
/* 3423 */         return "AdaptiveMapFormat";
/*      */       case 2623296:
/* 3425 */         return "CodeNumberFormat";
/*      */       case 2623488:
/* 3427 */         return "CodeLabel";
/*      */       case 2623490:
/* 3429 */         return "NumberOfTables";
/*      */       case 2623491:
/* 3431 */         return "CodeTableLocation";
/*      */       case 2623492:
/* 3433 */         return "BitsForCodeWord";
/*      */       case 2623496:
/* 3435 */         return "ImageDataLocation";
/*      */       case 2624002:
/* 3437 */         return "PixelSpacingCalibrationType";
/*      */       case 2624004:
/* 3439 */         return "PixelSpacingCalibrationDescription";
/*      */       case 2625600:
/* 3441 */         return "PixelIntensityRelationship";
/*      */       case 2625601:
/* 3443 */         return "PixelIntensityRelationshipSign";
/*      */       case 2625616:
/* 3445 */         return "WindowCenter";
/*      */       case 2625617:
/* 3447 */         return "WindowWidth";
/*      */       case 2625618:
/* 3449 */         return "RescaleIntercept";
/*      */       case 2625619:
/* 3451 */         return "RescaleSlope";
/*      */       case 2625620:
/* 3453 */         return "RescaleType";
/*      */       case 2625621:
/* 3455 */         return "WindowCenterWidthExplanation";
/*      */       case 2625622:
/* 3457 */         return "VOILUTFunction";
/*      */       case 2625664:
/* 3459 */         return "GrayScale";
/*      */       case 2625680:
/* 3461 */         return "RecommendedViewingMode";
/*      */       case 2625792:
/* 3463 */         return "GrayLookupTableDescriptor";
/*      */       case 2625793:
/* 3465 */         return "RedPaletteColorLookupTableDescriptor";
/*      */       case 2625794:
/* 3467 */         return "GreenPaletteColorLookupTableDescriptor";
/*      */       case 2625795:
/* 3469 */         return "BluePaletteColorLookupTableDescriptor";
/*      */       case 2625796:
/* 3471 */         return "AlphaPaletteColorLookupTableDescriptor";
/*      */       case 2625809:
/* 3473 */         return "LargeRedPaletteColorLookupTableDescriptor";
/*      */       case 2625810:
/* 3475 */         return "LargeGreenPaletteColorLookupTableDescriptor";
/*      */       case 2625811:
/* 3477 */         return "LargeBluePaletteColorLookupTableDescriptor";
/*      */       case 2625945:
/* 3479 */         return "PaletteColorLookupTableUID";
/*      */       case 2626048:
/* 3481 */         return "GrayLookupTableData";
/*      */       case 2626049:
/* 3483 */         return "RedPaletteColorLookupTableData";
/*      */       case 2626050:
/* 3485 */         return "GreenPaletteColorLookupTableData";
/*      */       case 2626051:
/* 3487 */         return "BluePaletteColorLookupTableData";
/*      */       case 2626052:
/* 3489 */         return "AlphaPaletteColorLookupTableData";
/*      */       case 2626065:
/* 3491 */         return "LargeRedPaletteColorLookupTableData";
/*      */       case 2626066:
/* 3493 */         return "LargeGreenPaletteColorLookupTableData";
/*      */       case 2626067:
/* 3495 */         return "LargeBluePaletteColorLookupTableData";
/*      */       case 2626068:
/* 3497 */         return "LargePaletteColorLookupTableUID";
/*      */       case 2626081:
/* 3499 */         return "SegmentedRedPaletteColorLookupTableData";
/*      */       case 2626082:
/* 3501 */         return "SegmentedGreenPaletteColorLookupTableData";
/*      */       case 2626083:
/* 3503 */         return "SegmentedBluePaletteColorLookupTableData";
/*      */       case 2626304:
/* 3505 */         return "BreastImplantPresent";
/*      */       case 2626384:
/* 3507 */         return "PartialView";
/*      */       case 2626385:
/* 3509 */         return "PartialViewDescription";
/*      */       case 2626386:
/* 3511 */         return "PartialViewCodeSequence";
/*      */       case 2626394:
/* 3513 */         return "SpatialLocationsPreserved";
/*      */       case 2626561:
/* 3515 */         return "DataFrameAssignmentSequence";
/*      */       case 2626562:
/* 3517 */         return "DataPathAssignment";
/*      */       case 2626563:
/* 3519 */         return "BitsMappedToColorLookupTable";
/*      */       case 2626564:
/* 3521 */         return "BlendingLUT1Sequence";
/*      */       case 2626565:
/* 3523 */         return "BlendingLUT1TransferFunction";
/*      */       case 2626566:
/* 3525 */         return "BlendingWeightConstant";
/*      */       case 2626567:
/* 3527 */         return "BlendingLookupTableDescriptor";
/*      */       case 2626568:
/* 3529 */         return "BlendingLookupTableData";
/*      */       case 2626571:
/* 3531 */         return "EnhancedPaletteColorLookupTableSequence";
/*      */       case 2626572:
/* 3533 */         return "BlendingLUT2Sequence";
/*      */       case 2626573:
/* 3535 */         return "BlendingLUT2TransferFunction";
/*      */       case 2626574:
/* 3537 */         return "DataPathID";
/*      */       case 2626575:
/* 3539 */         return "RGBLUTTransferFunction";
/*      */       case 2626576:
/* 3541 */         return "AlphaLUTTransferFunction";
/*      */       case 2629632:
/* 3543 */         return "ICCProfile";
/*      */       case 2629904:
/* 3545 */         return "LossyImageCompression";
/*      */       case 2629906:
/* 3547 */         return "LossyImageCompressionRatio";
/*      */       case 2629908:
/* 3549 */         return "LossyImageCompressionMethod";
/*      */       case 2633728:
/* 3551 */         return "ModalityLUTSequence";
/*      */       case 2633730:
/* 3553 */         return "LUTDescriptor";
/*      */       case 2633731:
/* 3555 */         return "LUTExplanation";
/*      */       case 2633732:
/* 3557 */         return "ModalityLUTType";
/*      */       case 2633734:
/* 3559 */         return "LUTData";
/*      */       case 2633744:
/* 3561 */         return "VOILUTSequence";
/*      */       case 2634000:
/* 3563 */         return "SoftcopyVOILUTSequence";
/*      */       case 2637824:
/* 3565 */         return "ImagePresentationComments";
/*      */       case 2641920:
/* 3567 */         return "BiPlaneAcquisitionSequence";
/*      */       case 2646032:
/* 3569 */         return "RepresentativeFrameNumber";
/*      */       case 2646048:
/* 3571 */         return "FrameNumbersOfInterest";
/*      */       case 2646050:
/* 3573 */         return "FrameOfInterestDescription";
/*      */       case 2646051:
/* 3575 */         return "FrameOfInterestType";
/*      */       case 2646064:
/* 3577 */         return "MaskPointers";
/*      */       case 2646080:
/* 3579 */         return "RWavePointer";
/*      */       case 2646272:
/* 3581 */         return "MaskSubtractionSequence";
/*      */       case 2646273:
/* 3583 */         return "MaskOperation";
/*      */       case 2646274:
/* 3585 */         return "ApplicableFrameRange";
/*      */       case 2646288:
/* 3587 */         return "MaskFrameNumbers";
/*      */       case 2646290:
/* 3589 */         return "ContrastFrameAveraging";
/*      */       case 2646292:
/* 3591 */         return "MaskSubPixelShift";
/*      */       case 2646304:
/* 3593 */         return "TIDOffset";
/*      */       case 2646416:
/* 3595 */         return "MaskOperationExplanation";
/*      */       case 2650112:
/* 3597 */         return "EquipmentAdministratorSequence";
/*      */       case 2650113:
/* 3599 */         return "NumberOfDisplaySubsystems";
/*      */       case 2650114:
/* 3601 */         return "CurrentConfigurationID";
/*      */       case 2650115:
/* 3603 */         return "DisplaySubsystemID";
/*      */       case 2650116:
/* 3605 */         return "DisplaySubsystemName";
/*      */       case 2650117:
/* 3607 */         return "DisplaySubsystemDescription";
/*      */       case 2650118:
/* 3609 */         return "SystemStatus";
/*      */       case 2650119:
/* 3611 */         return "SystemStatusComment";
/*      */       case 2650120:
/* 3613 */         return "TargetLuminanceCharacteristicsSequence";
/*      */       case 2650121:
/* 3615 */         return "LuminanceCharacteristicsID";
/*      */       case 2650122:
/* 3617 */         return "DisplaySubsystemConfigurationSequence";
/*      */       case 2650123:
/* 3619 */         return "ConfigurationID";
/*      */       case 2650124:
/* 3621 */         return "ConfigurationName";
/*      */       case 2650125:
/* 3623 */         return "ConfigurationDescription";
/*      */       case 2650126:
/* 3625 */         return "ReferencedTargetLuminanceCharacteristicsID";
/*      */       case 2650127:
/* 3627 */         return "QAResultsSequence";
/*      */       case 2650128:
/* 3629 */         return "DisplaySubsystemQAResultsSequence";
/*      */       case 2650129:
/* 3631 */         return "ConfigurationQAResultsSequence";
/*      */       case 2650130:
/* 3633 */         return "MeasurementEquipmentSequence";
/*      */       case 2650131:
/* 3635 */         return "MeasurementFunctions";
/*      */       case 2650132:
/* 3637 */         return "MeasurementEquipmentType";
/*      */       case 2650133:
/* 3639 */         return "VisualEvaluationResultSequence";
/*      */       case 2650134:
/* 3641 */         return "DisplayCalibrationResultSequence";
/*      */       case 2650135:
/* 3643 */         return "DDLValue";
/*      */       case 2650136:
/* 3645 */         return "CIExyWhitePoint";
/*      */       case 2650137:
/* 3647 */         return "DisplayFunctionType";
/*      */       case 2650138:
/* 3649 */         return "GammaValue";
/*      */       case 2650139:
/* 3651 */         return "NumberOfLuminancePoints";
/*      */       case 2650140:
/* 3653 */         return "LuminanceResponseSequence";
/*      */       case 2650141:
/* 3655 */         return "TargetMinimumLuminance";
/*      */       case 2650142:
/* 3657 */         return "TargetMaximumLuminance";
/*      */       case 2650143:
/* 3659 */         return "LuminanceValue";
/*      */       case 2650144:
/* 3661 */         return "LuminanceResponseDescription";
/*      */       case 2650145:
/* 3663 */         return "WhitePointFlag";
/*      */       case 2650146:
/* 3665 */         return "DisplayDeviceTypeCodeSequence";
/*      */       case 2650147:
/* 3667 */         return "DisplaySubsystemSequence";
/*      */       case 2650148:
/* 3669 */         return "LuminanceResultSequence";
/*      */       case 2650149:
/* 3671 */         return "AmbientLightValueSource";
/*      */       case 2650150:
/* 3673 */         return "MeasuredCharacteristics";
/*      */       case 2650151:
/* 3675 */         return "LuminanceUniformityResultSequence";
/*      */       case 2650152:
/* 3677 */         return "VisualEvaluationTestSequence";
/*      */       case 2650153:
/* 3679 */         return "TestResult";
/*      */       case 2650154:
/* 3681 */         return "TestResultComment";
/*      */       case 2650155:
/* 3683 */         return "TestImageValidation";
/*      */       case 2650156:
/* 3685 */         return "TestPatternCodeSequence";
/*      */       case 2650157:
/* 3687 */         return "MeasurementPatternCodeSequence";
/*      */       case 2650158:
/* 3689 */         return "VisualEvaluationMethodCodeSequence";
/*      */       case 2654176:
/* 3691 */         return "PixelDataProviderURL";
/*      */       case 2658305:
/* 3693 */         return "DataPointRows";
/*      */       case 2658306:
/* 3695 */         return "DataPointColumns";
/*      */       case 2658307:
/* 3697 */         return "SignalDomainColumns";
/*      */       case 2658457:
/* 3699 */         return "LargestMonochromePixelValue";
/*      */       case 2658568:
/* 3701 */         return "DataRepresentation";
/*      */       case 2658576:
/* 3703 */         return "PixelMeasuresSequence";
/*      */       case 2658610:
/* 3705 */         return "FrameVOILUTSequence";
/*      */       case 2658629:
/* 3707 */         return "PixelValueTransformationSequence";
/*      */       case 2658869:
/* 3709 */         return "SignalDomainRows";
/*      */       case 2659345:
/* 3711 */         return "DisplayFilterPercentage";
/*      */       case 2659349:
/* 3713 */         return "FramePixelShiftSequence";
/*      */       case 2659350:
/* 3715 */         return "SubtractionItemID";
/*      */       case 2659362:
/* 3717 */         return "PixelIntensityRelationshipLUTSequence";
/*      */       case 2659395:
/* 3719 */         return "FramePixelDataPropertiesSequence";
/*      */       case 2659396:
/* 3721 */         return "GeometricalProperties";
/*      */       case 2659397:
/* 3723 */         return "GeometricMaximumDistortion";
/*      */       case 2659398:
/* 3725 */         return "ImageProcessingApplied";
/*      */       case 2659412:
/* 3727 */         return "MaskSelectionMode";
/*      */       case 2659444:
/* 3729 */         return "LUTFunction";
/*      */       case 2659448:
/* 3731 */         return "MaskVisibilityPercentage";
/*      */       case 2659585:
/* 3733 */         return "PixelShiftSequence";
/*      */       case 2659586:
/* 3735 */         return "RegionPixelShiftSequence";
/*      */       case 2659587:
/* 3737 */         return "VerticesOfTheRegion";
/*      */       case 2659589:
/* 3739 */         return "MultiFramePresentationSequence";
/*      */       case 2659590:
/* 3741 */         return "PixelShiftFrameRange";
/*      */       case 2659591:
/* 3743 */         return "LUTFrameRange";
/*      */       case 2659616:
/* 3745 */         return "ImageToEquipmentMappingMatrix";
/*      */       case 2659639:
/* 3747 */         return "EquipmentCoordinateSystemIdentification";
/*      */       case 3276810:
/* 3749 */         return "StudyStatusID";
/*      */       case 3276812:
/* 3751 */         return "StudyPriorityID";
/*      */       case 3276818:
/* 3753 */         return "StudyIDIssuer";
/*      */       case 3276850:
/* 3755 */         return "StudyVerifiedDate";
/*      */       case 3276851:
/* 3757 */         return "StudyVerifiedTime";
/*      */       case 3276852:
/* 3759 */         return "StudyReadDate";
/*      */       case 3276853:
/* 3761 */         return "StudyReadTime";
/*      */       case 3280896:
/* 3763 */         return "ScheduledStudyStartDate";
/*      */       case 3280897:
/* 3765 */         return "ScheduledStudyStartTime";
/*      */       case 3280912:
/* 3767 */         return "ScheduledStudyStopDate";
/*      */       case 3280913:
/* 3769 */         return "ScheduledStudyStopTime";
/*      */       case 3280928:
/* 3771 */         return "ScheduledStudyLocation";
/*      */       case 3280929:
/* 3773 */         return "ScheduledStudyLocationAETitle";
/*      */       case 3280944:
/* 3775 */         return "ReasonForStudy";
/*      */       case 3280945:
/* 3777 */         return "RequestingPhysicianIdentificationSequence";
/*      */       case 3280946:
/* 3779 */         return "RequestingPhysician";
/*      */       case 3280947:
/* 3781 */         return "RequestingService";
/*      */       case 3280948:
/* 3783 */         return "RequestingServiceCodeSequence";
/*      */       case 3280960:
/* 3785 */         return "StudyArrivalDate";
/*      */       case 3280961:
/* 3787 */         return "StudyArrivalTime";
/*      */       case 3280976:
/* 3789 */         return "StudyCompletionDate";
/*      */       case 3280977:
/* 3791 */         return "StudyCompletionTime";
/*      */       case 3280981:
/* 3793 */         return "StudyComponentStatusID";
/*      */       case 3280992:
/* 3795 */         return "RequestedProcedureDescription";
/*      */       case 3280996:
/* 3797 */         return "RequestedProcedureCodeSequence";
/*      */       case 3281008:
/* 3799 */         return "RequestedContrastAgent";
/*      */       case 3293184:
/* 3801 */         return "StudyComments";
/*      */       case 3670020:
/* 3803 */         return "ReferencedPatientAliasSequence";
/*      */       case 3670024:
/* 3805 */         return "VisitStatusID";
/*      */       case 3670032:
/* 3807 */         return "AdmissionID";
/*      */       case 3670033:
/* 3809 */         return "IssuerOfAdmissionID";
/*      */       case 3670036:
/* 3811 */         return "IssuerOfAdmissionIDSequence";
/*      */       case 3670038:
/* 3813 */         return "RouteOfAdmissions";
/*      */       case 3670042:
/* 3815 */         return "ScheduledAdmissionDate";
/*      */       case 3670043:
/* 3817 */         return "ScheduledAdmissionTime";
/*      */       case 3670044:
/* 3819 */         return "ScheduledDischargeDate";
/*      */       case 3670045:
/* 3821 */         return "ScheduledDischargeTime";
/*      */       case 3670046:
/* 3823 */         return "ScheduledPatientInstitutionResidence";
/*      */       case 3670048:
/* 3825 */         return "AdmittingDate";
/*      */       case 3670049:
/* 3827 */         return "AdmittingTime";
/*      */       case 3670064:
/* 3829 */         return "DischargeDate";
/*      */       case 3670066:
/* 3831 */         return "DischargeTime";
/*      */       case 3670080:
/* 3833 */         return "DischargeDiagnosisDescription";
/*      */       case 3670084:
/* 3835 */         return "DischargeDiagnosisCodeSequence";
/*      */       case 3670096:
/* 3837 */         return "SpecialNeeds";
/*      */       case 3670112:
/* 3839 */         return "ServiceEpisodeID";
/*      */       case 3670113:
/* 3841 */         return "IssuerOfServiceEpisodeID";
/*      */       case 3670114:
/* 3843 */         return "ServiceEpisodeDescription";
/*      */       case 3670116:
/* 3845 */         return "IssuerOfServiceEpisodeIDSequence";
/*      */       case 3670272:
/* 3847 */         return "PertinentDocumentsSequence";
/*      */       case 3670273:
/* 3849 */         return "PertinentResourcesSequence";
/*      */       case 3670274:
/* 3851 */         return "ResourceDescription";
/*      */       case 3670784:
/* 3853 */         return "CurrentPatientLocation";
/*      */       case 3671040:
/* 3855 */         return "PatientInstitutionResidence";
/*      */       case 3671296:
/* 3857 */         return "PatientState";
/*      */       case 3671298:
/* 3859 */         return "PatientClinicalTrialParticipationSequence";
/*      */       case 3686400:
/* 3861 */         return "VisitComments";
/*      */       case 3801092:
/* 3863 */         return "WaveformOriginality";
/*      */       case 3801093:
/* 3865 */         return "NumberOfWaveformChannels";
/*      */       case 3801104:
/* 3867 */         return "NumberOfWaveformSamples";
/*      */       case 3801114:
/* 3869 */         return "SamplingFrequency";
/*      */       case 3801120:
/* 3871 */         return "MultiplexGroupLabel";
/*      */       case 3801600:
/* 3873 */         return "ChannelDefinitionSequence";
/*      */       case 3801602:
/* 3875 */         return "WaveformChannelNumber";
/*      */       case 3801603:
/* 3877 */         return "ChannelLabel";
/*      */       case 3801605:
/* 3879 */         return "ChannelStatus";
/*      */       case 3801608:
/* 3881 */         return "ChannelSourceSequence";
/*      */       case 3801609:
/* 3883 */         return "ChannelSourceModifiersSequence";
/*      */       case 3801610:
/* 3885 */         return "SourceWaveformSequence";
/*      */       case 3801612:
/* 3887 */         return "ChannelDerivationDescription";
/*      */       case 3801616:
/* 3889 */         return "ChannelSensitivity";
/*      */       case 3801617:
/* 3891 */         return "ChannelSensitivityUnitsSequence";
/*      */       case 3801618:
/* 3893 */         return "ChannelSensitivityCorrectionFactor";
/*      */       case 3801619:
/* 3895 */         return "ChannelBaseline";
/*      */       case 3801620:
/* 3897 */         return "ChannelTimeSkew";
/*      */       case 3801621:
/* 3899 */         return "ChannelSampleSkew";
/*      */       case 3801624:
/* 3901 */         return "ChannelOffset";
/*      */       case 3801626:
/* 3903 */         return "WaveformBitsStored";
/*      */       case 3801632:
/* 3905 */         return "FilterLowFrequency";
/*      */       case 3801633:
/* 3907 */         return "FilterHighFrequency";
/*      */       case 3801634:
/* 3909 */         return "NotchFilterFrequency";
/*      */       case 3801635:
/* 3911 */         return "NotchFilterBandwidth";
/*      */       case 3801648:
/* 3913 */         return "WaveformDataDisplayScale";
/*      */       case 3801649:
/* 3915 */         return "WaveformDisplayBackgroundCIELabValue";
/*      */       case 3801664:
/* 3917 */         return "WaveformPresentationGroupSequence";
/*      */       case 3801665:
/* 3919 */         return "PresentationGroupNumber";
/*      */       case 3801666:
/* 3921 */         return "ChannelDisplaySequence";
/*      */       case 3801668:
/* 3923 */         return "ChannelRecommendedDisplayCIELabValue";
/*      */       case 3801669:
/* 3925 */         return "ChannelPosition";
/*      */       case 3801670:
/* 3927 */         return "DisplayShadingFlag";
/*      */       case 3801671:
/* 3929 */         return "FractionalChannelDisplayScale";
/*      */       case 3801672:
/* 3931 */         return "AbsoluteChannelDisplayScale";
/*      */       case 3801856:
/* 3933 */         return "MultiplexedAudioChannelsDescriptionCodeSequence";
/*      */       case 3801857:
/* 3935 */         return "ChannelIdentificationCode";
/*      */       case 3801858:
/* 3937 */         return "ChannelMode";
/*      */       case 4194305:
/* 3939 */         return "ScheduledStationAETitle";
/*      */       case 4194306:
/* 3941 */         return "ScheduledProcedureStepStartDate";
/*      */       case 4194307:
/* 3943 */         return "ScheduledProcedureStepStartTime";
/*      */       case 4194308:
/* 3945 */         return "ScheduledProcedureStepEndDate";
/*      */       case 4194309:
/* 3947 */         return "ScheduledProcedureStepEndTime";
/*      */       case 4194310:
/* 3949 */         return "ScheduledPerformingPhysicianName";
/*      */       case 4194311:
/* 3951 */         return "ScheduledProcedureStepDescription";
/*      */       case 4194312:
/* 3953 */         return "ScheduledProtocolCodeSequence";
/*      */       case 4194313:
/* 3955 */         return "ScheduledProcedureStepID";
/*      */       case 4194314:
/* 3957 */         return "StageCodeSequence";
/*      */       case 4194315:
/* 3959 */         return "ScheduledPerformingPhysicianIdentificationSequence";
/*      */       case 4194320:
/* 3961 */         return "ScheduledStationName";
/*      */       case 4194321:
/* 3963 */         return "ScheduledProcedureStepLocation";
/*      */       case 4194322:
/* 3965 */         return "PreMedication";
/*      */       case 4194336:
/* 3967 */         return "ScheduledProcedureStepStatus";
/*      */       case 4194342:
/* 3969 */         return "OrderPlacerIdentifierSequence";
/*      */       case 4194343:
/* 3971 */         return "OrderFillerIdentifierSequence";
/*      */       case 4194353:
/* 3973 */         return "LocalNamespaceEntityID";
/*      */       case 4194354:
/* 3975 */         return "UniversalEntityID";
/*      */       case 4194355:
/* 3977 */         return "UniversalEntityIDType";
/*      */       case 4194357:
/* 3979 */         return "IdentifierTypeCode";
/*      */       case 4194358:
/* 3981 */         return "AssigningFacilitySequence";
/*      */       case 4194361:
/* 3983 */         return "AssigningJurisdictionCodeSequence";
/*      */       case 4194362:
/* 3985 */         return "AssigningAgencyOrDepartmentCodeSequence";
/*      */       case 4194560:
/* 3987 */         return "ScheduledProcedureStepSequence";
/*      */       case 4194848:
/* 3989 */         return "ReferencedNonImageCompositeSOPInstanceSequence";
/*      */       case 4194881:
/* 3991 */         return "PerformedStationAETitle";
/*      */       case 4194882:
/* 3993 */         return "PerformedStationName";
/*      */       case 4194883:
/* 3995 */         return "PerformedLocation";
/*      */       case 4194884:
/* 3997 */         return "PerformedProcedureStepStartDate";
/*      */       case 4194885:
/* 3999 */         return "PerformedProcedureStepStartTime";
/*      */       case 4194896:
/* 4001 */         return "PerformedProcedureStepEndDate";
/*      */       case 4194897:
/* 4003 */         return "PerformedProcedureStepEndTime";
/*      */       case 4194898:
/* 4005 */         return "PerformedProcedureStepStatus";
/*      */       case 4194899:
/* 4007 */         return "PerformedProcedureStepID";
/*      */       case 4194900:
/* 4009 */         return "PerformedProcedureStepDescription";
/*      */       case 4194901:
/* 4011 */         return "PerformedProcedureTypeDescription";
/*      */       case 4194912:
/* 4013 */         return "PerformedProtocolCodeSequence";
/*      */       case 4194913:
/* 4015 */         return "PerformedProtocolType";
/*      */       case 4194928:
/* 4017 */         return "ScheduledStepAttributesSequence";
/*      */       case 4194933:
/* 4019 */         return "RequestAttributesSequence";
/*      */       case 4194944:
/* 4021 */         return "CommentsOnThePerformedProcedureStep";
/*      */       case 4194945:
/* 4023 */         return "PerformedProcedureStepDiscontinuationReasonCodeSequence";
/*      */       case 4194963:
/* 4025 */         return "QuantitySequence";
/*      */       case 4194964:
/* 4027 */         return "Quantity";
/*      */       case 4194965:
/* 4029 */         return "MeasuringUnitsSequence";
/*      */       case 4194966:
/* 4031 */         return "BillingItemSequence";
/*      */       case 4195072:
/* 4033 */         return "TotalTimeOfFluoroscopy";
/*      */       case 4195073:
/* 4035 */         return "TotalNumberOfExposures";
/*      */       case 4195074:
/* 4037 */         return "EntranceDose";
/*      */       case 4195075:
/* 4039 */         return "ExposedArea";
/*      */       case 4195078:
/* 4041 */         return "DistanceSourceToEntrance";
/*      */       case 4195079:
/* 4043 */         return "DistanceSourceToSupport";
/*      */       case 4195086:
/* 4045 */         return "ExposureDoseSequence";
/*      */       case 4195088:
/* 4047 */         return "CommentsOnRadiationDose";
/*      */       case 4195090:
/* 4049 */         return "XRayOutput";
/*      */       case 4195092:
/* 4051 */         return "HalfValueLayer";
/*      */       case 4195094:
/* 4053 */         return "OrganDose";
/*      */       case 4195096:
/* 4055 */         return "OrganExposed";
/*      */       case 4195104:
/* 4057 */         return "BillingProcedureStepSequence";
/*      */       case 4195105:
/* 4059 */         return "FilmConsumptionSequence";
/*      */       case 4195108:
/* 4061 */         return "BillingSuppliesAndDevicesSequence";
/*      */       case 4195120:
/* 4063 */         return "ReferencedProcedureStepSequence";
/*      */       case 4195136:
/* 4065 */         return "PerformedSeriesSequence";
/*      */       case 4195328:
/* 4067 */         return "CommentsOnTheScheduledProcedureStep";
/*      */       case 4195392:
/* 4069 */         return "ProtocolContextSequence";
/*      */       case 4195393:
/* 4071 */         return "ContentItemModifierSequence";
/*      */       case 4195584:
/* 4073 */         return "ScheduledSpecimenSequence";
/*      */       case 4195594:
/* 4075 */         return "SpecimenAccessionNumber";
/*      */       case 4195602:
/* 4077 */         return "ContainerIdentifier";
/*      */       case 4195603:
/* 4079 */         return "IssuerOfTheContainerIdentifierSequence";
/*      */       case 4195605:
/* 4081 */         return "AlternateContainerIdentifierSequence";
/*      */       case 4195608:
/* 4083 */         return "ContainerTypeCodeSequence";
/*      */       case 4195610:
/* 4085 */         return "ContainerDescription";
/*      */       case 4195616:
/* 4087 */         return "ContainerComponentSequence";
/*      */       case 4195664:
/* 4089 */         return "SpecimenSequence";
/*      */       case 4195665:
/* 4091 */         return "SpecimenIdentifier";
/*      */       case 4195666:
/* 4093 */         return "SpecimenDescriptionSequenceTrial";
/*      */       case 4195667:
/* 4095 */         return "SpecimenDescriptionTrial";
/*      */       case 4195668:
/* 4097 */         return "SpecimenUID";
/*      */       case 4195669:
/* 4099 */         return "AcquisitionContextSequence";
/*      */       case 4195670:
/* 4101 */         return "AcquisitionContextDescription";
/*      */       case 4195738:
/* 4103 */         return "SpecimenTypeCodeSequence";
/*      */       case 4195680:
/* 4105 */         return "SpecimenDescriptionSequence";
/*      */       case 4195682:
/* 4107 */         return "IssuerOfTheSpecimenIdentifierSequence";
/*      */       case 4195840:
/* 4109 */         return "SpecimenShortDescription";
/*      */       case 4195842:
/* 4111 */         return "SpecimenDetailedDescription";
/*      */       case 4195856:
/* 4113 */         return "SpecimenPreparationSequence";
/*      */       case 4195858:
/* 4115 */         return "SpecimenPreparationStepContentItemSequence";
/*      */       case 4195872:
/* 4117 */         return "SpecimenLocalizationContentItemSequence";
/*      */       case 4196090:
/* 4119 */         return "SlideIdentifier";
/*      */       case 4196122:
/* 4121 */         return "ImageCenterPointCoordinatesSequence";
/*      */       case 4196138:
/* 4123 */         return "XOffsetInSlideCoordinateSystem";
/*      */       case 4196154:
/* 4125 */         return "YOffsetInSlideCoordinateSystem";
/*      */       case 4196170:
/* 4127 */         return "ZOffsetInSlideCoordinateSystem";
/*      */       case 4196568:
/* 4129 */         return "PixelSpacingSequence";
/*      */       case 4196570:
/* 4131 */         return "CoordinateSystemAxisCodeSequence";
/*      */       case 4196586:
/* 4133 */         return "MeasurementUnitsCodeSequence";
/*      */       case 4196856:
/* 4135 */         return "VitalStainCodeSequenceTrial";
/*      */       case 4198401:
/* 4137 */         return "RequestedProcedureID";
/*      */       case 4198402:
/* 4139 */         return "ReasonForTheRequestedProcedure";
/*      */       case 4198403:
/* 4141 */         return "RequestedProcedurePriority";
/*      */       case 4198404:
/* 4143 */         return "PatientTransportArrangements";
/*      */       case 4198405:
/* 4145 */         return "RequestedProcedureLocation";
/*      */       case 4198406:
/* 4147 */         return "PlacerOrderNumberProcedure";
/*      */       case 4198407:
/* 4149 */         return "FillerOrderNumberProcedure";
/*      */       case 4198408:
/* 4151 */         return "ConfidentialityCode";
/*      */       case 4198409:
/* 4153 */         return "ReportingPriority";
/*      */       case 4198410:
/* 4155 */         return "ReasonForRequestedProcedureCodeSequence";
/*      */       case 4198416:
/* 4157 */         return "NamesOfIntendedRecipientsOfResults";
/*      */       case 4198417:
/* 4159 */         return "IntendedRecipientsOfResultsIdentificationSequence";
/*      */       case 4198418:
/* 4161 */         return "ReasonForPerformedProcedureCodeSequence";
/*      */       case 4198496:
/* 4163 */         return "RequestedProcedureDescriptionTrial";
/*      */       case 4198657:
/* 4165 */         return "PersonIdentificationCodeSequence";
/*      */       case 4198658:
/* 4167 */         return "PersonAddress";
/*      */       case 4198659:
/* 4169 */         return "PersonTelephoneNumbers";
/*      */       case 4199424:
/* 4171 */         return "RequestedProcedureComments";
/*      */       case 4202497:
/* 4173 */         return "ReasonForTheImagingServiceRequest";
/*      */       case 4202500:
/* 4175 */         return "IssueDateOfImagingServiceRequest";
/*      */       case 4202501:
/* 4177 */         return "IssueTimeOfImagingServiceRequest";
/*      */       case 4202502:
/* 4179 */         return "PlacerOrderNumberImagingServiceRequestRetired";
/*      */       case 4202503:
/* 4181 */         return "FillerOrderNumberImagingServiceRequestRetired";
/*      */       case 4202504:
/* 4183 */         return "OrderEnteredBy";
/*      */       case 4202505:
/* 4185 */         return "OrderEntererLocation";
/*      */       case 4202512:
/* 4187 */         return "OrderCallbackPhoneNumber";
/*      */       case 4202518:
/* 4189 */         return "PlacerOrderNumberImagingServiceRequest";
/*      */       case 4202519:
/* 4191 */         return "FillerOrderNumberImagingServiceRequest";
/*      */       case 4203520:
/* 4193 */         return "ImagingServiceRequestComments";
/*      */       case 4206593:
/* 4195 */         return "ConfidentialityConstraintOnPatientDataDescription";
/*      */       case 4210689:
/* 4197 */         return "GeneralPurposeScheduledProcedureStepStatus";
/*      */       case 4210690:
/* 4199 */         return "GeneralPurposePerformedProcedureStepStatus";
/*      */       case 4210691:
/* 4201 */         return "GeneralPurposeScheduledProcedureStepPriority";
/*      */       case 4210692:
/* 4203 */         return "ScheduledProcessingApplicationsCodeSequence";
/*      */       case 4210693:
/* 4205 */         return "ScheduledProcedureStepStartDateTime";
/*      */       case 4210694:
/* 4207 */         return "MultipleCopiesFlag";
/*      */       case 4210695:
/* 4209 */         return "PerformedProcessingApplicationsCodeSequence";
/*      */       case 4210697:
/* 4211 */         return "HumanPerformerCodeSequence";
/*      */       case 4210704:
/* 4213 */         return "ScheduledProcedureStepModificationDateTime";
/*      */       case 4210705:
/* 4215 */         return "ExpectedCompletionDateTime";
/*      */       case 4210709:
/* 4217 */         return "ResultingGeneralPurposePerformedProcedureStepsSequence";
/*      */       case 4210710:
/* 4219 */         return "ReferencedGeneralPurposeScheduledProcedureStepSequence";
/*      */       case 4210712:
/* 4221 */         return "ScheduledWorkitemCodeSequence";
/*      */       case 4210713:
/* 4223 */         return "PerformedWorkitemCodeSequence";
/*      */       case 4210720:
/* 4225 */         return "InputAvailabilityFlag";
/*      */       case 4210721:
/* 4227 */         return "InputInformationSequence";
/*      */       case 4210722:
/* 4229 */         return "RelevantInformationSequence";
/*      */       case 4210723:
/* 4231 */         return "ReferencedGeneralPurposeScheduledProcedureStepTransactionUID";
/*      */       case 4210725:
/* 4233 */         return "ScheduledStationNameCodeSequence";
/*      */       case 4210726:
/* 4235 */         return "ScheduledStationClassCodeSequence";
/*      */       case 4210727:
/* 4237 */         return "ScheduledStationGeographicLocationCodeSequence";
/*      */       case 4210728:
/* 4239 */         return "PerformedStationNameCodeSequence";
/*      */       case 4210729:
/* 4241 */         return "PerformedStationClassCodeSequence";
/*      */       case 4210736:
/* 4243 */         return "PerformedStationGeographicLocationCodeSequence";
/*      */       case 4210737:
/* 4245 */         return "RequestedSubsequentWorkitemCodeSequence";
/*      */       case 4210738:
/* 4247 */         return "NonDICOMOutputCodeSequence";
/*      */       case 4210739:
/* 4249 */         return "OutputInformationSequence";
/*      */       case 4210740:
/* 4251 */         return "ScheduledHumanPerformersSequence";
/*      */       case 4210741:
/* 4253 */         return "ActualHumanPerformersSequence";
/*      */       case 4210742:
/* 4255 */         return "HumanPerformerOrganization";
/*      */       case 4210743:
/* 4257 */         return "HumanPerformerName";
/*      */       case 4210752:
/* 4259 */         return "RawDataHandling";
/*      */       case 4210753:
/* 4261 */         return "InputReadinessState";
/*      */       case 4210768:
/* 4263 */         return "PerformedProcedureStepStartDateTime";
/*      */       case 4210769:
/* 4265 */         return "PerformedProcedureStepEndDateTime";
/*      */       case 4210770:
/* 4267 */         return "ProcedureStepCancellationDateTime";
/*      */       case 4227842:
/* 4269 */         return "EntranceDoseInmGy";
/*      */       case 4231314:
/* 4271 */         return "ParametricMapFrameTypeSequence";
/*      */       case 4231316:
/* 4273 */         return "ReferencedImageRealWorldValueMappingSequence";
/*      */       case 4231318:
/* 4275 */         return "RealWorldValueMappingSequence";
/*      */       case 4231320:
/* 4277 */         return "PixelValueMappingCodeSequence";
/*      */       case 4231696:
/* 4279 */         return "LUTLabel";
/*      */       case 4231697:
/* 4281 */         return "RealWorldValueLastValueMapped";
/*      */       case 4231698:
/* 4283 */         return "RealWorldValueLUTData";
/*      */       case 4231702:
/* 4285 */         return "RealWorldValueFirstValueMapped";
/*      */       case 4231712:
/* 4287 */         return "QuantityDefinitionSequence";
/*      */       case 4231716:
/* 4289 */         return "RealWorldValueIntercept";
/*      */       case 4231717:
/* 4291 */         return "RealWorldValueSlope";
/*      */       case 4235271:
/* 4293 */         return "FindingsFlagTrial";
/*      */       case 4235280:
/* 4295 */         return "RelationshipType";
/*      */       case 4235296:
/* 4297 */         return "FindingsSequenceTrial";
/*      */       case 4235297:
/* 4299 */         return "FindingsGroupUIDTrial";
/*      */       case 4235298:
/* 4301 */         return "ReferencedFindingsGroupUIDTrial";
/*      */       case 4235299:
/* 4303 */         return "FindingsGroupRecordingDateTrial";
/*      */       case 4235300:
/* 4305 */         return "FindingsGroupRecordingTimeTrial";
/*      */       case 4235302:
/* 4307 */         return "FindingsSourceCategoryCodeSequenceTrial";
/*      */       case 4235303:
/* 4309 */         return "VerifyingOrganization";
/*      */       case 4235304:
/* 4311 */         return "DocumentingOrganizationIdentifierCodeSequenceTrial";
/*      */       case 4235312:
/* 4313 */         return "VerificationDateTime";
/*      */       case 4235314:
/* 4315 */         return "ObservationDateTime";
/*      */       case 4235328:
/* 4317 */         return "ValueType";
/*      */       case 4235331:
/* 4319 */         return "ConceptNameCodeSequence";
/*      */       case 4235335:
/* 4321 */         return "MeasurementPrecisionDescriptionTrial";
/*      */       case 4235344:
/* 4323 */         return "ContinuityOfContent";
/*      */       case 4235351:
/* 4325 */         return "UrgencyOrPriorityAlertsTrial";
/*      */       case 4235360:
/* 4327 */         return "SequencingIndicatorTrial";
/*      */       case 4235366:
/* 4329 */         return "DocumentIdentifierCodeSequenceTrial";
/*      */       case 4235367:
/* 4331 */         return "DocumentAuthorTrial";
/*      */       case 4235368:
/* 4333 */         return "DocumentAuthorIdentifierCodeSequenceTrial";
/*      */       case 4235376:
/* 4335 */         return "IdentifierCodeSequenceTrial";
/*      */       case 4235379:
/* 4337 */         return "VerifyingObserverSequence";
/*      */       case 4235380:
/* 4339 */         return "ObjectBinaryIdentifierTrial";
/*      */       case 4235381:
/* 4341 */         return "VerifyingObserverName";
/*      */       case 4235382:
/* 4343 */         return "DocumentingObserverIdentifierCodeSequenceTrial";
/*      */       case 4235384:
/* 4345 */         return "AuthorObserverSequence";
/*      */       case 4235386:
/* 4347 */         return "ParticipantSequence";
/*      */       case 4235388:
/* 4349 */         return "CustodialOrganizationSequence";
/*      */       case 4235392:
/* 4351 */         return "ParticipationType";
/*      */       case 4235394:
/* 4353 */         return "ParticipationDateTime";
/*      */       case 4235396:
/* 4355 */         return "ObserverType";
/*      */       case 4235397:
/* 4357 */         return "ProcedureIdentifierCodeSequenceTrial";
/*      */       case 4235400:
/* 4359 */         return "VerifyingObserverIdentificationCodeSequence";
/*      */       case 4235401:
/* 4361 */         return "ObjectDirectoryBinaryIdentifierTrial";
/*      */       case 4235408:
/* 4363 */         return "EquivalentCDADocumentSequence";
/*      */       case 4235440:
/* 4365 */         return "ReferencedWaveformChannels";
/*      */       case 4235536:
/* 4367 */         return "DateOfDocumentOrVerbalTransactionTrial";
/*      */       case 4235538:
/* 4369 */         return "TimeOfDocumentCreationOrVerbalTransactionTrial";
/*      */       case 4235552:
/* 4371 */         return "DateTime";
/*      */       case 4235553:
/* 4373 */         return "Date";
/*      */       case 4235554:
/* 4375 */         return "Time";
/*      */       case 4235555:
/* 4377 */         return "PersonName";
/*      */       case 4235556:
/* 4379 */         return "UID";
/*      */       case 4235557:
/* 4381 */         return "ReportStatusIDTrial";
/*      */       case 4235568:
/* 4383 */         return "TemporalRangeType";
/*      */       case 4235570:
/* 4385 */         return "ReferencedSamplePositions";
/*      */       case 4235574:
/* 4387 */         return "ReferencedFrameNumbers";
/*      */       case 4235576:
/* 4389 */         return "ReferencedTimeOffsets";
/*      */       case 4235578:
/* 4391 */         return "ReferencedDateTime";
/*      */       case 4235616:
/* 4393 */         return "TextValue";
/*      */       case 4235617:
/* 4395 */         return "FloatingPointValue";
/*      */       case 4235618:
/* 4397 */         return "RationalNumeratorValue";
/*      */       case 4235619:
/* 4399 */         return "RationalDenominatorValue";
/*      */       case 4235623:
/* 4401 */         return "ObservationCategoryCodeSequenceTrial";
/*      */       case 4235624:
/* 4403 */         return "ConceptCodeSequence";
/*      */       case 4235626:
/* 4405 */         return "BibliographicCitationTrial";
/*      */       case 4235632:
/* 4407 */         return "PurposeOfReferenceCodeSequence";
/*      */       case 4235633:
/* 4409 */         return "ObservationUID";
/*      */       case 4235634:
/* 4411 */         return "ReferencedObservationUIDTrial";
/*      */       case 4235635:
/* 4413 */         return "ReferencedObservationClassTrial";
/*      */       case 4235636:
/* 4415 */         return "ReferencedObjectObservationClassTrial";
/*      */       case 4235648:
/* 4417 */         return "AnnotationGroupNumber";
/*      */       case 4235666:
/* 4419 */         return "ObservationDateTrial";
/*      */       case 4235667:
/* 4421 */         return "ObservationTimeTrial";
/*      */       case 4235668:
/* 4423 */         return "MeasurementAutomationTrial";
/*      */       case 4235669:
/* 4425 */         return "ModifierCodeSequence";
/*      */       case 4235812:
/* 4427 */         return "IdentificationDescriptionTrial";
/*      */       case 4235920:
/* 4429 */         return "CoordinatesSetGeometricTypeTrial";
/*      */       case 4235926:
/* 4431 */         return "AlgorithmCodeSequenceTrial";
/*      */       case 4235927:
/* 4433 */         return "AlgorithmDescriptionTrial";
/*      */       case 4235930:
/* 4435 */         return "PixelCoordinatesSetTrial";
/*      */       case 4236032:
/* 4437 */         return "MeasuredValueSequence";
/*      */       case 4236033:
/* 4439 */         return "NumericValueQualifierCodeSequence";
/*      */       case 4236039:
/* 4441 */         return "CurrentObserverTrial";
/*      */       case 4236042:
/* 4443 */         return "NumericValue";
/*      */       case 4236051:
/* 4445 */         return "ReferencedAccessionSequenceTrial";
/*      */       case 4236090:
/* 4447 */         return "ReportStatusCommentTrial";
/*      */       case 4236096:
/* 4449 */         return "ProcedureContextSequenceTrial";
/*      */       case 4236114:
/* 4451 */         return "VerbalSourceTrial";
/*      */       case 4236115:
/* 4453 */         return "AddressTrial";
/*      */       case 4236116:
/* 4455 */         return "TelephoneNumberTrial";
/*      */       case 4236120:
/* 4457 */         return "VerbalSourceIdentifierCodeSequenceTrial";
/*      */       case 4236128:
/* 4459 */         return "PredecessorDocumentsSequence";
/*      */       case 4236144:
/* 4461 */         return "ReferencedRequestSequence";
/*      */       case 4236146:
/* 4463 */         return "PerformedProcedureCodeSequence";
/*      */       case 4236149:
/* 4465 */         return "CurrentRequestedProcedureEvidenceSequence";
/*      */       case 4236160:
/* 4467 */         return "ReportDetailSequenceTrial";
/*      */       case 4236165:
/* 4469 */         return "PertinentOtherEvidenceSequence";
/*      */       case 4236176:
/* 4471 */         return "HL7StructuredDocumentReferenceSequence";
/*      */       case 4236290:
/* 4473 */         return "ObservationSubjectUIDTrial";
/*      */       case 4236291:
/* 4475 */         return "ObservationSubjectClassTrial";
/*      */       case 4236292:
/* 4477 */         return "ObservationSubjectTypeCodeSequenceTrial";
/*      */       case 4236433:
/* 4479 */         return "CompletionFlag";
/*      */       case 4236434:
/* 4481 */         return "CompletionFlagDescription";
/*      */       case 4236435:
/* 4483 */         return "VerificationFlag";
/*      */       case 4236436:
/* 4485 */         return "ArchiveRequested";
/*      */       case 4236438:
/* 4487 */         return "PreliminaryFlag";
/*      */       case 4236548:
/* 4489 */         return "ContentTemplateSequence";
/*      */       case 4236581:
/* 4491 */         return "IdenticalDocumentsSequence";
/*      */       case 4236800:
/* 4493 */         return "ObservationSubjectContextFlagTrial";
/*      */       case 4236801:
/* 4495 */         return "ObserverContextFlagTrial";
/*      */       case 4236803:
/* 4497 */         return "ProcedureContextFlagTrial";
/*      */       case 4237104:
/* 4499 */         return "ContentSequence";
/*      */       case 4237105:
/* 4501 */         return "RelationshipSequenceTrial";
/*      */       case 4237106:
/* 4503 */         return "RelationshipTypeCodeSequenceTrial";
/*      */       case 4237124:
/* 4505 */         return "LanguageCodeSequenceTrial";
/*      */       case 4237714:
/* 4507 */         return "UniformResourceLocatorTrial";
/*      */       case 4239392:
/* 4509 */         return "WaveformAnnotationSequence";
/*      */       case 4250368:
/* 4511 */         return "TemplateIdentifier";
/*      */       case 4250374:
/* 4513 */         return "TemplateVersion";
/*      */       case 4250375:
/* 4515 */         return "TemplateLocalVersion";
/*      */       case 4250379:
/* 4517 */         return "TemplateExtensionFlag";
/*      */       case 4250380:
/* 4519 */         return "TemplateExtensionOrganizationUID";
/*      */       case 4250381:
/* 4521 */         return "TemplateExtensionCreatorUID";
/*      */       case 4250483:
/* 4523 */         return "ReferencedContentItemIdentifier";
/*      */       case 4251649:
/* 4525 */         return "HL7InstanceIdentifier";
/*      */       case 4251652:
/* 4527 */         return "HL7DocumentEffectiveTime";
/*      */       case 4251654:
/* 4529 */         return "HL7DocumentTypeCodeSequence";
/*      */       case 4251656:
/* 4531 */         return "DocumentClassCodeSequence";
/*      */       case 4251664:
/* 4533 */         return "RetrieveURI";
/*      */       case 4251665:
/* 4535 */         return "RetrieveLocationUID";
/*      */       case 4251680:
/* 4537 */         return "TypeOfInstances";
/*      */       case 4251681:
/* 4539 */         return "DICOMRetrievalSequence";
/*      */       case 4251682:
/* 4541 */         return "DICOMMediaRetrievalSequence";
/*      */       case 4251683:
/* 4543 */         return "WADORetrievalSequence";
/*      */       case 4251684:
/* 4545 */         return "XDSRetrievalSequence";
/*      */       case 4251685:
/* 4547 */         return "WADORSRetrievalSequence";
/*      */       case 4251696:
/* 4549 */         return "RepositoryUniqueID";
/*      */       case 4251697:
/* 4551 */         return "HomeCommunityID";
/*      */       case 4325392:
/* 4553 */         return "DocumentTitle";
/*      */       case 4325393:
/* 4555 */         return "EncapsulatedDocument";
/*      */       case 4325394:
/* 4557 */         return "MIMETypeOfEncapsulatedDocument";
/*      */       case 4325395:
/* 4559 */         return "SourceInstanceSequence";
/*      */       case 4325396:
/* 4561 */         return "ListOfMIMETypes";
/*      */       case 4456449:
/* 4563 */         return "ProductPackageIdentifier";
/*      */       case 4456450:
/* 4565 */         return "SubstanceAdministrationApproval";
/*      */       case 4456451:
/* 4567 */         return "ApprovalStatusFurtherDescription";
/*      */       case 4456452:
/* 4569 */         return "ApprovalStatusDateTime";
/*      */       case 4456455:
/* 4571 */         return "ProductTypeCodeSequence";
/*      */       case 4456456:
/* 4573 */         return "ProductName";
/*      */       case 4456457:
/* 4575 */         return "ProductDescription";
/*      */       case 4456458:
/* 4577 */         return "ProductLotIdentifier";
/*      */       case 4456459:
/* 4579 */         return "ProductExpirationDateTime";
/*      */       case 4456464:
/* 4581 */         return "SubstanceAdministrationDateTime";
/*      */       case 4456465:
/* 4583 */         return "SubstanceAdministrationNotes";
/*      */       case 4456466:
/* 4585 */         return "SubstanceAdministrationDeviceID";
/*      */       case 4456467:
/* 4587 */         return "ProductParameterSequence";
/*      */       case 4456473:
/* 4589 */         return "SubstanceAdministrationParameterSequence";
/*      */       case 4587538:
/* 4591 */         return "LensDescription";
/*      */       case 4587540:
/* 4593 */         return "RightLensSequence";
/*      */       case 4587541:
/* 4595 */         return "LeftLensSequence";
/*      */       case 4587542:
/* 4597 */         return "UnspecifiedLateralityLensSequence";
/*      */       case 4587544:
/* 4599 */         return "CylinderSequence";
/*      */       case 4587560:
/* 4601 */         return "PrismSequence";
/*      */       case 4587568:
/* 4603 */         return "HorizontalPrismPower";
/*      */       case 4587570:
/* 4605 */         return "HorizontalPrismBase";
/*      */       case 4587572:
/* 4607 */         return "VerticalPrismPower";
/*      */       case 4587574:
/* 4609 */         return "VerticalPrismBase";
/*      */       case 4587576:
/* 4611 */         return "LensSegmentType";
/*      */       case 4587584:
/* 4613 */         return "OpticalTransmittance";
/*      */       case 4587586:
/* 4615 */         return "ChannelWidth";
/*      */       case 4587588:
/* 4617 */         return "PupilSize";
/*      */       case 4587590:
/* 4619 */         return "CornealSize";
/*      */       case 4587600:
/* 4621 */         return "AutorefractionRightEyeSequence";
/*      */       case 4587602:
/* 4623 */         return "AutorefractionLeftEyeSequence";
/*      */       case 4587616:
/* 4625 */         return "DistancePupillaryDistance";
/*      */       case 4587618:
/* 4627 */         return "NearPupillaryDistance";
/*      */       case 4587619:
/* 4629 */         return "IntermediatePupillaryDistance";
/*      */       case 4587620:
/* 4631 */         return "OtherPupillaryDistance";
/*      */       case 4587632:
/* 4633 */         return "KeratometryRightEyeSequence";
/*      */       case 4587633:
/* 4635 */         return "KeratometryLeftEyeSequence";
/*      */       case 4587636:
/* 4637 */         return "SteepKeratometricAxisSequence";
/*      */       case 4587637:
/* 4639 */         return "RadiusOfCurvature";
/*      */       case 4587638:
/* 4641 */         return "KeratometricPower";
/*      */       case 4587639:
/* 4643 */         return "KeratometricAxis";
/*      */       case 4587648:
/* 4645 */         return "FlatKeratometricAxisSequence";
/*      */       case 4587666:
/* 4647 */         return "BackgroundColor";
/*      */       case 4587668:
/* 4649 */         return "Optotype";
/*      */       case 4587669:
/* 4651 */         return "OptotypePresentation";
/*      */       case 4587671:
/* 4653 */         return "SubjectiveRefractionRightEyeSequence";
/*      */       case 4587672:
/* 4655 */         return "SubjectiveRefractionLeftEyeSequence";
/*      */       case 4587776:
/* 4657 */         return "AddNearSequence";
/*      */       case 4587777:
/* 4659 */         return "AddIntermediateSequence";
/*      */       case 4587778:
/* 4661 */         return "AddOtherSequence";
/*      */       case 4587780:
/* 4663 */         return "AddPower";
/*      */       case 4587782:
/* 4665 */         return "ViewingDistance";
/*      */       case 4587809:
/* 4667 */         return "VisualAcuityTypeCodeSequence";
/*      */       case 4587810:
/* 4669 */         return "VisualAcuityRightEyeSequence";
/*      */       case 4587811:
/* 4671 */         return "VisualAcuityLeftEyeSequence";
/*      */       case 4587812:
/* 4673 */         return "VisualAcuityBothEyesOpenSequence";
/*      */       case 4587813:
/* 4675 */         return "ViewingDistanceType";
/*      */       case 4587829:
/* 4677 */         return "VisualAcuityModifiers";
/*      */       case 4587831:
/* 4679 */         return "DecimalVisualAcuity";
/*      */       case 4587833:
/* 4681 */         return "OptotypeDetailedDefinition";
/*      */       case 4587845:
/* 4683 */         return "ReferencedRefractiveMeasurementsSequence";
/*      */       case 4587846:
/* 4685 */         return "SpherePower";
/*      */       case 4587847:
/* 4687 */         return "CylinderPower";
/*      */       case 4588033:
/* 4689 */         return "CornealTopographySurface";
/*      */       case 4588034:
/* 4691 */         return "CornealVertexLocation";
/*      */       case 4588035:
/* 4693 */         return "PupilCentroidXCoordinate";
/*      */       case 4588036:
/* 4695 */         return "PupilCentroidYCoordinate";
/*      */       case 4588037:
/* 4697 */         return "EquivalentPupilRadius";
/*      */       case 4588039:
/* 4699 */         return "CornealTopographyMapTypeCodeSequence";
/*      */       case 4588040:
/* 4701 */         return "VerticesOfTheOutlineOfPupil";
/*      */       case 4588048:
/* 4703 */         return "CornealTopographyMappingNormalsSequence";
/*      */       case 4588049:
/* 4705 */         return "MaximumCornealCurvatureSequence";
/*      */       case 4588050:
/* 4707 */         return "MaximumCornealCurvature";
/*      */       case 4588051:
/* 4709 */         return "MaximumCornealCurvatureLocation";
/*      */       case 4588053:
/* 4711 */         return "MinimumKeratometricSequence";
/*      */       case 4588056:
/* 4713 */         return "SimulatedKeratometricCylinderSequence";
/*      */       case 4588064:
/* 4715 */         return "AverageCornealPower";
/*      */       case 4588068:
/* 4717 */         return "CornealISValue";
/*      */       case 4588071:
/* 4719 */         return "AnalyzedArea";
/*      */       case 4588080:
/* 4721 */         return "SurfaceRegularityIndex";
/*      */       case 4588082:
/* 4723 */         return "SurfaceAsymmetryIndex";
/*      */       case 4588084:
/* 4725 */         return "CornealEccentricityIndex";
/*      */       case 4588086:
/* 4727 */         return "KeratoconusPredictionIndex";
/*      */       case 4588088:
/* 4729 */         return "DecimalPotentialVisualAcuity";
/*      */       case 4588098:
/* 4731 */         return "CornealTopographyMapQualityEvaluation";
/*      */       case 4588100:
/* 4733 */         return "SourceImageCornealProcessedDataSequence";
/*      */       case 4588103:
/* 4735 */         return "CornealPointLocation";
/*      */       case 4588104:
/* 4737 */         return "CornealPointEstimated";
/*      */       case 4588105:
/* 4739 */         return "AxialPower";
/*      */       case 4588112:
/* 4741 */         return "TangentialPower";
/*      */       case 4588113:
/* 4743 */         return "RefractivePower";
/*      */       case 4588114:
/* 4745 */         return "RelativeElevation";
/*      */       case 4588115:
/* 4747 */         return "CornealWavefront";
/*      */       case 4718593:
/* 4749 */         return "ImagedVolumeWidth";
/*      */       case 4718594:
/* 4751 */         return "ImagedVolumeHeight";
/*      */       case 4718595:
/* 4753 */         return "ImagedVolumeDepth";
/*      */       case 4718598:
/* 4755 */         return "TotalPixelMatrixColumns";
/*      */       case 4718599:
/* 4757 */         return "TotalPixelMatrixRows";
/*      */       case 4718600:
/* 4759 */         return "TotalPixelMatrixOriginSequence";
/*      */       case 4718608:
/* 4761 */         return "SpecimenLabelInImage";
/*      */       case 4718609:
/* 4763 */         return "FocusMethod";
/*      */       case 4718610:
/* 4765 */         return "ExtendedDepthOfField";
/*      */       case 4718611:
/* 4767 */         return "NumberOfFocalPlanes";
/*      */       case 4718612:
/* 4769 */         return "DistanceBetweenFocalPlanes";
/*      */       case 4718613:
/* 4771 */         return "RecommendedAbsentPixelCIELabValue";
/*      */       case 4718848:
/* 4773 */         return "IlluminatorTypeCodeSequence";
/*      */       case 4718850:
/* 4775 */         return "ImageOrientationSlide";
/*      */       case 4718853:
/* 4777 */         return "OpticalPathSequence";
/*      */       case 4718854:
/* 4779 */         return "OpticalPathIdentifier";
/*      */       case 4718855:
/* 4781 */         return "OpticalPathDescription";
/*      */       case 4718856:
/* 4783 */         return "IlluminationColorCodeSequence";
/*      */       case 4718864:
/* 4785 */         return "SpecimenReferenceSequence";
/*      */       case 4718865:
/* 4787 */         return "CondenserLensPower";
/*      */       case 4718866:
/* 4789 */         return "ObjectiveLensPower";
/*      */       case 4718867:
/* 4791 */         return "ObjectiveLensNumericalAperture";
/*      */       case 4718880:
/* 4793 */         return "PaletteColorLookupTableSequence";
/*      */       case 4719104:
/* 4795 */         return "ReferencedImageNavigationSequence";
/*      */       case 4719105:
/* 4797 */         return "TopLeftHandCornerOfLocalizerArea";
/*      */       case 4719106:
/* 4799 */         return "BottomRightHandCornerOfLocalizerArea";
/*      */       case 4719111:
/* 4801 */         return "OpticalPathIdentificationSequence";
/*      */       case 4719130:
/* 4803 */         return "PlanePositionSlideSequence";
/*      */       case 4719134:
/* 4805 */         return "ColumnPositionInTotalImagePixelMatrix";
/*      */       case 4719135:
/* 4807 */         return "RowPositionInTotalImagePixelMatrix";
/*      */       case 4719361:
/* 4809 */         return "PixelOriginInterpretation";
/*      */       case 5242884:
/* 4811 */         return "CalibrationImage";
/*      */       case 5242896:
/* 4813 */         return "DeviceSequence";
/*      */       case 5242898:
/* 4815 */         return "ContainerComponentTypeCodeSequence";
/*      */       case 5242899:
/* 4817 */         return "ContainerComponentThickness";
/*      */       case 5242900:
/* 4819 */         return "DeviceLength";
/*      */       case 5242901:
/* 4821 */         return "ContainerComponentWidth";
/*      */       case 5242902:
/* 4823 */         return "DeviceDiameter";
/*      */       case 5242903:
/* 4825 */         return "DeviceDiameterUnits";
/*      */       case 5242904:
/* 4827 */         return "DeviceVolume";
/*      */       case 5242905:
/* 4829 */         return "InterMarkerDistance";
/*      */       case 5242906:
/* 4831 */         return "ContainerComponentMaterial";
/*      */       case 5242907:
/* 4833 */         return "ContainerComponentID";
/*      */       case 5242908:
/* 4835 */         return "ContainerComponentLength";
/*      */       case 5242909:
/* 4837 */         return "ContainerComponentDiameter";
/*      */       case 5242910:
/* 4839 */         return "ContainerComponentDescription";
/*      */       case 5242912:
/* 4841 */         return "DeviceDescription";
/*      */       case 5373953:
/* 4843 */         return "ContrastBolusIngredientPercentByVolume";
/*      */       case 5373954:
/* 4845 */         return "OCTFocalDistance";
/*      */       case 5373955:
/* 4847 */         return "BeamSpotSize";
/*      */       case 5373956:
/* 4849 */         return "EffectiveRefractiveIndex";
/*      */       case 5373958:
/* 4851 */         return "OCTAcquisitionDomain";
/*      */       case 5373959:
/* 4853 */         return "OCTOpticalCenterWavelength";
/*      */       case 5373960:
/* 4855 */         return "AxialResolution";
/*      */       case 5373961:
/* 4857 */         return "RangingDepth";
/*      */       case 5373969:
/* 4859 */         return "ALineRate";
/*      */       case 5373970:
/* 4861 */         return "ALinesPerFrame";
/*      */       case 5373971:
/* 4863 */         return "CatheterRotationalRate";
/*      */       case 5373972:
/* 4865 */         return "ALinePixelSpacing";
/*      */       case 5373974:
/* 4867 */         return "ModeOfPercutaneousAccessSequence";
/*      */       case 5373989:
/* 4869 */         return "IntravascularOCTFrameTypeSequence";
/*      */       case 5373990:
/* 4871 */         return "OCTZOffsetApplied";
/*      */       case 5373991:
/* 4873 */         return "IntravascularFrameContentSequence";
/*      */       case 5373992:
/* 4875 */         return "IntravascularLongitudinalDistance";
/*      */       case 5373993:
/* 4877 */         return "IntravascularOCTFrameContentSequence";
/*      */       case 5374000:
/* 4879 */         return "OCTZOffsetCorrection";
/*      */       case 5374001:
/* 4881 */         return "CatheterDirectionOfRotation";
/*      */       case 5374003:
/* 4883 */         return "SeamLineLocation";
/*      */       case 5374004:
/* 4885 */         return "FirstALineLocation";
/*      */       case 5374006:
/* 4887 */         return "SeamLineIndex";
/*      */       case 5374008:
/* 4889 */         return "NumberOfPaddedALines";
/*      */       case 5374009:
/* 4891 */         return "InterpolationType";
/*      */       case 5374010:
/* 4893 */         return "RefractiveIndexApplied";
/*      */       case 5505040:
/* 4895 */         return "EnergyWindowVector";
/*      */       case 5505041:
/* 4897 */         return "NumberOfEnergyWindows";
/*      */       case 5505042:
/* 4899 */         return "EnergyWindowInformationSequence";
/*      */       case 5505043:
/* 4901 */         return "EnergyWindowRangeSequence";
/*      */       case 5505044:
/* 4903 */         return "EnergyWindowLowerLimit";
/*      */       case 5505045:
/* 4905 */         return "EnergyWindowUpperLimit";
/*      */       case 5505046:
/* 4907 */         return "RadiopharmaceuticalInformationSequence";
/*      */       case 5505047:
/* 4909 */         return "ResidualSyringeCounts";
/*      */       case 5505048:
/* 4911 */         return "EnergyWindowName";
/*      */       case 5505056:
/* 4913 */         return "DetectorVector";
/*      */       case 5505057:
/* 4915 */         return "NumberOfDetectors";
/*      */       case 5505058:
/* 4917 */         return "DetectorInformationSequence";
/*      */       case 5505072:
/* 4919 */         return "PhaseVector";
/*      */       case 5505073:
/* 4921 */         return "NumberOfPhases";
/*      */       case 5505074:
/* 4923 */         return "PhaseInformationSequence";
/*      */       case 5505075:
/* 4925 */         return "NumberOfFramesInPhase";
/*      */       case 5505078:
/* 4927 */         return "PhaseDelay";
/*      */       case 5505080:
/* 4929 */         return "PauseBetweenFrames";
/*      */       case 5505081:
/* 4931 */         return "PhaseDescription";
/*      */       case 5505104:
/* 4933 */         return "RotationVector";
/*      */       case 5505105:
/* 4935 */         return "NumberOfRotations";
/*      */       case 5505106:
/* 4937 */         return "RotationInformationSequence";
/*      */       case 5505107:
/* 4939 */         return "NumberOfFramesInRotation";
/*      */       case 5505120:
/* 4941 */         return "RRIntervalVector";
/*      */       case 5505121:
/* 4943 */         return "NumberOfRRIntervals";
/*      */       case 5505122:
/* 4945 */         return "GatedInformationSequence";
/*      */       case 5505123:
/* 4947 */         return "DataInformationSequence";
/*      */       case 5505136:
/* 4949 */         return "TimeSlotVector";
/*      */       case 5505137:
/* 4951 */         return "NumberOfTimeSlots";
/*      */       case 5505138:
/* 4953 */         return "TimeSlotInformationSequence";
/*      */       case 5505139:
/* 4955 */         return "TimeSlotTime";
/*      */       case 5505152:
/* 4957 */         return "SliceVector";
/*      */       case 5505153:
/* 4959 */         return "NumberOfSlices";
/*      */       case 5505168:
/* 4961 */         return "AngularViewVector";
/*      */       case 5505280:
/* 4963 */         return "TimeSliceVector";
/*      */       case 5505281:
/* 4965 */         return "NumberOfTimeSlices";
/*      */       case 5505536:
/* 4967 */         return "StartAngle";
/*      */       case 5505538:
/* 4969 */         return "TypeOfDetectorMotion";
/*      */       case 5505552:
/* 4971 */         return "TriggerVector";
/*      */       case 5505553:
/* 4973 */         return "NumberOfTriggersInPhase";
/*      */       case 5505568:
/* 4975 */         return "ViewCodeSequence";
/*      */       case 5505570:
/* 4977 */         return "ViewModifierCodeSequence";
/*      */       case 5505792:
/* 4979 */         return "RadionuclideCodeSequence";
/*      */       case 5505794:
/* 4981 */         return "AdministrationRouteCodeSequence";
/*      */       case 5505796:
/* 4983 */         return "RadiopharmaceuticalCodeSequence";
/*      */       case 5505798:
/* 4985 */         return "CalibrationDataSequence";
/*      */       case 5505800:
/* 4987 */         return "EnergyWindowNumber";
/*      */       case 5506048:
/* 4989 */         return "ImageID";
/*      */       case 5506064:
/* 4991 */         return "PatientOrientationCodeSequence";
/*      */       case 5506066:
/* 4993 */         return "PatientOrientationModifierCodeSequence";
/*      */       case 5506068:
/* 4995 */         return "PatientGantryRelationshipCodeSequence";
/*      */       case 5506304:
/* 4997 */         return "SliceProgressionDirection";
/*      */       case 5506305:
/* 4999 */         return "ScanProgressionDirection";
/*      */       case 5509120:
/* 5001 */         return "SeriesType";
/*      */       case 5509121:
/* 5003 */         return "Units";
/*      */       case 5509122:
/* 5005 */         return "CountsSource";
/*      */       case 5509124:
/* 5007 */         return "ReprojectionMethod";
/*      */       case 5509126:
/* 5009 */         return "SUVType";
/*      */       case 5509376:
/* 5011 */         return "RandomsCorrectionMethod";
/*      */       case 5509377:
/* 5013 */         return "AttenuationCorrectionMethod";
/*      */       case 5509378:
/* 5015 */         return "DecayCorrection";
/*      */       case 5509379:
/* 5017 */         return "ReconstructionMethod";
/*      */       case 5509380:
/* 5019 */         return "DetectorLinesOfResponseUsed";
/*      */       case 5509381:
/* 5021 */         return "ScatterCorrectionMethod";
/*      */       case 5509632:
/* 5023 */         return "AxialAcceptance";
/*      */       case 5509633:
/* 5025 */         return "AxialMash";
/*      */       case 5509634:
/* 5027 */         return "TransverseMash";
/*      */       case 5509635:
/* 5029 */         return "DetectorElementSize";
/*      */       case 5509648:
/* 5031 */         return "CoincidenceWindowWidth";
/*      */       case 5509664:
/* 5033 */         return "SecondaryCountsType";
/*      */       case 5509888:
/* 5035 */         return "FrameReferenceTime";
/*      */       case 5509904:
/* 5037 */         return "PrimaryPromptsCountsAccumulated";
/*      */       case 5509905:
/* 5039 */         return "SecondaryCountsAccumulated";
/*      */       case 5509920:
/* 5041 */         return "SliceSensitivityFactor";
/*      */       case 5509921:
/* 5043 */         return "DecayFactor";
/*      */       case 5509922:
/* 5045 */         return "DoseCalibrationFactor";
/*      */       case 5509923:
/* 5047 */         return "ScatterFractionFactor";
/*      */       case 5509924:
/* 5049 */         return "DeadTimeFactor";
/*      */       case 5509936:
/* 5051 */         return "ImageIndex";
/*      */       case 5510144:
/* 5053 */         return "CountsIncluded";
/*      */       case 5510145:
/* 5055 */         return "DeadTimeCorrectionFlag";
/*      */       case 6303744:
/* 5057 */         return "HistogramSequence";
/*      */       case 6303746:
/* 5059 */         return "HistogramNumberOfBins";
/*      */       case 6303748:
/* 5061 */         return "HistogramFirstBinValue";
/*      */       case 6303750:
/* 5063 */         return "HistogramLastBinValue";
/*      */       case 6303752:
/* 5065 */         return "HistogramBinWidth";
/*      */       case 6303760:
/* 5067 */         return "HistogramExplanation";
/*      */       case 6303776:
/* 5069 */         return "HistogramData";
/*      */       case 6422529:
/* 5071 */         return "SegmentationType";
/*      */       case 6422530:
/* 5073 */         return "SegmentSequence";
/*      */       case 6422531:
/* 5075 */         return "SegmentedPropertyCategoryCodeSequence";
/*      */       case 6422532:
/* 5077 */         return "SegmentNumber";
/*      */       case 6422533:
/* 5079 */         return "SegmentLabel";
/*      */       case 6422534:
/* 5081 */         return "SegmentDescription";
/*      */       case 6422536:
/* 5083 */         return "SegmentAlgorithmType";
/*      */       case 6422537:
/* 5085 */         return "SegmentAlgorithmName";
/*      */       case 6422538:
/* 5087 */         return "SegmentIdentificationSequence";
/*      */       case 6422539:
/* 5089 */         return "ReferencedSegmentNumber";
/*      */       case 6422540:
/* 5091 */         return "RecommendedDisplayGrayscaleValue";
/*      */       case 6422541:
/* 5093 */         return "RecommendedDisplayCIELabValue";
/*      */       case 6422542:
/* 5095 */         return "MaximumFractionalValue";
/*      */       case 6422543:
/* 5097 */         return "SegmentedPropertyTypeCodeSequence";
/*      */       case 6422544:
/* 5099 */         return "SegmentationFractionalType";
/*      */       case 6422545:
/* 5101 */         return "SegmentedPropertyTypeModifierCodeSequence";
/*      */       case 6422546:
/* 5103 */         return "UsedSegmentsSequence";
/*      */       case 6553602:
/* 5105 */         return "DeformableRegistrationSequence";
/*      */       case 6553603:
/* 5107 */         return "SourceFrameOfReferenceUID";
/*      */       case 6553605:
/* 5109 */         return "DeformableRegistrationGridSequence";
/*      */       case 6553607:
/* 5111 */         return "GridDimensions";
/*      */       case 6553608:
/* 5113 */         return "GridResolution";
/*      */       case 6553609:
/* 5115 */         return "VectorGridData";
/*      */       case 6553615:
/* 5117 */         return "PreDeformationMatrixRegistrationSequence";
/*      */       case 6553616:
/* 5119 */         return "PostDeformationMatrixRegistrationSequence";
/*      */       case 6684673:
/* 5121 */         return "NumberOfSurfaces";
/*      */       case 6684674:
/* 5123 */         return "SurfaceSequence";
/*      */       case 6684675:
/* 5125 */         return "SurfaceNumber";
/*      */       case 6684676:
/* 5127 */         return "SurfaceComments";
/*      */       case 6684681:
/* 5129 */         return "SurfaceProcessing";
/*      */       case 6684682:
/* 5131 */         return "SurfaceProcessingRatio";
/*      */       case 6684683:
/* 5133 */         return "SurfaceProcessingDescription";
/*      */       case 6684684:
/* 5135 */         return "RecommendedPresentationOpacity";
/*      */       case 6684685:
/* 5137 */         return "RecommendedPresentationType";
/*      */       case 6684686:
/* 5139 */         return "FiniteVolume";
/*      */       case 6684688:
/* 5141 */         return "Manifold";
/*      */       case 6684689:
/* 5143 */         return "SurfacePointsSequence";
/*      */       case 6684690:
/* 5145 */         return "SurfacePointsNormalsSequence";
/*      */       case 6684691:
/* 5147 */         return "SurfaceMeshPrimitivesSequence";
/*      */       case 6684693:
/* 5149 */         return "NumberOfSurfacePoints";
/*      */       case 6684694:
/* 5151 */         return "PointCoordinatesData";
/*      */       case 6684695:
/* 5153 */         return "PointPositionAccuracy";
/*      */       case 6684696:
/* 5155 */         return "MeanPointDistance";
/*      */       case 6684697:
/* 5157 */         return "MaximumPointDistance";
/*      */       case 6684698:
/* 5159 */         return "PointsBoundingBoxCoordinates";
/*      */       case 6684699:
/* 5161 */         return "AxisOfRotation";
/*      */       case 6684700:
/* 5163 */         return "CenterOfRotation";
/*      */       case 6684702:
/* 5165 */         return "NumberOfVectors";
/*      */       case 6684703:
/* 5167 */         return "VectorDimensionality";
/*      */       case 6684704:
/* 5169 */         return "VectorAccuracy";
/*      */       case 6684705:
/* 5171 */         return "VectorCoordinateData";
/*      */       case 6684707:
/* 5173 */         return "TrianglePointIndexList";
/*      */       case 6684708:
/* 5175 */         return "EdgePointIndexList";
/*      */       case 6684709:
/* 5177 */         return "VertexPointIndexList";
/*      */       case 6684710:
/* 5179 */         return "TriangleStripSequence";
/*      */       case 6684711:
/* 5181 */         return "TriangleFanSequence";
/*      */       case 6684712:
/* 5183 */         return "LineSequence";
/*      */       case 6684713:
/* 5185 */         return "PrimitivePointIndexList";
/*      */       case 6684714:
/* 5187 */         return "SurfaceCount";
/*      */       case 6684715:
/* 5189 */         return "ReferencedSurfaceSequence";
/*      */       case 6684716:
/* 5191 */         return "ReferencedSurfaceNumber";
/*      */       case 6684717:
/* 5193 */         return "SegmentSurfaceGenerationAlgorithmIdentificationSequence";
/*      */       case 6684718:
/* 5195 */         return "SegmentSurfaceSourceInstanceSequence";
/*      */       case 6684719:
/* 5197 */         return "AlgorithmFamilyCodeSequence";
/*      */       case 6684720:
/* 5199 */         return "AlgorithmNameCodeSequence";
/*      */       case 6684721:
/* 5201 */         return "AlgorithmVersion";
/*      */       case 6684722:
/* 5203 */         return "AlgorithmParameters";
/*      */       case 6684724:
/* 5205 */         return "FacetSequence";
/*      */       case 6684725:
/* 5207 */         return "SurfaceProcessingAlgorithmIdentificationSequence";
/*      */       case 6684726:
/* 5209 */         return "AlgorithmName";
/*      */       case 6684727:
/* 5211 */         return "RecommendedPointRadius";
/*      */       case 6684728:
/* 5213 */         return "RecommendedLineThickness";
/*      */       case 6684736:
/* 5215 */         return "LongPrimitivePointIndexList";
/*      */       case 6684737:
/* 5217 */         return "LongTrianglePointIndexList";
/*      */       case 6684738:
/* 5219 */         return "LongEdgePointIndexList";
/*      */       case 6684739:
/* 5221 */         return "LongVertexPointIndexList";
/*      */       case 6840848:
/* 5223 */         return "ImplantSize";
/*      */       case 6840865:
/* 5225 */         return "ImplantTemplateVersion";
/*      */       case 6840866:
/* 5227 */         return "ReplacedImplantTemplateSequence";
/*      */       case 6840867:
/* 5229 */         return "ImplantType";
/*      */       case 6840868:
/* 5231 */         return "DerivationImplantTemplateSequence";
/*      */       case 6840869:
/* 5233 */         return "OriginalImplantTemplateSequence";
/*      */       case 6840870:
/* 5235 */         return "EffectiveDateTime";
/*      */       case 6840880:
/* 5237 */         return "ImplantTargetAnatomySequence";
/*      */       case 6840928:
/* 5239 */         return "InformationFromManufacturerSequence";
/*      */       case 6840933:
/* 5241 */         return "NotificationFromManufacturerSequence";
/*      */       case 6840944:
/* 5243 */         return "InformationIssueDateTime";
/*      */       case 6840960:
/* 5245 */         return "InformationSummary";
/*      */       case 6840992:
/* 5247 */         return "ImplantRegulatoryDisapprovalCodeSequence";
/*      */       case 6840997:
/* 5249 */         return "OverallTemplateSpatialTolerance";
/*      */       case 6841024:
/* 5251 */         return "HPGLDocumentSequence";
/*      */       case 6841040:
/* 5253 */         return "HPGLDocumentID";
/*      */       case 6841045:
/* 5255 */         return "HPGLDocumentLabel";
/*      */       case 6841056:
/* 5257 */         return "ViewOrientationCodeSequence";
/*      */       case 6841072:
/* 5259 */         return "ViewOrientationModifier";
/*      */       case 6841074:
/* 5261 */         return "HPGLDocumentScaling";
/*      */       case 6841088:
/* 5263 */         return "HPGLDocument";
/*      */       case 6841104:
/* 5265 */         return "HPGLContourPenNumber";
/*      */       case 6841120:
/* 5267 */         return "HPGLPenSequence";
/*      */       case 6841136:
/* 5269 */         return "HPGLPenNumber";
/*      */       case 6841152:
/* 5271 */         return "HPGLPenLabel";
/*      */       case 6841157:
/* 5273 */         return "HPGLPenDescription";
/*      */       case 6841158:
/* 5275 */         return "RecommendedRotationPoint";
/*      */       case 6841159:
/* 5277 */         return "BoundingRectangle";
/*      */       case 6841168:
/* 5279 */         return "ImplantTemplate3DModelSurfaceNumber";
/*      */       case 6841184:
/* 5281 */         return "SurfaceModelDescriptionSequence";
/*      */       case 6841216:
/* 5283 */         return "SurfaceModelLabel";
/*      */       case 6841232:
/* 5285 */         return "SurfaceModelScalingFactor";
/*      */       case 6841248:
/* 5287 */         return "MaterialsCodeSequence";
/*      */       case 6841252:
/* 5289 */         return "CoatingMaterialsCodeSequence";
/*      */       case 6841256:
/* 5291 */         return "ImplantTypeCodeSequence";
/*      */       case 6841260:
/* 5293 */         return "FixationMethodCodeSequence";
/*      */       case 6841264:
/* 5295 */         return "MatingFeatureSetsSequence";
/*      */       case 6841280:
/* 5297 */         return "MatingFeatureSetID";
/*      */       case 6841296:
/* 5299 */         return "MatingFeatureSetLabel";
/*      */       case 6841312:
/* 5301 */         return "MatingFeatureSequence";
/*      */       case 6841328:
/* 5303 */         return "MatingFeatureID";
/*      */       case 6841344:
/* 5305 */         return "MatingFeatureDegreeOfFreedomSequence";
/*      */       case 6841360:
/* 5307 */         return "DegreeOfFreedomID";
/*      */       case 6841376:
/* 5309 */         return "DegreeOfFreedomType";
/*      */       case 6841392:
/* 5311 */         return "TwoDMatingFeatureCoordinatesSequence";
/*      */       case 6841408:
/* 5313 */         return "ReferencedHPGLDocumentID";
/*      */       case 6841424:
/* 5315 */         return "TwoDMatingPoint";
/*      */       case 6841440:
/* 5317 */         return "TwoDMatingAxes";
/*      */       case 6841456:
/* 5319 */         return "TwoDDegreeOfFreedomSequence";
/*      */       case 6841488:
/* 5321 */         return "ThreeDDegreeOfFreedomAxis";
/*      */       case 6841504:
/* 5323 */         return "RangeOfFreedom";
/*      */       case 6841536:
/* 5325 */         return "ThreeDMatingPoint";
/*      */       case 6841552:
/* 5327 */         return "ThreeDMatingAxes";
/*      */       case 6841584:
/* 5329 */         return "TwoDDegreeOfFreedomAxis";
/*      */       case 6841600:
/* 5331 */         return "PlanningLandmarkPointSequence";
/*      */       case 6841616:
/* 5333 */         return "PlanningLandmarkLineSequence";
/*      */       case 6841632:
/* 5335 */         return "PlanningLandmarkPlaneSequence";
/*      */       case 6841648:
/* 5337 */         return "PlanningLandmarkID";
/*      */       case 6841664:
/* 5339 */         return "PlanningLandmarkDescription";
/*      */       case 6841669:
/* 5341 */         return "PlanningLandmarkIdentificationCodeSequence";
/*      */       case 6841680:
/* 5343 */         return "TwoDPointCoordinatesSequence";
/*      */       case 6841696:
/* 5345 */         return "TwoDPointCoordinates";
/*      */       case 6841744:
/* 5347 */         return "ThreeDPointCoordinates";
/*      */       case 6841760:
/* 5349 */         return "TwoDLineCoordinatesSequence";
/*      */       case 6841776:
/* 5351 */         return "TwoDLineCoordinates";
/*      */       case 6841808:
/* 5353 */         return "ThreeDLineCoordinates";
/*      */       case 6841824:
/* 5355 */         return "TwoDPlaneCoordinatesSequence";
/*      */       case 6841840:
/* 5357 */         return "TwoDPlaneIntersection";
/*      */       case 6841872:
/* 5359 */         return "ThreeDPlaneOrigin";
/*      */       case 6841888:
/* 5361 */         return "ThreeDPlaneNormal";
/*      */       case 7340033:
/* 5363 */         return "GraphicAnnotationSequence";
/*      */       case 7340034:
/* 5365 */         return "GraphicLayer";
/*      */       case 7340035:
/* 5367 */         return "BoundingBoxAnnotationUnits";
/*      */       case 7340036:
/* 5369 */         return "AnchorPointAnnotationUnits";
/*      */       case 7340037:
/* 5371 */         return "GraphicAnnotationUnits";
/*      */       case 7340038:
/* 5373 */         return "UnformattedTextValue";
/*      */       case 7340040:
/* 5375 */         return "TextObjectSequence";
/*      */       case 7340041:
/* 5377 */         return "GraphicObjectSequence";
/*      */       case 7340048:
/* 5379 */         return "BoundingBoxTopLeftHandCorner";
/*      */       case 7340049:
/* 5381 */         return "BoundingBoxBottomRightHandCorner";
/*      */       case 7340050:
/* 5383 */         return "BoundingBoxTextHorizontalJustification";
/*      */       case 7340052:
/* 5385 */         return "AnchorPoint";
/*      */       case 7340053:
/* 5387 */         return "AnchorPointVisibility";
/*      */       case 7340064:
/* 5389 */         return "GraphicDimensions";
/*      */       case 7340065:
/* 5391 */         return "NumberOfGraphicPoints";
/*      */       case 7340066:
/* 5393 */         return "GraphicData";
/*      */       case 7340067:
/* 5395 */         return "GraphicType";
/*      */       case 7340068:
/* 5397 */         return "GraphicFilled";
/*      */       case 7340096:
/* 5399 */         return "ImageRotationRetired";
/*      */       case 7340097:
/* 5401 */         return "ImageHorizontalFlip";
/*      */       case 7340098:
/* 5403 */         return "ImageRotation";
/*      */       case 7340112:
/* 5405 */         return "DisplayedAreaTopLeftHandCornerTrial";
/*      */       case 7340113:
/* 5407 */         return "DisplayedAreaBottomRightHandCornerTrial";
/*      */       case 7340114:
/* 5409 */         return "DisplayedAreaTopLeftHandCorner";
/*      */       case 7340115:
/* 5411 */         return "DisplayedAreaBottomRightHandCorner";
/*      */       case 7340122:
/* 5413 */         return "DisplayedAreaSelectionSequence";
/*      */       case 7340128:
/* 5415 */         return "GraphicLayerSequence";
/*      */       case 7340130:
/* 5417 */         return "GraphicLayerOrder";
/*      */       case 7340134:
/* 5419 */         return "GraphicLayerRecommendedDisplayGrayscaleValue";
/*      */       case 7340135:
/* 5421 */         return "GraphicLayerRecommendedDisplayRGBValue";
/*      */       case 7340136:
/* 5423 */         return "GraphicLayerDescription";
/*      */       case 7340160:
/* 5425 */         return "ContentLabel";
/*      */       case 7340161:
/* 5427 */         return "ContentDescription";
/*      */       case 7340162:
/* 5429 */         return "PresentationCreationDate";
/*      */       case 7340163:
/* 5431 */         return "PresentationCreationTime";
/*      */       case 7340164:
/* 5433 */         return "ContentCreatorName";
/*      */       case 7340166:
/* 5435 */         return "ContentCreatorIdentificationCodeSequence";
/*      */       case 7340167:
/* 5437 */         return "AlternateContentDescriptionSequence";
/*      */       case 7340288:
/* 5439 */         return "PresentationSizeMode";
/*      */       case 7340289:
/* 5441 */         return "PresentationPixelSpacing";
/*      */       case 7340290:
/* 5443 */         return "PresentationPixelAspectRatio";
/*      */       case 7340291:
/* 5445 */         return "PresentationPixelMagnificationRatio";
/*      */       case 7340551:
/* 5447 */         return "GraphicGroupLabel";
/*      */       case 7340552:
/* 5449 */         return "GraphicGroupDescription";
/*      */       case 7340553:
/* 5451 */         return "CompoundGraphicSequence";
/*      */       case 7340582:
/* 5453 */         return "CompoundGraphicInstanceID";
/*      */       case 7340583:
/* 5455 */         return "FontName";
/*      */       case 7340584:
/* 5457 */         return "FontNameType";
/*      */       case 7340585:
/* 5459 */         return "CSSFontName";
/*      */       case 7340592:
/* 5461 */         return "RotationAngle";
/*      */       case 7340593:
/* 5463 */         return "TextStyleSequence";
/*      */       case 7340594:
/* 5465 */         return "LineStyleSequence";
/*      */       case 7340595:
/* 5467 */         return "FillStyleSequence";
/*      */       case 7340596:
/* 5469 */         return "GraphicGroupSequence";
/*      */       case 7340609:
/* 5471 */         return "TextColorCIELabValue";
/*      */       case 7340610:
/* 5473 */         return "HorizontalAlignment";
/*      */       case 7340611:
/* 5475 */         return "VerticalAlignment";
/*      */       case 7340612:
/* 5477 */         return "ShadowStyle";
/*      */       case 7340613:
/* 5479 */         return "ShadowOffsetX";
/*      */       case 7340614:
/* 5481 */         return "ShadowOffsetY";
/*      */       case 7340615:
/* 5483 */         return "ShadowColorCIELabValue";
/*      */       case 7340616:
/* 5485 */         return "Underlined";
/*      */       case 7340617:
/* 5487 */         return "Bold";
/*      */       case 7340624:
/* 5489 */         return "Italic";
/*      */       case 7340625:
/* 5491 */         return "PatternOnColorCIELabValue";
/*      */       case 7340626:
/* 5493 */         return "PatternOffColorCIELabValue";
/*      */       case 7340627:
/* 5495 */         return "LineThickness";
/*      */       case 7340628:
/* 5497 */         return "LineDashingStyle";
/*      */       case 7340629:
/* 5499 */         return "LinePattern";
/*      */       case 7340630:
/* 5501 */         return "FillPattern";
/*      */       case 7340631:
/* 5503 */         return "FillMode";
/*      */       case 7340632:
/* 5505 */         return "ShadowOpacity";
/*      */       case 7340641:
/* 5507 */         return "GapLength";
/*      */       case 7340642:
/* 5509 */         return "DiameterOfVisibility";
/*      */       case 7340659:
/* 5511 */         return "RotationPoint";
/*      */       case 7340660:
/* 5513 */         return "TickAlignment";
/*      */       case 7340664:
/* 5515 */         return "ShowTickLabel";
/*      */       case 7340665:
/* 5517 */         return "TickLabelAlignment";
/*      */       case 7340674:
/* 5519 */         return "CompoundGraphicUnits";
/*      */       case 7340676:
/* 5521 */         return "PatternOnOpacity";
/*      */       case 7340677:
/* 5523 */         return "PatternOffOpacity";
/*      */       case 7340679:
/* 5525 */         return "MajorTicksSequence";
/*      */       case 7340680:
/* 5527 */         return "TickPosition";
/*      */       case 7340681:
/* 5529 */         return "TickLabel";
/*      */       case 7340692:
/* 5531 */         return "CompoundGraphicType";
/*      */       case 7340693:
/* 5533 */         return "GraphicGroupID";
/*      */       case 7340806:
/* 5535 */         return "ShapeType";
/*      */       case 7340808:
/* 5537 */         return "RegistrationSequence";
/*      */       case 7340809:
/* 5539 */         return "MatrixRegistrationSequence";
/*      */       case 7340810:
/* 5541 */         return "MatrixSequence";
/*      */       case 7340812:
/* 5543 */         return "FrameOfReferenceTransformationMatrixType";
/*      */       case 7340813:
/* 5545 */         return "RegistrationTypeCodeSequence";
/*      */       case 7340815:
/* 5547 */         return "FiducialDescription";
/*      */       case 7340816:
/* 5549 */         return "FiducialIdentifier";
/*      */       case 7340817:
/* 5551 */         return "FiducialIdentifierCodeSequence";
/*      */       case 7340818:
/* 5553 */         return "ContourUncertaintyRadius";
/*      */       case 7340820:
/* 5555 */         return "UsedFiducialsSequence";
/*      */       case 7340824:
/* 5557 */         return "GraphicCoordinatesDataSequence";
/*      */       case 7340826:
/* 5559 */         return "FiducialUID";
/*      */       case 7340828:
/* 5561 */         return "FiducialSetSequence";
/*      */       case 7340830:
/* 5563 */         return "FiducialSequence";
/*      */       case 7341057:
/* 5565 */         return "GraphicLayerRecommendedDisplayCIELabValue";
/*      */       case 7341058:
/* 5567 */         return "BlendingSequence";
/*      */       case 7341059:
/* 5569 */         return "RelativeOpacity";
/*      */       case 7341060:
/* 5571 */         return "ReferencedSpatialRegistrationSequence";
/*      */       case 7341061:
/* 5573 */         return "BlendingPosition";
/*      */       case 7471106:
/* 5575 */         return "HangingProtocolName";
/*      */       case 7471108:
/* 5577 */         return "HangingProtocolDescription";
/*      */       case 7471110:
/* 5579 */         return "HangingProtocolLevel";
/*      */       case 7471112:
/* 5581 */         return "HangingProtocolCreator";
/*      */       case 7471114:
/* 5583 */         return "HangingProtocolCreationDateTime";
/*      */       case 7471116:
/* 5585 */         return "HangingProtocolDefinitionSequence";
/*      */       case 7471118:
/* 5587 */         return "HangingProtocolUserIdentificationCodeSequence";
/*      */       case 7471120:
/* 5589 */         return "HangingProtocolUserGroupName";
/*      */       case 7471122:
/* 5591 */         return "SourceHangingProtocolSequence";
/*      */       case 7471124:
/* 5593 */         return "NumberOfPriorsReferenced";
/*      */       case 7471136:
/* 5595 */         return "ImageSetsSequence";
/*      */       case 7471138:
/* 5597 */         return "ImageSetSelectorSequence";
/*      */       case 7471140:
/* 5599 */         return "ImageSetSelectorUsageFlag";
/*      */       case 7471142:
/* 5601 */         return "SelectorAttribute";
/*      */       case 7471144:
/* 5603 */         return "SelectorValueNumber";
/*      */       case 7471152:
/* 5605 */         return "TimeBasedImageSetsSequence";
/*      */       case 7471154:
/* 5607 */         return "ImageSetNumber";
/*      */       case 7471156:
/* 5609 */         return "ImageSetSelectorCategory";
/*      */       case 7471160:
/* 5611 */         return "RelativeTime";
/*      */       case 7471162:
/* 5613 */         return "RelativeTimeUnits";
/*      */       case 7471164:
/* 5615 */         return "AbstractPriorValue";
/*      */       case 7471166:
/* 5617 */         return "AbstractPriorCodeSequence";
/*      */       case 7471168:
/* 5619 */         return "ImageSetLabel";
/*      */       case 7471184:
/* 5621 */         return "SelectorAttributeVR";
/*      */       case 7471186:
/* 5623 */         return "SelectorSequencePointer";
/*      */       case 7471188:
/* 5625 */         return "SelectorSequencePointerPrivateCreator";
/*      */       case 7471190:
/* 5627 */         return "SelectorAttributePrivateCreator";
/*      */       case 7471200:
/* 5629 */         return "SelectorATValue";
/*      */       case 7471202:
/* 5631 */         return "SelectorCSValue";
/*      */       case 7471204:
/* 5633 */         return "SelectorISValue";
/*      */       case 7471206:
/* 5635 */         return "SelectorLOValue";
/*      */       case 7471208:
/* 5637 */         return "SelectorLTValue";
/*      */       case 7471210:
/* 5639 */         return "SelectorPNValue";
/*      */       case 7471212:
/* 5641 */         return "SelectorSHValue";
/*      */       case 7471214:
/* 5643 */         return "SelectorSTValue";
/*      */       case 7471216:
/* 5645 */         return "SelectorUTValue";
/*      */       case 7471218:
/* 5647 */         return "SelectorDSValue";
/*      */       case 7471220:
/* 5649 */         return "SelectorFDValue";
/*      */       case 7471222:
/* 5651 */         return "SelectorFLValue";
/*      */       case 7471224:
/* 5653 */         return "SelectorULValue";
/*      */       case 7471226:
/* 5655 */         return "SelectorUSValue";
/*      */       case 7471228:
/* 5657 */         return "SelectorSLValue";
/*      */       case 7471230:
/* 5659 */         return "SelectorSSValue";
/*      */       case 7471232:
/* 5661 */         return "SelectorCodeSequenceValue";
/*      */       case 7471360:
/* 5663 */         return "NumberOfScreens";
/*      */       case 7471362:
/* 5665 */         return "NominalScreenDefinitionSequence";
/*      */       case 7471364:
/* 5667 */         return "NumberOfVerticalPixels";
/*      */       case 7471366:
/* 5669 */         return "NumberOfHorizontalPixels";
/*      */       case 7471368:
/* 5671 */         return "DisplayEnvironmentSpatialPosition";
/*      */       case 7471370:
/* 5673 */         return "ScreenMinimumGrayscaleBitDepth";
/*      */       case 7471372:
/* 5675 */         return "ScreenMinimumColorBitDepth";
/*      */       case 7471374:
/* 5677 */         return "ApplicationMaximumRepaintTime";
/*      */       case 7471616:
/* 5679 */         return "DisplaySetsSequence";
/*      */       case 7471618:
/* 5681 */         return "DisplaySetNumber";
/*      */       case 7471619:
/* 5683 */         return "DisplaySetLabel";
/*      */       case 7471620:
/* 5685 */         return "DisplaySetPresentationGroup";
/*      */       case 7471622:
/* 5687 */         return "DisplaySetPresentationGroupDescription";
/*      */       case 7471624:
/* 5689 */         return "PartialDataDisplayHandling";
/*      */       case 7471632:
/* 5691 */         return "SynchronizedScrollingSequence";
/*      */       case 7471634:
/* 5693 */         return "DisplaySetScrollingGroup";
/*      */       case 7471636:
/* 5695 */         return "NavigationIndicatorSequence";
/*      */       case 7471638:
/* 5697 */         return "NavigationDisplaySet";
/*      */       case 7471640:
/* 5699 */         return "ReferenceDisplaySets";
/*      */       case 7471872:
/* 5701 */         return "ImageBoxesSequence";
/*      */       case 7471874:
/* 5703 */         return "ImageBoxNumber";
/*      */       case 7471876:
/* 5705 */         return "ImageBoxLayoutType";
/*      */       case 7471878:
/* 5707 */         return "ImageBoxTileHorizontalDimension";
/*      */       case 7471880:
/* 5709 */         return "ImageBoxTileVerticalDimension";
/*      */       case 7471888:
/* 5711 */         return "ImageBoxScrollDirection";
/*      */       case 7471890:
/* 5713 */         return "ImageBoxSmallScrollType";
/*      */       case 7471892:
/* 5715 */         return "ImageBoxSmallScrollAmount";
/*      */       case 7471894:
/* 5717 */         return "ImageBoxLargeScrollType";
/*      */       case 7471896:
/* 5719 */         return "ImageBoxLargeScrollAmount";
/*      */       case 7471904:
/* 5721 */         return "ImageBoxOverlapPriority";
/*      */       case 7471920:
/* 5723 */         return "CineRelativeToRealTime";
/*      */       case 7472128:
/* 5725 */         return "FilterOperationsSequence";
/*      */       case 7472130:
/* 5727 */         return "FilterByCategory";
/*      */       case 7472132:
/* 5729 */         return "FilterByAttributePresence";
/*      */       case 7472134:
/* 5731 */         return "FilterByOperator";
/*      */       case 7472160:
/* 5733 */         return "StructuredDisplayBackgroundCIELabValue";
/*      */       case 7472161:
/* 5735 */         return "EmptyImageBoxCIELabValue";
/*      */       case 7472162:
/* 5737 */         return "StructuredDisplayImageBoxSequence";
/*      */       case 7472164:
/* 5739 */         return "StructuredDisplayTextBoxSequence";
/*      */       case 7472167:
/* 5741 */         return "ReferencedFirstFrameSequence";
/*      */       case 7472176:
/* 5743 */         return "ImageBoxSynchronizationSequence";
/*      */       case 7472178:
/* 5745 */         return "SynchronizedImageBoxList";
/*      */       case 7472180:
/* 5747 */         return "TypeOfSynchronization";
/*      */       case 7472384:
/* 5749 */         return "BlendingOperationType";
/*      */       case 7472400:
/* 5751 */         return "ReformattingOperationType";
/*      */       case 7472402:
/* 5753 */         return "ReformattingThickness";
/*      */       case 7472404:
/* 5755 */         return "ReformattingInterval";
/*      */       case 7472406:
/* 5757 */         return "ReformattingOperationInitialViewDirection";
/*      */       case 7472416:
/* 5759 */         return "ThreeDRenderingType";
/*      */       case 7472640:
/* 5761 */         return "SortingOperationsSequence";
/*      */       case 7472642:
/* 5763 */         return "SortByCategory";
/*      */       case 7472644:
/* 5765 */         return "SortingDirection";
/*      */       case 7472896:
/* 5767 */         return "DisplaySetPatientOrientation";
/*      */       case 7472898:
/* 5769 */         return "VOIType";
/*      */       case 7472900:
/* 5771 */         return "PseudoColorType";
/*      */       case 7472901:
/* 5773 */         return "PseudoColorPaletteInstanceReferenceSequence";
/*      */       case 7472902:
/* 5775 */         return "ShowGrayscaleInverted";
/*      */       case 7472912:
/* 5777 */         return "ShowImageTrueSizeFlag";
/*      */       case 7472914:
/* 5779 */         return "ShowGraphicAnnotationFlag";
/*      */       case 7472916:
/* 5781 */         return "ShowPatientDemographicsFlag";
/*      */       case 7472918:
/* 5783 */         return "ShowAcquisitionTechniquesFlag";
/*      */       case 7472919:
/* 5785 */         return "DisplaySetHorizontalJustification";
/*      */       case 7472920:
/* 5787 */         return "DisplaySetVerticalJustification";
/*      */       case 7602464:
/* 5789 */         return "ContinuationStartMeterset";
/*      */       case 7602465:
/* 5791 */         return "ContinuationEndMeterset";
/*      */       case 7606272:
/* 5793 */         return "ProcedureStepState";
/*      */       case 7606274:
/* 5795 */         return "ProcedureStepProgressInformationSequence";
/*      */       case 7606276:
/* 5797 */         return "ProcedureStepProgress";
/*      */       case 7606278:
/* 5799 */         return "ProcedureStepProgressDescription";
/*      */       case 7606280:
/* 5801 */         return "ProcedureStepCommunicationsURISequence";
/*      */       case 7606282:
/* 5803 */         return "ContactURI";
/*      */       case 7606284:
/* 5805 */         return "ContactDisplayName";
/*      */       case 7606286:
/* 5807 */         return "ProcedureStepDiscontinuationReasonCodeSequence";
/*      */       case 7606304:
/* 5809 */         return "BeamTaskSequence";
/*      */       case 7606306:
/* 5811 */         return "BeamTaskType";
/*      */       case 7606308:
/* 5813 */         return "BeamOrderIndexTrial";
/*      */       case 7606309:
/* 5815 */         return "AutosequenceFlag";
/*      */       case 7606310:
/* 5817 */         return "TableTopVerticalAdjustedPosition";
/*      */       case 7606311:
/* 5819 */         return "TableTopLongitudinalAdjustedPosition";
/*      */       case 7606312:
/* 5821 */         return "TableTopLateralAdjustedPosition";
/*      */       case 7606314:
/* 5823 */         return "PatientSupportAdjustedAngle";
/*      */       case 7606315:
/* 5825 */         return "TableTopEccentricAdjustedAngle";
/*      */       case 7606316:
/* 5827 */         return "TableTopPitchAdjustedAngle";
/*      */       case 7606317:
/* 5829 */         return "TableTopRollAdjustedAngle";
/*      */       case 7606320:
/* 5831 */         return "DeliveryVerificationImageSequence";
/*      */       case 7606322:
/* 5833 */         return "VerificationImageTiming";
/*      */       case 7606324:
/* 5835 */         return "DoubleExposureFlag";
/*      */       case 7606326:
/* 5837 */         return "DoubleExposureOrdering";
/*      */       case 7606328:
/* 5839 */         return "DoubleExposureMetersetTrial";
/*      */       case 7606330:
/* 5841 */         return "DoubleExposureFieldDeltaTrial";
/*      */       case 7606336:
/* 5843 */         return "RelatedReferenceRTImageSequence";
/*      */       case 7606338:
/* 5845 */         return "GeneralMachineVerificationSequence";
/*      */       case 7606340:
/* 5847 */         return "ConventionalMachineVerificationSequence";
/*      */       case 7606342:
/* 5849 */         return "IonMachineVerificationSequence";
/*      */       case 7606344:
/* 5851 */         return "FailedAttributesSequence";
/*      */       case 7606346:
/* 5853 */         return "OverriddenAttributesSequence";
/*      */       case 7606348:
/* 5855 */         return "ConventionalControlPointVerificationSequence";
/*      */       case 7606350:
/* 5857 */         return "IonControlPointVerificationSequence";
/*      */       case 7606352:
/* 5859 */         return "AttributeOccurrenceSequence";
/*      */       case 7606354:
/* 5861 */         return "AttributeOccurrencePointer";
/*      */       case 7606356:
/* 5863 */         return "AttributeItemSelector";
/*      */       case 7606358:
/* 5865 */         return "AttributeOccurrencePrivateCreator";
/*      */       case 7606359:
/* 5867 */         return "SelectorSequencePointerItems";
/*      */       case 7606784:
/* 5869 */         return "ScheduledProcedureStepPriority";
/*      */       case 7606786:
/* 5871 */         return "WorklistLabel";
/*      */       case 7606788:
/* 5873 */         return "ProcedureStepLabel";
/*      */       case 7606800:
/* 5875 */         return "ScheduledProcessingParametersSequence";
/*      */       case 7606802:
/* 5877 */         return "PerformedProcessingParametersSequence";
/*      */       case 7606806:
/* 5879 */         return "UnifiedProcedureStepPerformedProcedureSequence";
/*      */       case 7606816:
/* 5881 */         return "RelatedProcedureStepSequence";
/*      */       case 7606818:
/* 5883 */         return "ProcedureStepRelationshipType";
/*      */       case 7606820:
/* 5885 */         return "ReplacedProcedureStepSequence";
/*      */       case 7606832:
/* 5887 */         return "DeletionLock";
/*      */       case 7606836:
/* 5889 */         return "ReceivingAE";
/*      */       case 7606838:
/* 5891 */         return "RequestingAE";
/*      */       case 7606840:
/* 5893 */         return "ReasonForCancellation";
/*      */       case 7606850:
/* 5895 */         return "SCPStatus";
/*      */       case 7606852:
/* 5897 */         return "SubscriptionListStatus";
/*      */       case 7606854:
/* 5899 */         return "UnifiedProcedureStepListStatus";
/*      */       case 7607076:
/* 5901 */         return "BeamOrderIndex";
/*      */       case 7607096:
/* 5903 */         return "DoubleExposureMeterset";
/*      */       case 7607098:
/* 5905 */         return "DoubleExposureFieldDelta";
/*      */       case 7733249:
/* 5907 */         return "ImplantAssemblyTemplateName";
/*      */       case 7733251:
/* 5909 */         return "ImplantAssemblyTemplateIssuer";
/*      */       case 7733254:
/* 5911 */         return "ImplantAssemblyTemplateVersion";
/*      */       case 7733256:
/* 5913 */         return "ReplacedImplantAssemblyTemplateSequence";
/*      */       case 7733258:
/* 5915 */         return "ImplantAssemblyTemplateType";
/*      */       case 7733260:
/* 5917 */         return "OriginalImplantAssemblyTemplateSequence";
/*      */       case 7733262:
/* 5919 */         return "DerivationImplantAssemblyTemplateSequence";
/*      */       case 7733264:
/* 5921 */         return "ImplantAssemblyTemplateTargetAnatomySequence";
/*      */       case 7733280:
/* 5923 */         return "ProcedureTypeCodeSequence";
/*      */       case 7733296:
/* 5925 */         return "SurgicalTechnique";
/*      */       case 7733298:
/* 5927 */         return "ComponentTypesSequence";
/*      */       case 7733300:
/* 5929 */         return "ComponentTypeCodeSequence";
/*      */       case 7733302:
/* 5931 */         return "ExclusiveComponentType";
/*      */       case 7733304:
/* 5933 */         return "MandatoryComponentType";
/*      */       case 7733312:
/* 5935 */         return "ComponentSequence";
/*      */       case 7733333:
/* 5937 */         return "ComponentID";
/*      */       case 7733344:
/* 5939 */         return "ComponentAssemblySequence";
/*      */       case 7733360:
/* 5941 */         return "Component1ReferencedID";
/*      */       case 7733376:
/* 5943 */         return "Component1ReferencedMatingFeatureSetID";
/*      */       case 7733392:
/* 5945 */         return "Component1ReferencedMatingFeatureID";
/*      */       case 7733408:
/* 5947 */         return "Component2ReferencedID";
/*      */       case 7733424:
/* 5949 */         return "Component2ReferencedMatingFeatureSetID";
/*      */       case 7733440:
/* 5951 */         return "Component2ReferencedMatingFeatureID";
/*      */       case 7864321:
/* 5953 */         return "ImplantTemplateGroupName";
/*      */       case 7864336:
/* 5955 */         return "ImplantTemplateGroupDescription";
/*      */       case 7864352:
/* 5957 */         return "ImplantTemplateGroupIssuer";
/*      */       case 7864356:
/* 5959 */         return "ImplantTemplateGroupVersion";
/*      */       case 7864358:
/* 5961 */         return "ReplacedImplantTemplateGroupSequence";
/*      */       case 7864360:
/* 5963 */         return "ImplantTemplateGroupTargetAnatomySequence";
/*      */       case 7864362:
/* 5965 */         return "ImplantTemplateGroupMembersSequence";
/*      */       case 7864366:
/* 5967 */         return "ImplantTemplateGroupMemberID";
/*      */       case 7864400:
/* 5969 */         return "ThreeDImplantTemplateGroupMemberMatchingPoint";
/*      */       case 7864416:
/* 5971 */         return "ThreeDImplantTemplateGroupMemberMatchingAxes";
/*      */       case 7864432:
/* 5973 */         return "ImplantTemplateGroupMemberMatching2DCoordinatesSequence";
/*      */       case 7864464:
/* 5975 */         return "TwoDImplantTemplateGroupMemberMatchingPoint";
/*      */       case 7864480:
/* 5977 */         return "TwoDImplantTemplateGroupMemberMatchingAxes";
/*      */       case 7864496:
/* 5979 */         return "ImplantTemplateGroupVariationDimensionSequence";
/*      */       case 7864498:
/* 5981 */         return "ImplantTemplateGroupVariationDimensionName";
/*      */       case 7864500:
/* 5983 */         return "ImplantTemplateGroupVariationDimensionRankSequence";
/*      */       case 7864502:
/* 5985 */         return "ReferencedImplantTemplateGroupMemberID";
/*      */       case 7864504:
/* 5987 */         return "ImplantTemplateGroupVariationDimensionRank";
/*      */       case 8388609:
/* 5989 */         return "SurfaceScanAcquisitionTypeCodeSequence";
/*      */       case 8388610:
/* 5991 */         return "SurfaceScanModeCodeSequence";
/*      */       case 8388611:
/* 5993 */         return "RegistrationMethodCodeSequence";
/*      */       case 8388612:
/* 5995 */         return "ShotDurationTime";
/*      */       case 8388613:
/* 5997 */         return "ShotOffsetTime";
/*      */       case 8388614:
/* 5999 */         return "SurfacePointPresentationValueData";
/*      */       case 8388615:
/* 6001 */         return "SurfacePointColorCIELabValueData";
/*      */       case 8388616:
/* 6003 */         return "UVMappingSequence";
/*      */       case 8388617:
/* 6005 */         return "TextureLabel";
/*      */       case 8388624:
/* 6007 */         return "UValueData";
/*      */       case 8388625:
/* 6009 */         return "VValueData";
/*      */       case 8388626:
/* 6011 */         return "ReferencedTextureSequence";
/*      */       case 8388627:
/* 6013 */         return "ReferencedSurfaceDataSequence";
/*      */       case 8913200:
/* 6015 */         return "StorageMediaFileSetID";
/*      */       case 8913216:
/* 6017 */         return "StorageMediaFileSetUID";
/*      */       case 8913408:
/* 6019 */         return "IconImageSequence";
/*      */       case 8915204:
/* 6021 */         return "TopicTitle";
/*      */       case 8915206:
/* 6023 */         return "TopicSubject";
/*      */       case 8915216:
/* 6025 */         return "TopicAuthor";
/*      */       case 8915218:
/* 6027 */         return "TopicKeywords";
/*      */       case 16778256:
/* 6029 */         return "SOPInstanceStatus";
/*      */       case 16778272:
/* 6031 */         return "SOPAuthorizationDateTime";
/*      */       case 16778276:
/* 6033 */         return "SOPAuthorizationComment";
/*      */       case 16778278:
/* 6035 */         return "AuthorizationEquipmentCertificationNumber";
/*      */       case 67108869:
/* 6037 */         return "MACIDNumber";
/*      */       case 67108880:
/* 6039 */         return "MACCalculationTransferSyntaxUID";
/*      */       case 67108885:
/* 6041 */         return "MACAlgorithm";
/*      */       case 67108896:
/* 6043 */         return "DataElementsSigned";
/*      */       case 67109120:
/* 6045 */         return "DigitalSignatureUID";
/*      */       case 67109125:
/* 6047 */         return "DigitalSignatureDateTime";
/*      */       case 67109136:
/* 6049 */         return "CertificateType";
/*      */       case 67109141:
/* 6051 */         return "CertificateOfSigner";
/*      */       case 67109152:
/* 6053 */         return "Signature";
/*      */       case 67109637:
/* 6055 */         return "CertifiedTimestampType";
/*      */       case 67109648:
/* 6057 */         return "CertifiedTimestamp";
/*      */       case 67109889:
/* 6059 */         return "DigitalSignaturePurposeCodeSequence";
/*      */       case 67109890:
/* 6061 */         return "ReferencedDigitalSignatureSequence";
/*      */       case 67109891:
/* 6063 */         return "ReferencedSOPInstanceMACSequence";
/*      */       case 67109892:
/* 6065 */         return "MAC";
/*      */       case 67110144:
/* 6067 */         return "EncryptedAttributesSequence";
/*      */       case 67110160:
/* 6069 */         return "EncryptedContentTransferSyntaxUID";
/*      */       case 67110176:
/* 6071 */         return "EncryptedContent";
/*      */       case 67110224:
/* 6073 */         return "ModifiedAttributesSequence";
/*      */       case 67110241:
/* 6075 */         return "OriginalAttributesSequence";
/*      */       case 67110242:
/* 6077 */         return "AttributeModificationDateTime";
/*      */       case 67110243:
/* 6079 */         return "ModifyingSystem";
/*      */       case 67110244:
/* 6081 */         return "SourceOfPreviousValues";
/*      */       case 67110245:
/* 6083 */         return "ReasonForTheAttributeModification";
/*      */       case 268435456:
/* 6085 */         return "EscapeTriplet";
/*      */       case 268435457:
/* 6087 */         return "RunLengthTriplet";
/*      */       case 268435458:
/* 6089 */         return "HuffmanTableSize";
/*      */       case 268435459:
/* 6091 */         return "HuffmanTableTriplet";
/*      */       case 268435460:
/* 6093 */         return "ShiftTableSize";
/*      */       case 268435461:
/* 6095 */         return "ShiftTableTriplet";
/*      */       case 269484032:
/* 6097 */         return "ZonalMap";
/*      */       case 536870928:
/* 6099 */         return "NumberOfCopies";
/*      */       case 536870942:
/* 6101 */         return "PrinterConfigurationSequence";
/*      */       case 536870944:
/* 6103 */         return "PrintPriority";
/*      */       case 536870960:
/* 6105 */         return "MediumType";
/*      */       case 536870976:
/* 6107 */         return "FilmDestination";
/*      */       case 536870992:
/* 6109 */         return "FilmSessionLabel";
/*      */       case 536871008:
/* 6111 */         return "MemoryAllocation";
/*      */       case 536871009:
/* 6113 */         return "MaximumMemoryAllocation";
/*      */       case 536871010:
/* 6115 */         return "ColorImagePrintingFlag";
/*      */       case 536871011:
/* 6117 */         return "CollationFlag";
/*      */       case 536871013:
/* 6119 */         return "AnnotationFlag";
/*      */       case 536871015:
/* 6121 */         return "ImageOverlayFlag";
/*      */       case 536871017:
/* 6123 */         return "PresentationLUTFlag";
/*      */       case 536871018:
/* 6125 */         return "ImageBoxPresentationLUTFlag";
/*      */       case 536871072:
/* 6127 */         return "MemoryBitDepth";
/*      */       case 536871073:
/* 6129 */         return "PrintingBitDepth";
/*      */       case 536871074:
/* 6131 */         return "MediaInstalledSequence";
/*      */       case 536871076:
/* 6133 */         return "OtherMediaAvailableSequence";
/*      */       case 536871080:
/* 6135 */         return "SupportedImageDisplayFormatsSequence";
/*      */       case 536872192:
/* 6137 */         return "ReferencedFilmBoxSequence";
/*      */       case 536872208:
/* 6139 */         return "ReferencedStoredPrintSequence";
/*      */       case 537919504:
/* 6141 */         return "ImageDisplayFormat";
/*      */       case 537919536:
/* 6143 */         return "AnnotationDisplayFormatID";
/*      */       case 537919552:
/* 6145 */         return "FilmOrientation";
/*      */       case 537919568:
/* 6147 */         return "FilmSizeID";
/*      */       case 537919570:
/* 6149 */         return "PrinterResolutionID";
/*      */       case 537919572:
/* 6151 */         return "DefaultPrinterResolutionID";
/*      */       case 537919584:
/* 6153 */         return "MagnificationType";
/*      */       case 537919616:
/* 6155 */         return "SmoothingType";
/*      */       case 537919654:
/* 6157 */         return "DefaultMagnificationType";
/*      */       case 537919655:
/* 6159 */         return "OtherMagnificationTypesAvailable";
/*      */       case 537919656:
/* 6161 */         return "DefaultSmoothingType";
/*      */       case 537919657:
/* 6163 */         return "OtherSmoothingTypesAvailable";
/*      */       case 537919744:
/* 6165 */         return "BorderDensity";
/*      */       case 537919760:
/* 6167 */         return "EmptyImageDensity";
/*      */       case 537919776:
/* 6169 */         return "MinDensity";
/*      */       case 537919792:
/* 6171 */         return "MaxDensity";
/*      */       case 537919808:
/* 6173 */         return "Trim";
/*      */       case 537919824:
/* 6175 */         return "ConfigurationInformation";
/*      */       case 537919826:
/* 6177 */         return "ConfigurationInformationDescription";
/*      */       case 537919828:
/* 6179 */         return "MaximumCollatedFilms";
/*      */       case 537919838:
/* 6181 */         return "Illumination";
/*      */       case 537919840:
/* 6183 */         return "ReflectedAmbientLight";
/*      */       case 537920374:
/* 6185 */         return "PrinterPixelSpacing";
/*      */       case 537920768:
/* 6187 */         return "ReferencedFilmSessionSequence";
/*      */       case 537920784:
/* 6189 */         return "ReferencedImageBoxSequence";
/*      */       case 537920800:
/* 6191 */         return "ReferencedBasicAnnotationBoxSequence";
/*      */       case 538968080:
/* 6193 */         return "ImageBoxPosition";
/*      */       case 538968096:
/* 6195 */         return "Polarity";
/*      */       case 538968112:
/* 6197 */         return "RequestedImageSize";
/*      */       case 538968128:
/* 6199 */         return "RequestedDecimateCropBehavior";
/*      */       case 538968144:
/* 6201 */         return "RequestedResolutionID";
/*      */       case 538968224:
/* 6203 */         return "RequestedImageSizeFlag";
/*      */       case 538968226:
/* 6205 */         return "DecimateCropResult";
/*      */       case 538968336:
/* 6207 */         return "BasicGrayscaleImageSequence";
/*      */       case 538968337:
/* 6209 */         return "BasicColorImageSequence";
/*      */       case 538968368:
/* 6211 */         return "ReferencedImageOverlayBoxSequence";
/*      */       case 538968384:
/* 6213 */         return "ReferencedVOILUTBoxSequence";
/*      */       case 540016656:
/* 6215 */         return "AnnotationPosition";
/*      */       case 540016672:
/* 6217 */         return "TextString";
/*      */       case 541065232:
/* 6219 */         return "ReferencedOverlayPlaneSequence";
/*      */       case 541065233:
/* 6221 */         return "ReferencedOverlayPlaneGroups";
/*      */       case 541065248:
/* 6223 */         return "OverlayPixelDataSequence";
/*      */       case 541065312:
/* 6225 */         return "OverlayMagnificationType";
/*      */       case 541065328:
/* 6227 */         return "OverlaySmoothingType";
/*      */       case 541065330:
/* 6229 */         return "OverlayOrImageMagnification";
/*      */       case 541065332:
/* 6231 */         return "MagnifyToNumberOfColumns";
/*      */       case 541065344:
/* 6233 */         return "OverlayForegroundDensity";
/*      */       case 541065346:
/* 6235 */         return "OverlayBackgroundDensity";
/*      */       case 541065360:
/* 6237 */         return "OverlayMode";
/*      */       case 541065472:
/* 6239 */         return "ThresholdDensity";
/*      */       case 541066496:
/* 6241 */         return "ReferencedImageBoxSequenceRetired";
/*      */       case 542113808:
/* 6243 */         return "PresentationLUTSequence";
/*      */       case 542113824:
/* 6245 */         return "PresentationLUTShape";
/*      */       case 542115072:
/* 6247 */         return "ReferencedPresentationLUTSequence";
/*      */       case 553648144:
/* 6249 */         return "PrintJobID";
/*      */       case 553648160:
/* 6251 */         return "ExecutionStatus";
/*      */       case 553648176:
/* 6253 */         return "ExecutionStatusInfo";
/*      */       case 553648192:
/* 6255 */         return "CreationDate";
/*      */       case 553648208:
/* 6257 */         return "CreationTime";
/*      */       case 553648240:
/* 6259 */         return "Originator";
/*      */       case 553648448:
/* 6261 */         return "DestinationAE";
/*      */       case 553648480:
/* 6263 */         return "OwnerID";
/*      */       case 553648496:
/* 6265 */         return "NumberOfFilms";
/*      */       case 553649408:
/* 6267 */         return "ReferencedPrintJobSequencePullStoredPrint";
/*      */       case 554696720:
/* 6269 */         return "PrinterStatus";
/*      */       case 554696736:
/* 6271 */         return "PrinterStatusInfo";
/*      */       case 554696752:
/* 6273 */         return "PrinterName";
/*      */       case 554696857:
/* 6275 */         return "PrintQueueID";
/*      */       case 555745296:
/* 6277 */         return "QueueStatus";
/*      */       case 555745360:
/* 6279 */         return "PrintJobDescriptionSequence";
/*      */       case 555745392:
/* 6281 */         return "ReferencedPrintJobSequence";
/*      */       case 556793872:
/* 6283 */         return "PrintManagementCapabilitiesSequence";
/*      */       case 556793877:
/* 6285 */         return "PrinterCharacteristicsSequence";
/*      */       case 556793904:
/* 6287 */         return "FilmBoxContentSequence";
/*      */       case 556793920:
/* 6289 */         return "ImageBoxContentSequence";
/*      */       case 556793936:
/* 6291 */         return "AnnotationContentSequence";
/*      */       case 556793952:
/* 6293 */         return "ImageOverlayBoxContentSequence";
/*      */       case 556793984:
/* 6295 */         return "PresentationLUTContentSequence";
/*      */       case 556794016:
/* 6297 */         return "ProposedStudySequence";
/*      */       case 556794048:
/* 6299 */         return "OriginalImageSequence";
/*      */       case 570425345:
/* 6301 */         return "LabelUsingInformationExtractedFromInstances";
/*      */       case 570425346:
/* 6303 */         return "LabelText";
/*      */       case 570425347:
/* 6305 */         return "LabelStyleSelection";
/*      */       case 570425348:
/* 6307 */         return "MediaDisposition";
/*      */       case 570425349:
/* 6309 */         return "BarcodeValue";
/*      */       case 570425350:
/* 6311 */         return "BarcodeSymbology";
/*      */       case 570425351:
/* 6313 */         return "AllowMediaSplitting";
/*      */       case 570425352:
/* 6315 */         return "IncludeNonDICOMObjects";
/*      */       case 570425353:
/* 6317 */         return "IncludeDisplayApplication";
/*      */       case 570425354:
/* 6319 */         return "PreserveCompositeInstancesAfterMediaCreation";
/*      */       case 570425355:
/* 6321 */         return "TotalNumberOfPiecesOfMediaCreated";
/*      */       case 570425356:
/* 6323 */         return "RequestedMediaApplicationProfile";
/*      */       case 570425357:
/* 6325 */         return "ReferencedStorageMediaSequence";
/*      */       case 570425358:
/* 6327 */         return "FailureAttributes";
/*      */       case 570425359:
/* 6329 */         return "AllowLossyCompression";
/*      */       case 570425376:
/* 6331 */         return "RequestPriority";
/*      */       case 805437442:
/* 6333 */         return "RTImageLabel";
/*      */       case 805437443:
/* 6335 */         return "RTImageName";
/*      */       case 805437444:
/* 6337 */         return "RTImageDescription";
/*      */       case 805437450:
/* 6339 */         return "ReportedValuesOrigin";
/*      */       case 805437452:
/* 6341 */         return "RTImagePlane";
/*      */       case 805437453:
/* 6343 */         return "XRayImageReceptorTranslation";
/*      */       case 805437454:
/* 6345 */         return "XRayImageReceptorAngle";
/*      */       case 805437456:
/* 6347 */         return "RTImageOrientation";
/*      */       case 805437457:
/* 6349 */         return "ImagePlanePixelSpacing";
/*      */       case 805437458:
/* 6351 */         return "RTImagePosition";
/*      */       case 805437472:
/* 6353 */         return "RadiationMachineName";
/*      */       case 805437474:
/* 6355 */         return "RadiationMachineSAD";
/*      */       case 805437476:
/* 6357 */         return "RadiationMachineSSD";
/*      */       case 805437478:
/* 6359 */         return "RTImageSID";
/*      */       case 805437480:
/* 6361 */         return "SourceToReferenceObjectDistance";
/*      */       case 805437481:
/* 6363 */         return "FractionNumber";
/*      */       case 805437488:
/* 6365 */         return "ExposureSequence";
/*      */       case 805437490:
/* 6367 */         return "MetersetExposure";
/*      */       case 805437492:
/* 6369 */         return "DiaphragmPosition";
/*      */       case 805437504:
/* 6371 */         return "FluenceMapSequence";
/*      */       case 805437505:
/* 6373 */         return "FluenceDataSource";
/*      */       case 805437506:
/* 6375 */         return "FluenceDataScale";
/*      */       case 805437520:
/* 6377 */         return "PrimaryFluenceModeSequence";
/*      */       case 805437521:
/* 6379 */         return "FluenceMode";
/*      */       case 805437522:
/* 6381 */         return "FluenceModeID";
/*      */       case 805568513:
/* 6383 */         return "DVHType";
/*      */       case 805568514:
/* 6385 */         return "DoseUnits";
/*      */       case 805568516:
/* 6387 */         return "DoseType";
/*      */       case 805568517:
/* 6389 */         return "SpatialTransformOfDose";
/*      */       case 805568518:
/* 6391 */         return "DoseComment";
/*      */       case 805568520:
/* 6393 */         return "NormalizationPoint";
/*      */       case 805568522:
/* 6395 */         return "DoseSummationType";
/*      */       case 805568524:
/* 6397 */         return "GridFrameOffsetVector";
/*      */       case 805568526:
/* 6399 */         return "DoseGridScaling";
/*      */       case 805568528:
/* 6401 */         return "RTDoseROISequence";
/*      */       case 805568530:
/* 6403 */         return "DoseValue";
/*      */       case 805568532:
/* 6405 */         return "TissueHeterogeneityCorrection";
/*      */       case 805568576:
/* 6407 */         return "DVHNormalizationPoint";
/*      */       case 805568578:
/* 6409 */         return "DVHNormalizationDoseValue";
/*      */       case 805568592:
/* 6411 */         return "DVHSequence";
/*      */       case 805568594:
/* 6413 */         return "DVHDoseScaling";
/*      */       case 805568596:
/* 6415 */         return "DVHVolumeUnits";
/*      */       case 805568598:
/* 6417 */         return "DVHNumberOfBins";
/*      */       case 805568600:
/* 6419 */         return "DVHData";
/*      */       case 805568608:
/* 6421 */         return "DVHReferencedROISequence";
/*      */       case 805568610:
/* 6423 */         return "DVHROIContributionType";
/*      */       case 805568624:
/* 6425 */         return "DVHMinimumDose";
/*      */       case 805568626:
/* 6427 */         return "DVHMaximumDose";
/*      */       case 805568628:
/* 6429 */         return "DVHMeanDose";
/*      */       case 805699586:
/* 6431 */         return "StructureSetLabel";
/*      */       case 805699588:
/* 6433 */         return "StructureSetName";
/*      */       case 805699590:
/* 6435 */         return "StructureSetDescription";
/*      */       case 805699592:
/* 6437 */         return "StructureSetDate";
/*      */       case 805699593:
/* 6439 */         return "StructureSetTime";
/*      */       case 805699600:
/* 6441 */         return "ReferencedFrameOfReferenceSequence";
/*      */       case 805699602:
/* 6443 */         return "RTReferencedStudySequence";
/*      */       case 805699604:
/* 6445 */         return "RTReferencedSeriesSequence";
/*      */       case 805699606:
/* 6447 */         return "ContourImageSequence";
/*      */       case 805699608:
/* 6449 */         return "PredecessorStructureSetSequence";
/*      */       case 805699616:
/* 6451 */         return "StructureSetROISequence";
/*      */       case 805699618:
/* 6453 */         return "ROINumber";
/*      */       case 805699620:
/* 6455 */         return "ReferencedFrameOfReferenceUID";
/*      */       case 805699622:
/* 6457 */         return "ROIName";
/*      */       case 805699624:
/* 6459 */         return "ROIDescription";
/*      */       case 805699626:
/* 6461 */         return "ROIDisplayColor";
/*      */       case 805699628:
/* 6463 */         return "ROIVolume";
/*      */       case 805699632:
/* 6465 */         return "RTRelatedROISequence";
/*      */       case 805699635:
/* 6467 */         return "RTROIRelationship";
/*      */       case 805699638:
/* 6469 */         return "ROIGenerationAlgorithm";
/*      */       case 805699640:
/* 6471 */         return "ROIGenerationDescription";
/*      */       case 805699641:
/* 6473 */         return "ROIContourSequence";
/*      */       case 805699648:
/* 6475 */         return "ContourSequence";
/*      */       case 805699650:
/* 6477 */         return "ContourGeometricType";
/*      */       case 805699652:
/* 6479 */         return "ContourSlabThickness";
/*      */       case 805699653:
/* 6481 */         return "ContourOffsetVector";
/*      */       case 805699654:
/* 6483 */         return "NumberOfContourPoints";
/*      */       case 805699656:
/* 6485 */         return "ContourNumber";
/*      */       case 805699657:
/* 6487 */         return "AttachedContours";
/*      */       case 805699664:
/* 6489 */         return "ContourData";
/*      */       case 805699712:
/* 6491 */         return "RTROIObservationsSequence";
/*      */       case 805699714:
/* 6493 */         return "ObservationNumber";
/*      */       case 805699716:
/* 6495 */         return "ReferencedROINumber";
/*      */       case 805699717:
/* 6497 */         return "ROIObservationLabel";
/*      */       case 805699718:
/* 6499 */         return "RTROIIdentificationCodeSequence";
/*      */       case 805699720:
/* 6501 */         return "ROIObservationDescription";
/*      */       case 805699744:
/* 6503 */         return "RelatedRTROIObservationsSequence";
/*      */       case 805699748:
/* 6505 */         return "RTROIInterpretedType";
/*      */       case 805699750:
/* 6507 */         return "ROIInterpreter";
/*      */       case 805699760:
/* 6509 */         return "ROIPhysicalPropertiesSequence";
/*      */       case 805699762:
/* 6511 */         return "ROIPhysicalProperty";
/*      */       case 805699764:
/* 6513 */         return "ROIPhysicalPropertyValue";
/*      */       case 805699766:
/* 6515 */         return "ROIElementalCompositionSequence";
/*      */       case 805699767:
/* 6517 */         return "ROIElementalCompositionAtomicNumber";
/*      */       case 805699768:
/* 6519 */         return "ROIElementalCompositionAtomicMassFraction";
/*      */       case 805699769:
/* 6521 */         return "AdditionalRTROIIdentificationCodeSequence";
/*      */       case 805699776:
/* 6523 */         return "FrameOfReferenceRelationshipSequence";
/*      */       case 805699778:
/* 6525 */         return "RelatedFrameOfReferenceUID";
/*      */       case 805699780:
/* 6527 */         return "FrameOfReferenceTransformationType";
/*      */       case 805699782:
/* 6529 */         return "FrameOfReferenceTransformationMatrix";
/*      */       case 805699784:
/* 6531 */         return "FrameOfReferenceTransformationComment";
/*      */       case 805830672:
/* 6533 */         return "MeasuredDoseReferenceSequence";
/*      */       case 805830674:
/* 6535 */         return "MeasuredDoseDescription";
/*      */       case 805830676:
/* 6537 */         return "MeasuredDoseType";
/*      */       case 805830678:
/* 6539 */         return "MeasuredDoseValue";
/*      */       case 805830688:
/* 6541 */         return "TreatmentSessionBeamSequence";
/*      */       case 805830689:
/* 6543 */         return "TreatmentSessionIonBeamSequence";
/*      */       case 805830690:
/* 6545 */         return "CurrentFractionNumber";
/*      */       case 805830692:
/* 6547 */         return "TreatmentControlPointDate";
/*      */       case 805830693:
/* 6549 */         return "TreatmentControlPointTime";
/*      */       case 805830698:
/* 6551 */         return "TreatmentTerminationStatus";
/*      */       case 805830699:
/* 6553 */         return "TreatmentTerminationCode";
/*      */       case 805830700:
/* 6555 */         return "TreatmentVerificationStatus";
/*      */       case 805830704:
/* 6557 */         return "ReferencedTreatmentRecordSequence";
/*      */       case 805830706:
/* 6559 */         return "SpecifiedPrimaryMeterset";
/*      */       case 805830707:
/* 6561 */         return "SpecifiedSecondaryMeterset";
/*      */       case 805830710:
/* 6563 */         return "DeliveredPrimaryMeterset";
/*      */       case 805830711:
/* 6565 */         return "DeliveredSecondaryMeterset";
/*      */       case 805830714:
/* 6567 */         return "SpecifiedTreatmentTime";
/*      */       case 805830715:
/* 6569 */         return "DeliveredTreatmentTime";
/*      */       case 805830720:
/* 6571 */         return "ControlPointDeliverySequence";
/*      */       case 805830721:
/* 6573 */         return "IonControlPointDeliverySequence";
/*      */       case 805830722:
/* 6575 */         return "SpecifiedMeterset";
/*      */       case 805830724:
/* 6577 */         return "DeliveredMeterset";
/*      */       case 805830725:
/* 6579 */         return "MetersetRateSet";
/*      */       case 805830726:
/* 6581 */         return "MetersetRateDelivered";
/*      */       case 805830727:
/* 6583 */         return "ScanSpotMetersetsDelivered";
/*      */       case 805830728:
/* 6585 */         return "DoseRateDelivered";
/*      */       case 805830736:
/* 6587 */         return "TreatmentSummaryCalculatedDoseReferenceSequence";
/*      */       case 805830738:
/* 6589 */         return "CumulativeDoseToDoseReference";
/*      */       case 805830740:
/* 6591 */         return "FirstTreatmentDate";
/*      */       case 805830742:
/* 6593 */         return "MostRecentTreatmentDate";
/*      */       case 805830746:
/* 6595 */         return "NumberOfFractionsDelivered";
/*      */       case 805830752:
/* 6597 */         return "OverrideSequence";
/*      */       case 805830753:
/* 6599 */         return "ParameterSequencePointer";
/*      */       case 805830754:
/* 6601 */         return "OverrideParameterPointer";
/*      */       case 805830755:
/* 6603 */         return "ParameterItemIndex";
/*      */       case 805830756:
/* 6605 */         return "MeasuredDoseReferenceNumber";
/*      */       case 805830757:
/* 6607 */         return "ParameterPointer";
/*      */       case 805830758:
/* 6609 */         return "OverrideReason";
/*      */       case 805830760:
/* 6611 */         return "CorrectedParameterSequence";
/*      */       case 805830762:
/* 6613 */         return "CorrectionValue";
/*      */       case 805830768:
/* 6615 */         return "CalculatedDoseReferenceSequence";
/*      */       case 805830770:
/* 6617 */         return "CalculatedDoseReferenceNumber";
/*      */       case 805830772:
/* 6619 */         return "CalculatedDoseReferenceDescription";
/*      */       case 805830774:
/* 6621 */         return "CalculatedDoseReferenceDoseValue";
/*      */       case 805830776:
/* 6623 */         return "StartMeterset";
/*      */       case 805830778:
/* 6625 */         return "EndMeterset";
/*      */       case 805830784:
/* 6627 */         return "ReferencedMeasuredDoseReferenceSequence";
/*      */       case 805830786:
/* 6629 */         return "ReferencedMeasuredDoseReferenceNumber";
/*      */       case 805830800:
/* 6631 */         return "ReferencedCalculatedDoseReferenceSequence";
/*      */       case 805830802:
/* 6633 */         return "ReferencedCalculatedDoseReferenceNumber";
/*      */       case 805830816:
/* 6635 */         return "BeamLimitingDeviceLeafPairsSequence";
/*      */       case 805830832:
/* 6637 */         return "RecordedWedgeSequence";
/*      */       case 805830848:
/* 6639 */         return "RecordedCompensatorSequence";
/*      */       case 805830864:
/* 6641 */         return "RecordedBlockSequence";
/*      */       case 805830880:
/* 6643 */         return "TreatmentSummaryMeasuredDoseReferenceSequence";
/*      */       case 805830896:
/* 6645 */         return "RecordedSnoutSequence";
/*      */       case 805830898:
/* 6647 */         return "RecordedRangeShifterSequence";
/*      */       case 805830900:
/* 6649 */         return "RecordedLateralSpreadingDeviceSequence";
/*      */       case 805830902:
/* 6651 */         return "RecordedRangeModulatorSequence";
/*      */       case 805830912:
/* 6653 */         return "RecordedSourceSequence";
/*      */       case 805830917:
/* 6655 */         return "SourceSerialNumber";
/*      */       case 805830928:
/* 6657 */         return "TreatmentSessionApplicationSetupSequence";
/*      */       case 805830934:
/* 6659 */         return "ApplicationSetupCheck";
/*      */       case 805830944:
/* 6661 */         return "RecordedBrachyAccessoryDeviceSequence";
/*      */       case 805830946:
/* 6663 */         return "ReferencedBrachyAccessoryDeviceNumber";
/*      */       case 805830960:
/* 6665 */         return "RecordedChannelSequence";
/*      */       case 805830962:
/* 6667 */         return "SpecifiedChannelTotalTime";
/*      */       case 805830964:
/* 6669 */         return "DeliveredChannelTotalTime";
/*      */       case 805830966:
/* 6671 */         return "SpecifiedNumberOfPulses";
/*      */       case 805830968:
/* 6673 */         return "DeliveredNumberOfPulses";
/*      */       case 805830970:
/* 6675 */         return "SpecifiedPulseRepetitionInterval";
/*      */       case 805830972:
/* 6677 */         return "DeliveredPulseRepetitionInterval";
/*      */       case 805830976:
/* 6679 */         return "RecordedSourceApplicatorSequence";
/*      */       case 805830978:
/* 6681 */         return "ReferencedSourceApplicatorNumber";
/*      */       case 805830992:
/* 6683 */         return "RecordedChannelShieldSequence";
/*      */       case 805830994:
/* 6685 */         return "ReferencedChannelShieldNumber";
/*      */       case 805831008:
/* 6687 */         return "BrachyControlPointDeliveredSequence";
/*      */       case 805831010:
/* 6689 */         return "SafePositionExitDate";
/*      */       case 805831012:
/* 6691 */         return "SafePositionExitTime";
/*      */       case 805831014:
/* 6693 */         return "SafePositionReturnDate";
/*      */       case 805831016:
/* 6695 */         return "SafePositionReturnTime";
/*      */       case 805831025:
/* 6697 */         return "PulseSpecificBrachyControlPointDeliveredSequence";
/*      */       case 805831026:
/* 6699 */         return "PulseNumber";
/*      */       case 805831027:
/* 6701 */         return "BrachyPulseControlPointDeliveredSequence";
/*      */       case 805831168:
/* 6703 */         return "CurrentTreatmentStatus";
/*      */       case 805831170:
/* 6705 */         return "TreatmentStatusComment";
/*      */       case 805831200:
/* 6707 */         return "FractionGroupSummarySequence";
/*      */       case 805831203:
/* 6709 */         return "ReferencedFractionNumber";
/*      */       case 805831204:
/* 6711 */         return "FractionGroupType";
/*      */       case 805831216:
/* 6713 */         return "BeamStopperPosition";
/*      */       case 805831232:
/* 6715 */         return "FractionStatusSummarySequence";
/*      */       case 805831248:
/* 6717 */         return "TreatmentDate";
/*      */       case 805831249:
/* 6719 */         return "TreatmentTime";
/*      */       case 805961730:
/* 6721 */         return "RTPlanLabel";
/*      */       case 805961731:
/* 6723 */         return "RTPlanName";
/*      */       case 805961732:
/* 6725 */         return "RTPlanDescription";
/*      */       case 805961734:
/* 6727 */         return "RTPlanDate";
/*      */       case 805961735:
/* 6729 */         return "RTPlanTime";
/*      */       case 805961737:
/* 6731 */         return "TreatmentProtocols";
/*      */       case 805961738:
/* 6733 */         return "PlanIntent";
/*      */       case 805961739:
/* 6735 */         return "TreatmentSites";
/*      */       case 805961740:
/* 6737 */         return "RTPlanGeometry";
/*      */       case 805961742:
/* 6739 */         return "PrescriptionDescription";
/*      */       case 805961744:
/* 6741 */         return "DoseReferenceSequence";
/*      */       case 805961746:
/* 6743 */         return "DoseReferenceNumber";
/*      */       case 805961747:
/* 6745 */         return "DoseReferenceUID";
/*      */       case 805961748:
/* 6747 */         return "DoseReferenceStructureType";
/*      */       case 805961749:
/* 6749 */         return "NominalBeamEnergyUnit";
/*      */       case 805961750:
/* 6751 */         return "DoseReferenceDescription";
/*      */       case 805961752:
/* 6753 */         return "DoseReferencePointCoordinates";
/*      */       case 805961754:
/* 6755 */         return "NominalPriorDose";
/*      */       case 805961760:
/* 6757 */         return "DoseReferenceType";
/*      */       case 805961761:
/* 6759 */         return "ConstraintWeight";
/*      */       case 805961762:
/* 6761 */         return "DeliveryWarningDose";
/*      */       case 805961763:
/* 6763 */         return "DeliveryMaximumDose";
/*      */       case 805961765:
/* 6765 */         return "TargetMinimumDose";
/*      */       case 805961766:
/* 6767 */         return "TargetPrescriptionDose";
/*      */       case 805961767:
/* 6769 */         return "TargetMaximumDose";
/*      */       case 805961768:
/* 6771 */         return "TargetUnderdoseVolumeFraction";
/*      */       case 805961770:
/* 6773 */         return "OrganAtRiskFullVolumeDose";
/*      */       case 805961771:
/* 6775 */         return "OrganAtRiskLimitDose";
/*      */       case 805961772:
/* 6777 */         return "OrganAtRiskMaximumDose";
/*      */       case 805961773:
/* 6779 */         return "OrganAtRiskOverdoseVolumeFraction";
/*      */       case 805961792:
/* 6781 */         return "ToleranceTableSequence";
/*      */       case 805961794:
/* 6783 */         return "ToleranceTableNumber";
/*      */       case 805961795:
/* 6785 */         return "ToleranceTableLabel";
/*      */       case 805961796:
/* 6787 */         return "GantryAngleTolerance";
/*      */       case 805961798:
/* 6789 */         return "BeamLimitingDeviceAngleTolerance";
/*      */       case 805961800:
/* 6791 */         return "BeamLimitingDeviceToleranceSequence";
/*      */       case 805961802:
/* 6793 */         return "BeamLimitingDevicePositionTolerance";
/*      */       case 805961803:
/* 6795 */         return "SnoutPositionTolerance";
/*      */       case 805961804:
/* 6797 */         return "PatientSupportAngleTolerance";
/*      */       case 805961806:
/* 6799 */         return "TableTopEccentricAngleTolerance";
/*      */       case 805961807:
/* 6801 */         return "TableTopPitchAngleTolerance";
/*      */       case 805961808:
/* 6803 */         return "TableTopRollAngleTolerance";
/*      */       case 805961809:
/* 6805 */         return "TableTopVerticalPositionTolerance";
/*      */       case 805961810:
/* 6807 */         return "TableTopLongitudinalPositionTolerance";
/*      */       case 805961811:
/* 6809 */         return "TableTopLateralPositionTolerance";
/*      */       case 805961813:
/* 6811 */         return "RTPlanRelationship";
/*      */       case 805961840:
/* 6813 */         return "FractionGroupSequence";
/*      */       case 805961841:
/* 6815 */         return "FractionGroupNumber";
/*      */       case 805961842:
/* 6817 */         return "FractionGroupDescription";
/*      */       case 805961848:
/* 6819 */         return "NumberOfFractionsPlanned";
/*      */       case 805961849:
/* 6821 */         return "NumberOfFractionPatternDigitsPerDay";
/*      */       case 805961850:
/* 6823 */         return "RepeatFractionCycleLength";
/*      */       case 805961851:
/* 6825 */         return "FractionPattern";
/*      */       case 805961856:
/* 6827 */         return "NumberOfBeams";
/*      */       case 805961858:
/* 6829 */         return "BeamDoseSpecificationPoint";
/*      */       case 805961860:
/* 6831 */         return "BeamDose";
/*      */       case 805961862:
/* 6833 */         return "BeamMeterset";
/*      */       case 805961864:
/* 6835 */         return "BeamDosePointDepth";
/*      */       case 805961865:
/* 6837 */         return "BeamDosePointEquivalentDepth";
/*      */       case 805961866:
/* 6839 */         return "BeamDosePointSSD";
/*      */       case 805961867:
/* 6841 */         return "BeamDoseMeaning";
/*      */       case 805961868:
/* 6843 */         return "BeamDoseVerificationControlPointSequence";
/*      */       case 805961869:
/* 6845 */         return "AverageBeamDosePointDepth";
/*      */       case 805961870:
/* 6847 */         return "AverageBeamDosePointEquivalentDepth";
/*      */       case 805961871:
/* 6849 */         return "AverageBeamDosePointSSD";
/*      */       case 805961888:
/* 6851 */         return "NumberOfBrachyApplicationSetups";
/*      */       case 805961890:
/* 6853 */         return "BrachyApplicationSetupDoseSpecificationPoint";
/*      */       case 805961892:
/* 6855 */         return "BrachyApplicationSetupDose";
/*      */       case 805961904:
/* 6857 */         return "BeamSequence";
/*      */       case 805961906:
/* 6859 */         return "TreatmentMachineName";
/*      */       case 805961907:
/* 6861 */         return "PrimaryDosimeterUnit";
/*      */       case 805961908:
/* 6863 */         return "SourceAxisDistance";
/*      */       case 805961910:
/* 6865 */         return "BeamLimitingDeviceSequence";
/*      */       case 805961912:
/* 6867 */         return "RTBeamLimitingDeviceType";
/*      */       case 805961914:
/* 6869 */         return "SourceToBeamLimitingDeviceDistance";
/*      */       case 805961915:
/* 6871 */         return "IsocenterToBeamLimitingDeviceDistance";
/*      */       case 805961916:
/* 6873 */         return "NumberOfLeafJawPairs";
/*      */       case 805961918:
/* 6875 */         return "LeafPositionBoundaries";
/*      */       case 805961920:
/* 6877 */         return "BeamNumber";
/*      */       case 805961922:
/* 6879 */         return "BeamName";
/*      */       case 805961923:
/* 6881 */         return "BeamDescription";
/*      */       case 805961924:
/* 6883 */         return "BeamType";
/*      */       case 805961925:
/* 6885 */         return "BeamDeliveryDurationLimit";
/*      */       case 805961926:
/* 6887 */         return "RadiationType";
/*      */       case 805961927:
/* 6889 */         return "HighDoseTechniqueType";
/*      */       case 805961928:
/* 6891 */         return "ReferenceImageNumber";
/*      */       case 805961930:
/* 6893 */         return "PlannedVerificationImageSequence";
/*      */       case 805961932:
/* 6895 */         return "ImagingDeviceSpecificAcquisitionParameters";
/*      */       case 805961934:
/* 6897 */         return "TreatmentDeliveryType";
/*      */       case 805961936:
/* 6899 */         return "NumberOfWedges";
/*      */       case 805961937:
/* 6901 */         return "WedgeSequence";
/*      */       case 805961938:
/* 6903 */         return "WedgeNumber";
/*      */       case 805961939:
/* 6905 */         return "WedgeType";
/*      */       case 805961940:
/* 6907 */         return "WedgeID";
/*      */       case 805961941:
/* 6909 */         return "WedgeAngle";
/*      */       case 805961942:
/* 6911 */         return "WedgeFactor";
/*      */       case 805961943:
/* 6913 */         return "TotalWedgeTrayWaterEquivalentThickness";
/*      */       case 805961944:
/* 6915 */         return "WedgeOrientation";
/*      */       case 805961945:
/* 6917 */         return "IsocenterToWedgeTrayDistance";
/*      */       case 805961946:
/* 6919 */         return "SourceToWedgeTrayDistance";
/*      */       case 805961947:
/* 6921 */         return "WedgeThinEdgePosition";
/*      */       case 805961948:
/* 6923 */         return "BolusID";
/*      */       case 805961949:
/* 6925 */         return "BolusDescription";
/*      */       case 805961950:
/* 6927 */         return "EffectiveWedgeAngle";
/*      */       case 805961952:
/* 6929 */         return "NumberOfCompensators";
/*      */       case 805961953:
/* 6931 */         return "MaterialID";
/*      */       case 805961954:
/* 6933 */         return "TotalCompensatorTrayFactor";
/*      */       case 805961955:
/* 6935 */         return "CompensatorSequence";
/*      */       case 805961956:
/* 6937 */         return "CompensatorNumber";
/*      */       case 805961957:
/* 6939 */         return "CompensatorID";
/*      */       case 805961958:
/* 6941 */         return "SourceToCompensatorTrayDistance";
/*      */       case 805961959:
/* 6943 */         return "CompensatorRows";
/*      */       case 805961960:
/* 6945 */         return "CompensatorColumns";
/*      */       case 805961961:
/* 6947 */         return "CompensatorPixelSpacing";
/*      */       case 805961962:
/* 6949 */         return "CompensatorPosition";
/*      */       case 805961963:
/* 6951 */         return "CompensatorTransmissionData";
/*      */       case 805961964:
/* 6953 */         return "CompensatorThicknessData";
/*      */       case 805961965:
/* 6955 */         return "NumberOfBoli";
/*      */       case 805961966:
/* 6957 */         return "CompensatorType";
/*      */       case 805961967:
/* 6959 */         return "CompensatorTrayID";
/*      */       case 805961968:
/* 6961 */         return "NumberOfBlocks";
/*      */       case 805961970:
/* 6963 */         return "TotalBlockTrayFactor";
/*      */       case 805961971:
/* 6965 */         return "TotalBlockTrayWaterEquivalentThickness";
/*      */       case 805961972:
/* 6967 */         return "BlockSequence";
/*      */       case 805961973:
/* 6969 */         return "BlockTrayID";
/*      */       case 805961974:
/* 6971 */         return "SourceToBlockTrayDistance";
/*      */       case 805961975:
/* 6973 */         return "IsocenterToBlockTrayDistance";
/*      */       case 805961976:
/* 6975 */         return "BlockType";
/*      */       case 805961977:
/* 6977 */         return "AccessoryCode";
/*      */       case 805961978:
/* 6979 */         return "BlockDivergence";
/*      */       case 805961979:
/* 6981 */         return "BlockMountingPosition";
/*      */       case 805961980:
/* 6983 */         return "BlockNumber";
/*      */       case 805961982:
/* 6985 */         return "BlockName";
/*      */       case 805961984:
/* 6987 */         return "BlockThickness";
/*      */       case 805961986:
/* 6989 */         return "BlockTransmission";
/*      */       case 805961988:
/* 6991 */         return "BlockNumberOfPoints";
/*      */       case 805961990:
/* 6993 */         return "BlockData";
/*      */       case 805961991:
/* 6995 */         return "ApplicatorSequence";
/*      */       case 805961992:
/* 6997 */         return "ApplicatorID";
/*      */       case 805961993:
/* 6999 */         return "ApplicatorType";
/*      */       case 805961994:
/* 7001 */         return "ApplicatorDescription";
/*      */       case 805961996:
/* 7003 */         return "CumulativeDoseReferenceCoefficient";
/*      */       case 805961998:
/* 7005 */         return "FinalCumulativeMetersetWeight";
/*      */       case 805962000:
/* 7007 */         return "NumberOfControlPoints";
/*      */       case 805962001:
/* 7009 */         return "ControlPointSequence";
/*      */       case 805962002:
/* 7011 */         return "ControlPointIndex";
/*      */       case 805962004:
/* 7013 */         return "NominalBeamEnergy";
/*      */       case 805962005:
/* 7015 */         return "DoseRateSet";
/*      */       case 805962006:
/* 7017 */         return "WedgePositionSequence";
/*      */       case 805962008:
/* 7019 */         return "WedgePosition";
/*      */       case 805962010:
/* 7021 */         return "BeamLimitingDevicePositionSequence";
/*      */       case 805962012:
/* 7023 */         return "LeafJawPositions";
/*      */       case 805962014:
/* 7025 */         return "GantryAngle";
/*      */       case 805962015:
/* 7027 */         return "GantryRotationDirection";
/*      */       case 805962016:
/* 7029 */         return "BeamLimitingDeviceAngle";
/*      */       case 805962017:
/* 7031 */         return "BeamLimitingDeviceRotationDirection";
/*      */       case 805962018:
/* 7033 */         return "PatientSupportAngle";
/*      */       case 805962019:
/* 7035 */         return "PatientSupportRotationDirection";
/*      */       case 805962020:
/* 7037 */         return "TableTopEccentricAxisDistance";
/*      */       case 805962021:
/* 7039 */         return "TableTopEccentricAngle";
/*      */       case 805962022:
/* 7041 */         return "TableTopEccentricRotationDirection";
/*      */       case 805962024:
/* 7043 */         return "TableTopVerticalPosition";
/*      */       case 805962025:
/* 7045 */         return "TableTopLongitudinalPosition";
/*      */       case 805962026:
/* 7047 */         return "TableTopLateralPosition";
/*      */       case 805962028:
/* 7049 */         return "IsocenterPosition";
/*      */       case 805962030:
/* 7051 */         return "SurfaceEntryPoint";
/*      */       case 805962032:
/* 7053 */         return "SourceToSurfaceDistance";
/*      */       case 805962036:
/* 7055 */         return "CumulativeMetersetWeight";
/*      */       case 805962048:
/* 7057 */         return "TableTopPitchAngle";
/*      */       case 805962050:
/* 7059 */         return "TableTopPitchRotationDirection";
/*      */       case 805962052:
/* 7061 */         return "TableTopRollAngle";
/*      */       case 805962054:
/* 7063 */         return "TableTopRollRotationDirection";
/*      */       case 805962056:
/* 7065 */         return "HeadFixationAngle";
/*      */       case 805962058:
/* 7067 */         return "GantryPitchAngle";
/*      */       case 805962060:
/* 7069 */         return "GantryPitchRotationDirection";
/*      */       case 805962062:
/* 7071 */         return "GantryPitchAngleTolerance";
/*      */       case 805962112:
/* 7073 */         return "PatientSetupSequence";
/*      */       case 805962114:
/* 7075 */         return "PatientSetupNumber";
/*      */       case 805962115:
/* 7077 */         return "PatientSetupLabel";
/*      */       case 805962116:
/* 7079 */         return "PatientAdditionalPosition";
/*      */       case 805962128:
/* 7081 */         return "FixationDeviceSequence";
/*      */       case 805962130:
/* 7083 */         return "FixationDeviceType";
/*      */       case 805962132:
/* 7085 */         return "FixationDeviceLabel";
/*      */       case 805962134:
/* 7087 */         return "FixationDeviceDescription";
/*      */       case 805962136:
/* 7089 */         return "FixationDevicePosition";
/*      */       case 805962137:
/* 7091 */         return "FixationDevicePitchAngle";
/*      */       case 805962138:
/* 7093 */         return "FixationDeviceRollAngle";
/*      */       case 805962144:
/* 7095 */         return "ShieldingDeviceSequence";
/*      */       case 805962146:
/* 7097 */         return "ShieldingDeviceType";
/*      */       case 805962148:
/* 7099 */         return "ShieldingDeviceLabel";
/*      */       case 805962150:
/* 7101 */         return "ShieldingDeviceDescription";
/*      */       case 805962152:
/* 7103 */         return "ShieldingDevicePosition";
/*      */       case 805962160:
/* 7105 */         return "SetupTechnique";
/*      */       case 805962162:
/* 7107 */         return "SetupTechniqueDescription";
/*      */       case 805962164:
/* 7109 */         return "SetupDeviceSequence";
/*      */       case 805962166:
/* 7111 */         return "SetupDeviceType";
/*      */       case 805962168:
/* 7113 */         return "SetupDeviceLabel";
/*      */       case 805962170:
/* 7115 */         return "SetupDeviceDescription";
/*      */       case 805962172:
/* 7117 */         return "SetupDeviceParameter";
/*      */       case 805962192:
/* 7119 */         return "SetupReferenceDescription";
/*      */       case 805962194:
/* 7121 */         return "TableTopVerticalSetupDisplacement";
/*      */       case 805962196:
/* 7123 */         return "TableTopLongitudinalSetupDisplacement";
/*      */       case 805962198:
/* 7125 */         return "TableTopLateralSetupDisplacement";
/*      */       case 805962240:
/* 7127 */         return "BrachyTreatmentTechnique";
/*      */       case 805962242:
/* 7129 */         return "BrachyTreatmentType";
/*      */       case 805962246:
/* 7131 */         return "TreatmentMachineSequence";
/*      */       case 805962256:
/* 7133 */         return "SourceSequence";
/*      */       case 805962258:
/* 7135 */         return "SourceNumber";
/*      */       case 805962260:
/* 7137 */         return "SourceType";
/*      */       case 805962262:
/* 7139 */         return "SourceManufacturer";
/*      */       case 805962264:
/* 7141 */         return "ActiveSourceDiameter";
/*      */       case 805962266:
/* 7143 */         return "ActiveSourceLength";
/*      */       case 805962267:
/* 7145 */         return "SourceModelID";
/*      */       case 805962268:
/* 7147 */         return "SourceDescription";
/*      */       case 805962274:
/* 7149 */         return "SourceEncapsulationNominalThickness";
/*      */       case 805962276:
/* 7151 */         return "SourceEncapsulationNominalTransmission";
/*      */       case 805962278:
/* 7153 */         return "SourceIsotopeName";
/*      */       case 805962280:
/* 7155 */         return "SourceIsotopeHalfLife";
/*      */       case 805962281:
/* 7157 */         return "SourceStrengthUnits";
/*      */       case 805962282:
/* 7159 */         return "ReferenceAirKermaRate";
/*      */       case 805962283:
/* 7161 */         return "SourceStrength";
/*      */       case 805962284:
/* 7163 */         return "SourceStrengthReferenceDate";
/*      */       case 805962286:
/* 7165 */         return "SourceStrengthReferenceTime";
/*      */       case 805962288:
/* 7167 */         return "ApplicationSetupSequence";
/*      */       case 805962290:
/* 7169 */         return "ApplicationSetupType";
/*      */       case 805962292:
/* 7171 */         return "ApplicationSetupNumber";
/*      */       case 805962294:
/* 7173 */         return "ApplicationSetupName";
/*      */       case 805962296:
/* 7175 */         return "ApplicationSetupManufacturer";
/*      */       case 805962304:
/* 7177 */         return "TemplateNumber";
/*      */       case 805962306:
/* 7179 */         return "TemplateType";
/*      */       case 805962308:
/* 7181 */         return "TemplateName";
/*      */       case 805962320:
/* 7183 */         return "TotalReferenceAirKerma";
/*      */       case 805962336:
/* 7185 */         return "BrachyAccessoryDeviceSequence";
/*      */       case 805962338:
/* 7187 */         return "BrachyAccessoryDeviceNumber";
/*      */       case 805962339:
/* 7189 */         return "BrachyAccessoryDeviceID";
/*      */       case 805962340:
/* 7191 */         return "BrachyAccessoryDeviceType";
/*      */       case 805962342:
/* 7193 */         return "BrachyAccessoryDeviceName";
/*      */       case 805962346:
/* 7195 */         return "BrachyAccessoryDeviceNominalThickness";
/*      */       case 805962348:
/* 7197 */         return "BrachyAccessoryDeviceNominalTransmission";
/*      */       case 805962368:
/* 7199 */         return "ChannelSequence";
/*      */       case 805962370:
/* 7201 */         return "ChannelNumber";
/*      */       case 805962372:
/* 7203 */         return "ChannelLength";
/*      */       case 805962374:
/* 7205 */         return "ChannelTotalTime";
/*      */       case 805962376:
/* 7207 */         return "SourceMovementType";
/*      */       case 805962378:
/* 7209 */         return "NumberOfPulses";
/*      */       case 805962380:
/* 7211 */         return "PulseRepetitionInterval";
/*      */       case 805962384:
/* 7213 */         return "SourceApplicatorNumber";
/*      */       case 805962385:
/* 7215 */         return "SourceApplicatorID";
/*      */       case 805962386:
/* 7217 */         return "SourceApplicatorType";
/*      */       case 805962388:
/* 7219 */         return "SourceApplicatorName";
/*      */       case 805962390:
/* 7221 */         return "SourceApplicatorLength";
/*      */       case 805962392:
/* 7223 */         return "SourceApplicatorManufacturer";
/*      */       case 805962396:
/* 7225 */         return "SourceApplicatorWallNominalThickness";
/*      */       case 805962398:
/* 7227 */         return "SourceApplicatorWallNominalTransmission";
/*      */       case 805962400:
/* 7229 */         return "SourceApplicatorStepSize";
/*      */       case 805962402:
/* 7231 */         return "TransferTubeNumber";
/*      */       case 805962404:
/* 7233 */         return "TransferTubeLength";
/*      */       case 805962416:
/* 7235 */         return "ChannelShieldSequence";
/*      */       case 805962418:
/* 7237 */         return "ChannelShieldNumber";
/*      */       case 805962419:
/* 7239 */         return "ChannelShieldID";
/*      */       case 805962420:
/* 7241 */         return "ChannelShieldName";
/*      */       case 805962424:
/* 7243 */         return "ChannelShieldNominalThickness";
/*      */       case 805962426:
/* 7245 */         return "ChannelShieldNominalTransmission";
/*      */       case 805962440:
/* 7247 */         return "FinalCumulativeTimeWeight";
/*      */       case 805962448:
/* 7249 */         return "BrachyControlPointSequence";
/*      */       case 805962450:
/* 7251 */         return "ControlPointRelativePosition";
/*      */       case 805962452:
/* 7253 */         return "ControlPoint3DPosition";
/*      */       case 805962454:
/* 7255 */         return "CumulativeTimeWeight";
/*      */       case 805962464:
/* 7257 */         return "CompensatorDivergence";
/*      */       case 805962465:
/* 7259 */         return "CompensatorMountingPosition";
/*      */       case 805962466:
/* 7261 */         return "SourceToCompensatorDistance";
/*      */       case 805962467:
/* 7263 */         return "TotalCompensatorTrayWaterEquivalentThickness";
/*      */       case 805962468:
/* 7265 */         return "IsocenterToCompensatorTrayDistance";
/*      */       case 805962469:
/* 7267 */         return "CompensatorColumnOffset";
/*      */       case 805962470:
/* 7269 */         return "IsocenterToCompensatorDistances";
/*      */       case 805962471:
/* 7271 */         return "CompensatorRelativeStoppingPowerRatio";
/*      */       case 805962472:
/* 7273 */         return "CompensatorMillingToolDiameter";
/*      */       case 805962474:
/* 7275 */         return "IonRangeCompensatorSequence";
/*      */       case 805962475:
/* 7277 */         return "CompensatorDescription";
/*      */       case 805962498:
/* 7279 */         return "RadiationMassNumber";
/*      */       case 805962500:
/* 7281 */         return "RadiationAtomicNumber";
/*      */       case 805962502:
/* 7283 */         return "RadiationChargeState";
/*      */       case 805962504:
/* 7285 */         return "ScanMode";
/*      */       case 805962506:
/* 7287 */         return "VirtualSourceAxisDistances";
/*      */       case 805962508:
/* 7289 */         return "SnoutSequence";
/*      */       case 805962509:
/* 7291 */         return "SnoutPosition";
/*      */       case 805962511:
/* 7293 */         return "SnoutID";
/*      */       case 805962514:
/* 7295 */         return "NumberOfRangeShifters";
/*      */       case 805962516:
/* 7297 */         return "RangeShifterSequence";
/*      */       case 805962518:
/* 7299 */         return "RangeShifterNumber";
/*      */       case 805962520:
/* 7301 */         return "RangeShifterID";
/*      */       case 805962528:
/* 7303 */         return "RangeShifterType";
/*      */       case 805962530:
/* 7305 */         return "RangeShifterDescription";
/*      */       case 805962544:
/* 7307 */         return "NumberOfLateralSpreadingDevices";
/*      */       case 805962546:
/* 7309 */         return "LateralSpreadingDeviceSequence";
/*      */       case 805962548:
/* 7311 */         return "LateralSpreadingDeviceNumber";
/*      */       case 805962550:
/* 7313 */         return "LateralSpreadingDeviceID";
/*      */       case 805962552:
/* 7315 */         return "LateralSpreadingDeviceType";
/*      */       case 805962554:
/* 7317 */         return "LateralSpreadingDeviceDescription";
/*      */       case 805962556:
/* 7319 */         return "LateralSpreadingDeviceWaterEquivalentThickness";
/*      */       case 805962560:
/* 7321 */         return "NumberOfRangeModulators";
/*      */       case 805962562:
/* 7323 */         return "RangeModulatorSequence";
/*      */       case 805962564:
/* 7325 */         return "RangeModulatorNumber";
/*      */       case 805962566:
/* 7327 */         return "RangeModulatorID";
/*      */       case 805962568:
/* 7329 */         return "RangeModulatorType";
/*      */       case 805962570:
/* 7331 */         return "RangeModulatorDescription";
/*      */       case 805962572:
/* 7333 */         return "BeamCurrentModulationID";
/*      */       case 805962576:
/* 7335 */         return "PatientSupportType";
/*      */       case 805962578:
/* 7337 */         return "PatientSupportID";
/*      */       case 805962580:
/* 7339 */         return "PatientSupportAccessoryCode";
/*      */       case 805962582:
/* 7341 */         return "FixationLightAzimuthalAngle";
/*      */       case 805962584:
/* 7343 */         return "FixationLightPolarAngle";
/*      */       case 805962586:
/* 7345 */         return "MetersetRate";
/*      */       case 805962592:
/* 7347 */         return "RangeShifterSettingsSequence";
/*      */       case 805962594:
/* 7349 */         return "RangeShifterSetting";
/*      */       case 805962596:
/* 7351 */         return "IsocenterToRangeShifterDistance";
/*      */       case 805962598:
/* 7353 */         return "RangeShifterWaterEquivalentThickness";
/*      */       case 805962608:
/* 7355 */         return "LateralSpreadingDeviceSettingsSequence";
/*      */       case 805962610:
/* 7357 */         return "LateralSpreadingDeviceSetting";
/*      */       case 805962612:
/* 7359 */         return "IsocenterToLateralSpreadingDeviceDistance";
/*      */       case 805962624:
/* 7361 */         return "RangeModulatorSettingsSequence";
/*      */       case 805962626:
/* 7363 */         return "RangeModulatorGatingStartValue";
/*      */       case 805962628:
/* 7365 */         return "RangeModulatorGatingStopValue";
/*      */       case 805962630:
/* 7367 */         return "RangeModulatorGatingStartWaterEquivalentThickness";
/*      */       case 805962632:
/* 7369 */         return "RangeModulatorGatingStopWaterEquivalentThickness";
/*      */       case 805962634:
/* 7371 */         return "IsocenterToRangeModulatorDistance";
/*      */       case 805962640:
/* 7373 */         return "ScanSpotTuneID";
/*      */       case 805962642:
/* 7375 */         return "NumberOfScanSpotPositions";
/*      */       case 805962644:
/* 7377 */         return "ScanSpotPositionMap";
/*      */       case 805962646:
/* 7379 */         return "ScanSpotMetersetWeights";
/*      */       case 805962648:
/* 7381 */         return "ScanningSpotSize";
/*      */       case 805962650:
/* 7383 */         return "NumberOfPaintings";
/*      */       case 805962656:
/* 7385 */         return "IonToleranceTableSequence";
/*      */       case 805962658:
/* 7387 */         return "IonBeamSequence";
/*      */       case 805962660:
/* 7389 */         return "IonBeamLimitingDeviceSequence";
/*      */       case 805962662:
/* 7391 */         return "IonBlockSequence";
/*      */       case 805962664:
/* 7393 */         return "IonControlPointSequence";
/*      */       case 805962666:
/* 7395 */         return "IonWedgeSequence";
/*      */       case 805962668:
/* 7397 */         return "IonWedgePositionSequence";
/*      */       case 805962753:
/* 7399 */         return "ReferencedSetupImageSequence";
/*      */       case 805962754:
/* 7401 */         return "SetupImageComment";
/*      */       case 805962768:
/* 7403 */         return "MotionSynchronizationSequence";
/*      */       case 805962770:
/* 7405 */         return "ControlPointOrientation";
/*      */       case 805962784:
/* 7407 */         return "GeneralAccessorySequence";
/*      */       case 805962785:
/* 7409 */         return "GeneralAccessoryID";
/*      */       case 805962786:
/* 7411 */         return "GeneralAccessoryDescription";
/*      */       case 805962787:
/* 7413 */         return "GeneralAccessoryType";
/*      */       case 805962788:
/* 7415 */         return "GeneralAccessoryNumber";
/*      */       case 805962789:
/* 7417 */         return "SourceToGeneralAccessoryDistance";
/*      */       case 805962801:
/* 7419 */         return "ApplicatorGeometrySequence";
/*      */       case 805962802:
/* 7421 */         return "ApplicatorApertureShape";
/*      */       case 805962803:
/* 7423 */         return "ApplicatorOpening";
/*      */       case 805962804:
/* 7425 */         return "ApplicatorOpeningX";
/*      */       case 805962805:
/* 7427 */         return "ApplicatorOpeningY";
/*      */       case 805962806:
/* 7429 */         return "SourceToApplicatorMountingPositionDistance";
/*      */       case 806092802:
/* 7431 */         return "ReferencedRTPlanSequence";
/*      */       case 806092804:
/* 7433 */         return "ReferencedBeamSequence";
/*      */       case 806092806:
/* 7435 */         return "ReferencedBeamNumber";
/*      */       case 806092807:
/* 7437 */         return "ReferencedReferenceImageNumber";
/*      */       case 806092808:
/* 7439 */         return "StartCumulativeMetersetWeight";
/*      */       case 806092809:
/* 7441 */         return "EndCumulativeMetersetWeight";
/*      */       case 806092810:
/* 7443 */         return "ReferencedBrachyApplicationSetupSequence";
/*      */       case 806092812:
/* 7445 */         return "ReferencedBrachyApplicationSetupNumber";
/*      */       case 806092814:
/* 7447 */         return "ReferencedSourceNumber";
/*      */       case 806092832:
/* 7449 */         return "ReferencedFractionGroupSequence";
/*      */       case 806092834:
/* 7451 */         return "ReferencedFractionGroupNumber";
/*      */       case 806092864:
/* 7453 */         return "ReferencedVerificationImageSequence";
/*      */       case 806092866:
/* 7455 */         return "ReferencedReferenceImageSequence";
/*      */       case 806092880:
/* 7457 */         return "ReferencedDoseReferenceSequence";
/*      */       case 806092881:
/* 7459 */         return "ReferencedDoseReferenceNumber";
/*      */       case 806092885:
/* 7461 */         return "BrachyReferencedDoseReferenceSequence";
/*      */       case 806092896:
/* 7463 */         return "ReferencedStructureSetSequence";
/*      */       case 806092906:
/* 7465 */         return "ReferencedPatientSetupNumber";
/*      */       case 806092928:
/* 7467 */         return "ReferencedDoseSequence";
/*      */       case 806092960:
/* 7469 */         return "ReferencedToleranceTableNumber";
/*      */       case 806092976:
/* 7471 */         return "ReferencedBolusSequence";
/*      */       case 806092992:
/* 7473 */         return "ReferencedWedgeNumber";
/*      */       case 806093008:
/* 7475 */         return "ReferencedCompensatorNumber";
/*      */       case 806093024:
/* 7477 */         return "ReferencedBlockNumber";
/*      */       case 806093040:
/* 7479 */         return "ReferencedControlPointIndex";
/*      */       case 806093042:
/* 7481 */         return "ReferencedControlPointSequence";
/*      */       case 806093044:
/* 7483 */         return "ReferencedStartControlPointIndex";
/*      */       case 806093046:
/* 7485 */         return "ReferencedStopControlPointIndex";
/*      */       case 806093056:
/* 7487 */         return "ReferencedRangeShifterNumber";
/*      */       case 806093058:
/* 7489 */         return "ReferencedLateralSpreadingDeviceNumber";
/*      */       case 806093060:
/* 7491 */         return "ReferencedRangeModulatorNumber";
/*      */       case 806223874:
/* 7493 */         return "ApprovalStatus";
/*      */       case 806223876:
/* 7495 */         return "ReviewDate";
/*      */       case 806223877:
/* 7497 */         return "ReviewTime";
/*      */       case 806223880:
/* 7499 */         return "ReviewerName";
/*      */       case 1073741840:
/* 7501 */         return "Arbitrary";
/*      */       case 1073758208:
/* 7503 */         return "TextComments";
/*      */       case 1074266176:
/* 7505 */         return "ResultsID";
/*      */       case 1074266178:
/* 7507 */         return "ResultsIDIssuer";
/*      */       case 1074266192:
/* 7509 */         return "ReferencedInterpretationSequence";
/*      */       case 1074266367:
/* 7511 */         return "ReportProductionStatusTrial";
/*      */       case 1074266368:
/* 7513 */         return "InterpretationRecordedDate";
/*      */       case 1074266369:
/* 7515 */         return "InterpretationRecordedTime";
/*      */       case 1074266370:
/* 7517 */         return "InterpretationRecorder";
/*      */       case 1074266371:
/* 7519 */         return "ReferenceToRecordedSound";
/*      */       case 1074266376:
/* 7521 */         return "InterpretationTranscriptionDate";
/*      */       case 1074266377:
/* 7523 */         return "InterpretationTranscriptionTime";
/*      */       case 1074266378:
/* 7525 */         return "InterpretationTranscriber";
/*      */       case 1074266379:
/* 7527 */         return "InterpretationText";
/*      */       case 1074266380:
/* 7529 */         return "InterpretationAuthor";
/*      */       case 1074266385:
/* 7531 */         return "InterpretationApproverSequence";
/*      */       case 1074266386:
/* 7533 */         return "InterpretationApprovalDate";
/*      */       case 1074266387:
/* 7535 */         return "InterpretationApprovalTime";
/*      */       case 1074266388:
/* 7537 */         return "PhysicianApprovingInterpretation";
/*      */       case 1074266389:
/* 7539 */         return "InterpretationDiagnosisDescription";
/*      */       case 1074266391:
/* 7541 */         return "InterpretationDiagnosisCodeSequence";
/*      */       case 1074266392:
/* 7543 */         return "ResultsDistributionListSequence";
/*      */       case 1074266393:
/* 7545 */         return "DistributionName";
/*      */       case 1074266394:
/* 7547 */         return "DistributionAddress";
/*      */       case 1074266624:
/* 7549 */         return "InterpretationID";
/*      */       case 1074266626:
/* 7551 */         return "InterpretationIDIssuer";
/*      */       case 1074266640:
/* 7553 */         return "InterpretationTypeID";
/*      */       case 1074266642:
/* 7555 */         return "InterpretationStatusID";
/*      */       case 1074266880:
/* 7557 */         return "Impressions";
/*      */       case 1074282496:
/* 7559 */         return "ResultsComments";
/*      */       case 1074790401:
/* 7561 */         return "LowEnergyDetectors";
/*      */       case 1074790402:
/* 7563 */         return "HighEnergyDetectors";
/*      */       case 1074790404:
/* 7565 */         return "DetectorGeometrySequence";
/*      */       case 1074794497:
/* 7567 */         return "ThreatROIVoxelSequence";
/*      */       case 1074794500:
/* 7569 */         return "ThreatROIBase";
/*      */       case 1074794501:
/* 7571 */         return "ThreatROIExtents";
/*      */       case 1074794502:
/* 7573 */         return "ThreatROIBitmap";
/*      */       case 1074794503:
/* 7575 */         return "RouteSegmentID";
/*      */       case 1074794504:
/* 7577 */         return "GantryType";
/*      */       case 1074794505:
/* 7579 */         return "OOIOwnerType";
/*      */       case 1074794506:
/* 7581 */         return "RouteSegmentSequence";
/*      */       case 1074794512:
/* 7583 */         return "PotentialThreatObjectID";
/*      */       case 1074794513:
/* 7585 */         return "ThreatSequence";
/*      */       case 1074794514:
/* 7587 */         return "ThreatCategory";
/*      */       case 1074794515:
/* 7589 */         return "ThreatCategoryDescription";
/*      */       case 1074794516:
/* 7591 */         return "ATDAbilityAssessment";
/*      */       case 1074794517:
/* 7593 */         return "ATDAssessmentFlag";
/*      */       case 1074794518:
/* 7595 */         return "ATDAssessmentProbability";
/*      */       case 1074794519:
/* 7597 */         return "Mass";
/*      */       case 1074794520:
/* 7599 */         return "Density";
/*      */       case 1074794521:
/* 7601 */         return "ZEffective";
/*      */       case 1074794522:
/* 7603 */         return "BoardingPassID";
/*      */       case 1074794523:
/* 7605 */         return "CenterOfMass";
/*      */       case 1074794524:
/* 7607 */         return "CenterOfPTO";
/*      */       case 1074794525:
/* 7609 */         return "BoundingPolygon";
/*      */       case 1074794526:
/* 7611 */         return "RouteSegmentStartLocationID";
/*      */       case 1074794527:
/* 7613 */         return "RouteSegmentEndLocationID";
/*      */       case 1074794528:
/* 7615 */         return "RouteSegmentLocationIDType";
/*      */       case 1074794529:
/* 7617 */         return "AbortReason";
/*      */       case 1074794531:
/* 7619 */         return "VolumeOfPTO";
/*      */       case 1074794532:
/* 7621 */         return "AbortFlag";
/*      */       case 1074794533:
/* 7623 */         return "RouteSegmentStartTime";
/*      */       case 1074794534:
/* 7625 */         return "RouteSegmentEndTime";
/*      */       case 1074794535:
/* 7627 */         return "TDRType";
/*      */       case 1074794536:
/* 7629 */         return "InternationalRouteSegment";
/*      */       case 1074794537:
/* 7631 */         return "ThreatDetectionAlgorithmandVersion";
/*      */       case 1074794538:
/* 7633 */         return "AssignedLocation";
/*      */       case 1074794539:
/* 7635 */         return "AlarmDecisionTime";
/*      */       case 1074794545:
/* 7637 */         return "AlarmDecision";
/*      */       case 1074794547:
/* 7639 */         return "NumberOfTotalObjects";
/*      */       case 1074794548:
/* 7641 */         return "NumberOfAlarmObjects";
/*      */       case 1074794551:
/* 7643 */         return "PTORepresentationSequence";
/*      */       case 1074794552:
/* 7645 */         return "ATDAssessmentSequence";
/*      */       case 1074794553:
/* 7647 */         return "TIPType";
/*      */       case 1074794554:
/* 7649 */         return "DICOSVersion";
/*      */       case 1074794561:
/* 7651 */         return "OOIOwnerCreationTime";
/*      */       case 1074794562:
/* 7653 */         return "OOIType";
/*      */       case 1074794563:
/* 7655 */         return "OOISize";
/*      */       case 1074794564:
/* 7657 */         return "AcquisitionStatus";
/*      */       case 1074794565:
/* 7659 */         return "BasisMaterialsCodeSequence";
/*      */       case 1074794566:
/* 7661 */         return "PhantomType";
/*      */       case 1074794567:
/* 7663 */         return "OOIOwnerSequence";
/*      */       case 1074794568:
/* 7665 */         return "ScanType";
/*      */       case 1074794577:
/* 7667 */         return "ItineraryID";
/*      */       case 1074794578:
/* 7669 */         return "ItineraryIDType";
/*      */       case 1074794579:
/* 7671 */         return "ItineraryIDAssigningAuthority";
/*      */       case 1074794580:
/* 7673 */         return "RouteID";
/*      */       case 1074794581:
/* 7675 */         return "RouteIDAssigningAuthority";
/*      */       case 1074794582:
/* 7677 */         return "InboundArrivalType";
/*      */       case 1074794584:
/* 7679 */         return "CarrierID";
/*      */       case 1074794585:
/* 7681 */         return "CarrierIDAssigningAuthority";
/*      */       case 1074794592:
/* 7683 */         return "SourceOrientation";
/*      */       case 1074794593:
/* 7685 */         return "SourcePosition";
/*      */       case 1074794594:
/* 7687 */         return "BeltHeight";
/*      */       case 1074794596:
/* 7689 */         return "AlgorithmRoutingCodeSequence";
/*      */       case 1074794599:
/* 7691 */         return "TransportClassification";
/*      */       case 1074794600:
/* 7693 */         return "OOITypeDescriptor";
/*      */       case 1074794601:
/* 7695 */         return "TotalProcessingTime";
/*      */       case 1074794604:
/* 7697 */         return "DetectorCalibrationData";
/*      */       case 1074794605:
/* 7699 */         return "AdditionalScreeningPerformed";
/*      */       case 1074794606:
/* 7701 */         return "AdditionalInspectionSelectionCriteria";
/*      */       case 1074794607:
/* 7703 */         return "AdditionalInspectionMethodSequence";
/*      */       case 1074794608:
/* 7705 */         return "AITDeviceType";
/*      */       case 1074794609:
/* 7707 */         return "QRMeasurementsSequence";
/*      */       case 1074794610:
/* 7709 */         return "TargetMaterialSequence";
/*      */       case 1074794611:
/* 7711 */         return "SNRThreshold";
/*      */       case 1074794613:
/* 7713 */         return "ImageScaleRepresentation";
/*      */       case 1074794614:
/* 7715 */         return "ReferencedPTOSequence";
/*      */       case 1074794615:
/* 7717 */         return "ReferencedTDRInstanceSequence";
/*      */       case 1074794616:
/* 7719 */         return "PTOLocationDescription";
/*      */       case 1074794617:
/* 7721 */         return "AnomalyLocatorIndicatorSequence";
/*      */       case 1074794618:
/* 7723 */         return "AnomalyLocatorIndicator";
/*      */       case 1074794619:
/* 7725 */         return "PTORegionSequence";
/*      */       case 1074794620:
/* 7727 */         return "InspectionSelectionCriteria";
/*      */       case 1074794621:
/* 7729 */         return "SecondaryInspectionMethodSequence";
/*      */       case 1074794622:
/* 7731 */         return "PRCSToRCSOrientation";
/*      */       case 1342046209:
/* 7733 */         return "MACParametersSequence";
/*      */       case 1342177285:
/* 7735 */         return "CurveDimensions";
/*      */       case 1342177296:
/* 7737 */         return "NumberOfPoints";
/*      */       case 1342177312:
/* 7739 */         return "TypeOfData";
/*      */       case 1342177314:
/* 7741 */         return "CurveDescription";
/*      */       case 1342177328:
/* 7743 */         return "AxisUnits";
/*      */       case 1342177344:
/* 7745 */         return "AxisLabels";
/*      */       case 1342177539:
/* 7747 */         return "DataValueRepresentation";
/*      */       case 1342177540:
/* 7749 */         return "MinimumCoordinateValue";
/*      */       case 1342177541:
/* 7751 */         return "MaximumCoordinateValue";
/*      */       case 1342177542:
/* 7753 */         return "CurveRange";
/*      */       case 1342177552:
/* 7755 */         return "CurveDataDescriptor";
/*      */       case 1342177554:
/* 7757 */         return "CoordinateStartValue";
/*      */       case 1342177556:
/* 7759 */         return "CoordinateStepValue";
/*      */       case 1342181377:
/* 7761 */         return "CurveActivationLayer";
/*      */       case 1342185472:
/* 7763 */         return "AudioType";
/*      */       case 1342185474:
/* 7765 */         return "AudioSampleFormat";
/*      */       case 1342185476:
/* 7767 */         return "NumberOfChannels";
/*      */       case 1342185478:
/* 7769 */         return "NumberOfSamples";
/*      */       case 1342185480:
/* 7771 */         return "SampleRate";
/*      */       case 1342185482:
/* 7773 */         return "TotalTime";
/*      */       case 1342185484:
/* 7775 */         return "AudioSampleData";
/*      */       case 1342185486:
/* 7777 */         return "AudioComments";
/*      */       case 1342186752:
/* 7779 */         return "CurveLabel";
/*      */       case 1342187008:
/* 7781 */         return "CurveReferencedOverlaySequence";
/*      */       case 1342187024:
/* 7783 */         return "CurveReferencedOverlayGroup";
/*      */       case 1342189568:
/* 7785 */         return "CurveData";
/*      */       case 1375769129:
/* 7787 */         return "SharedFunctionalGroupsSequence";
/*      */       case 1375769136:
/* 7789 */         return "PerFrameFunctionalGroupsSequence";
/*      */       case 1409286400:
/* 7791 */         return "WaveformSequence";
/*      */       case 1409286416:
/* 7793 */         return "ChannelMinimumValue";
/*      */       case 1409286418:
/* 7795 */         return "ChannelMaximumValue";
/*      */       case 1409290244:
/* 7797 */         return "WaveformBitsAllocated";
/*      */       case 1409290246:
/* 7799 */         return "WaveformSampleInterpretation";
/*      */       case 1409290250:
/* 7801 */         return "WaveformPaddingValue";
/*      */       case 1409290256:
/* 7803 */         return "WaveformData";
/*      */       case 1442840592:
/* 7805 */         return "FirstOrderPhaseCorrectionAngle";
/*      */       case 1442840608:
/* 7807 */         return "SpectroscopyData";
/*      */       case 1610612752:
/* 7809 */         return "OverlayRows";
/*      */       case 1610612753:
/* 7811 */         return "OverlayColumns";
/*      */       case 1610612754:
/* 7813 */         return "OverlayPlanes";
/*      */       case 1610612757:
/* 7815 */         return "NumberOfFramesInOverlay";
/*      */       case 1610612770:
/* 7817 */         return "OverlayDescription";
/*      */       case 1610612800:
/* 7819 */         return "OverlayType";
/*      */       case 1610612805:
/* 7821 */         return "OverlaySubtype";
/*      */       case 1610612816:
/* 7823 */         return "OverlayOrigin";
/*      */       case 1610612817:
/* 7825 */         return "ImageFrameOrigin";
/*      */       case 1610612818:
/* 7827 */         return "OverlayPlaneOrigin";
/*      */       case 1610612832:
/* 7829 */         return "OverlayCompressionCode";
/*      */       case 1610612833:
/* 7831 */         return "OverlayCompressionOriginator";
/*      */       case 1610612834:
/* 7833 */         return "OverlayCompressionLabel";
/*      */       case 1610612835:
/* 7835 */         return "OverlayCompressionDescription";
/*      */       case 1610612838:
/* 7837 */         return "OverlayCompressionStepPointers";
/*      */       case 1610612840:
/* 7839 */         return "OverlayRepeatInterval";
/*      */       case 1610612841:
/* 7841 */         return "OverlayBitsGrouped";
/*      */       case 1610612992:
/* 7843 */         return "OverlayBitsAllocated";
/*      */       case 1610612994:
/* 7845 */         return "OverlayBitPosition";
/*      */       case 1610613008:
/* 7847 */         return "OverlayFormat";
/*      */       case 1610613248:
/* 7849 */         return "OverlayLocation";
/*      */       case 1610614784:
/* 7851 */         return "OverlayCodeLabel";
/*      */       case 1610614786:
/* 7853 */         return "OverlayNumberOfTables";
/*      */       case 1610614787:
/* 7855 */         return "OverlayCodeTableLocation";
/*      */       case 1610614788:
/* 7857 */         return "OverlayBitsForCodeWord";
/*      */       case 1610616833:
/* 7859 */         return "OverlayActivationLayer";
/*      */       case 1610617088:
/* 7861 */         return "OverlayDescriptorGray";
/*      */       case 1610617089:
/* 7863 */         return "OverlayDescriptorRed";
/*      */       case 1610617090:
/* 7865 */         return "OverlayDescriptorGreen";
/*      */       case 1610617091:
/* 7867 */         return "OverlayDescriptorBlue";
/*      */       case 1610617344:
/* 7869 */         return "OverlaysGray";
/*      */       case 1610617345:
/* 7871 */         return "OverlaysRed";
/*      */       case 1610617346:
/* 7873 */         return "OverlaysGreen";
/*      */       case 1610617347:
/* 7875 */         return "OverlaysBlue";
/*      */       case 1610617601:
/* 7877 */         return "ROIArea";
/*      */       case 1610617602:
/* 7879 */         return "ROIMean";
/*      */       case 1610617603:
/* 7881 */         return "ROIStandardDeviation";
/*      */       case 1610618112:
/* 7883 */         return "OverlayLabel";
/*      */       case 1610625024:
/* 7885 */         return "OverlayData";
/*      */       case 1610629120:
/* 7887 */         return "OverlayComments";
/*      */       case 2145386504:
/* 7889 */         return "FloatPixelData";
/*      */       case 2145386505:
/* 7891 */         return "DoubleFloatPixelData";
/*      */       case 2145386512:
/* 7893 */         return "PixelData";
/*      */       case 2145386528:
/* 7895 */         return "CoefficientsSDVN";
/*      */       case 2145386544:
/* 7897 */         return "CoefficientsSDHN";
/*      */       case 2145386560:
/* 7899 */         return "CoefficientsSDDN";
/*      */       case 2130706448:
/* 7901 */         return "VariablePixelData";
/*      */       case 2130706449:
/* 7903 */         return "VariableNextDataGroup";
/*      */       case 2130706464:
/* 7905 */         return "VariableCoefficientsSDVN";
/*      */       case 2130706480:
/* 7907 */         return "VariableCoefficientsSDHN";
/*      */       case 2130706496:
/* 7909 */         return "VariableCoefficientsSDDN";
/*      */       case -327686:
/* 7911 */         return "DigitalSignaturesSequence";
/*      */       case -196612:
/* 7913 */         return "DataSetTrailingPadding";
/*      */       case -73728:
/* 7915 */         return "Item";
/*      */       case -73715:
/* 7917 */         return "ItemDelimitationItem";
/*      */       case -73507:
/* 7919 */         return "SequenceDelimitationItem";
/*      */       case -458760:
/* 7921 */         return "ReferencedBulkDataSequence";
/*      */     } 
/* 7923 */     return "";
/*      */   }
/*      */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Keyword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */