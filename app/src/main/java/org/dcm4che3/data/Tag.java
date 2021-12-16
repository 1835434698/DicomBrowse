package org.dcm4che3.data;

public class Tag {
  public static final int CommandGroupLength = 0;
  
  public static final int CommandLengthToEnd = 1;
  
  public static final int AffectedSOPClassUID = 2;
  
  public static final int RequestedSOPClassUID = 3;
  
  public static final int CommandRecognitionCode = 16;
  
  public static final int CommandField = 256;
  
  public static final int MessageID = 272;
  
  public static final int MessageIDBeingRespondedTo = 288;
  
  public static final int Initiator = 512;
  
  public static final int Receiver = 768;
  
  public static final int FindLocation = 1024;
  
  public static final int MoveDestination = 1536;
  
  public static final int Priority = 1792;
  
  public static final int CommandDataSetType = 2048;
  
  public static final int NumberOfMatches = 2128;
  
  public static final int ResponseSequenceNumber = 2144;
  
  public static final int Status = 2304;
  
  public static final int OffendingElement = 2305;
  
  public static final int ErrorComment = 2306;
  
  public static final int ErrorID = 2307;
  
  public static final int AffectedSOPInstanceUID = 4096;
  
  public static final int RequestedSOPInstanceUID = 4097;
  
  public static final int EventTypeID = 4098;
  
  public static final int AttributeIdentifierList = 4101;
  
  public static final int ActionTypeID = 4104;
  
  public static final int NumberOfRemainingSuboperations = 4128;
  
  public static final int NumberOfCompletedSuboperations = 4129;
  
  public static final int NumberOfFailedSuboperations = 4130;
  
  public static final int NumberOfWarningSuboperations = 4131;
  
  public static final int MoveOriginatorApplicationEntityTitle = 4144;
  
  public static final int MoveOriginatorMessageID = 4145;
  
  public static final int DialogReceiver = 16384;
  
  public static final int TerminalType = 16400;
  
  public static final int MessageSetID = 20496;
  
  public static final int EndMessageID = 20512;
  
  public static final int DisplayFormat = 20752;
  
  public static final int PagePositionID = 20768;
  
  public static final int TextFormatID = 20784;
  
  public static final int NormalReverse = 20800;
  
  public static final int AddGrayScale = 20816;
  
  public static final int Borders = 20832;
  
  public static final int Copies = 20848;
  
  public static final int CommandMagnificationType = 20864;
  
  public static final int Erase = 20880;
  
  public static final int Print = 20896;
  
  public static final int Overlays = 20912;
  
  public static final int FileMetaInformationGroupLength = 131072;
  
  public static final int FileMetaInformationVersion = 131073;
  
  public static final int MediaStorageSOPClassUID = 131074;
  
  public static final int MediaStorageSOPInstanceUID = 131075;
  
  public static final int TransferSyntaxUID = 131088;
  
  public static final int ImplementationClassUID = 131090;
  
  public static final int ImplementationVersionName = 131091;
  
  public static final int SourceApplicationEntityTitle = 131094;
  
  public static final int SendingApplicationEntityTitle = 131095;
  
  public static final int ReceivingApplicationEntityTitle = 131096;
  
  public static final int PrivateInformationCreatorUID = 131328;
  
  public static final int PrivateInformation = 131330;
  
  public static final int FileSetID = 266544;
  
  public static final int FileSetDescriptorFileID = 266561;
  
  public static final int SpecificCharacterSetOfFileSetDescriptorFile = 266562;
  
  public static final int OffsetOfTheFirstDirectoryRecordOfTheRootDirectoryEntity = 266752;
  
  public static final int OffsetOfTheLastDirectoryRecordOfTheRootDirectoryEntity = 266754;
  
  public static final int FileSetConsistencyFlag = 266770;
  
  public static final int DirectoryRecordSequence = 266784;
  
  public static final int OffsetOfTheNextDirectoryRecord = 267264;
  
  public static final int RecordInUseFlag = 267280;
  
  public static final int OffsetOfReferencedLowerLevelDirectoryEntity = 267296;
  
  public static final int DirectoryRecordType = 267312;
  
  public static final int PrivateRecordUID = 267314;
  
  public static final int ReferencedFileID = 267520;
  
  public static final int MRDRDirectoryRecordOffset = 267524;
  
  public static final int ReferencedSOPClassUIDInFile = 267536;
  
  public static final int ReferencedSOPInstanceUIDInFile = 267537;
  
  public static final int ReferencedTransferSyntaxUIDInFile = 267538;
  
  public static final int ReferencedRelatedGeneralSOPClassUIDInFile = 267546;
  
  public static final int NumberOfReferences = 267776;
  
  public static final int LengthToEnd = 524289;
  
  public static final int SpecificCharacterSet = 524293;
  
  public static final int LanguageCodeSequence = 524294;
  
  public static final int ImageType = 524296;
  
  public static final int RecognitionCode = 524304;
  
  public static final int InstanceCreationDate = 524306;
  
  public static final int InstanceCreationTime = 524307;
  
  public static final int InstanceCreatorUID = 524308;
  
  public static final int InstanceCoercionDateTime = 524309;
  
  public static final int SOPClassUID = 524310;
  
  public static final int SOPInstanceUID = 524312;
  
  public static final int RelatedGeneralSOPClassUID = 524314;
  
  public static final int OriginalSpecializedSOPClassUID = 524315;
  
  public static final int StudyDate = 524320;
  
  public static final int SeriesDate = 524321;
  
  public static final int AcquisitionDate = 524322;
  
  public static final int ContentDate = 524323;
  
  public static final int OverlayDate = 524324;
  
  public static final int CurveDate = 524325;
  
  public static final int AcquisitionDateTime = 524330;
  
  public static final int StudyTime = 524336;
  
  public static final int SeriesTime = 524337;
  
  public static final int AcquisitionTime = 524338;
  
  public static final int ContentTime = 524339;
  
  public static final int OverlayTime = 524340;
  
  public static final int CurveTime = 524341;
  
  public static final int DataSetType = 524352;
  
  public static final int DataSetSubtype = 524353;
  
  public static final int NuclearMedicineSeriesType = 524354;
  
  public static final int AccessionNumber = 524368;
  
  public static final int IssuerOfAccessionNumberSequence = 524369;
  
  public static final int QueryRetrieveLevel = 524370;
  
  public static final int QueryRetrieveView = 524371;
  
  public static final int RetrieveAETitle = 524372;
  
  public static final int InstanceAvailability = 524374;
  
  public static final int FailedSOPInstanceUIDList = 524376;
  
  public static final int Modality = 524384;
  
  public static final int ModalitiesInStudy = 524385;
  
  public static final int SOPClassesInStudy = 524386;
  
  public static final int ConversionType = 524388;
  
  public static final int PresentationIntentType = 524392;
  
  public static final int Manufacturer = 524400;
  
  public static final int InstitutionName = 524416;
  
  public static final int InstitutionAddress = 524417;
  
  public static final int InstitutionCodeSequence = 524418;
  
  public static final int ReferringPhysicianName = 524432;
  
  public static final int ReferringPhysicianAddress = 524434;
  
  public static final int ReferringPhysicianTelephoneNumbers = 524436;
  
  public static final int ReferringPhysicianIdentificationSequence = 524438;
  
  public static final int CodeValue = 524544;
  
  public static final int ExtendedCodeValue = 524545;
  
  public static final int CodingSchemeDesignator = 524546;
  
  public static final int CodingSchemeVersion = 524547;
  
  public static final int CodeMeaning = 524548;
  
  public static final int MappingResource = 524549;
  
  public static final int ContextGroupVersion = 524550;
  
  public static final int ContextGroupLocalVersion = 524551;
  
  public static final int ExtendedCodeMeaning = 524552;
  
  public static final int ContextGroupExtensionFlag = 524555;
  
  public static final int CodingSchemeUID = 524556;
  
  public static final int ContextGroupExtensionCreatorUID = 524557;
  
  public static final int ContextIdentifier = 524559;
  
  public static final int CodingSchemeIdentificationSequence = 524560;
  
  public static final int CodingSchemeRegistry = 524562;
  
  public static final int CodingSchemeExternalID = 524564;
  
  public static final int CodingSchemeName = 524565;
  
  public static final int CodingSchemeResponsibleOrganization = 524566;
  
  public static final int ContextUID = 524567;
  
  public static final int MappingResourceUID = 524568;
  
  public static final int LongCodeValue = 524569;
  
  public static final int URNCodeValue = 524576;
  
  public static final int EquivalentCodeSequence = 524577;
  
  public static final int TimezoneOffsetFromUTC = 524801;
  
  public static final int NetworkID = 528384;
  
  public static final int StationName = 528400;
  
  public static final int StudyDescription = 528432;
  
  public static final int ProcedureCodeSequence = 528434;
  
  public static final int SeriesDescription = 528446;
  
  public static final int SeriesDescriptionCodeSequence = 528447;
  
  public static final int InstitutionalDepartmentName = 528448;
  
  public static final int PhysiciansOfRecord = 528456;
  
  public static final int PhysiciansOfRecordIdentificationSequence = 528457;
  
  public static final int PerformingPhysicianName = 528464;
  
  public static final int PerformingPhysicianIdentificationSequence = 528466;
  
  public static final int NameOfPhysiciansReadingStudy = 528480;
  
  public static final int PhysiciansReadingStudyIdentificationSequence = 528482;
  
  public static final int OperatorsName = 528496;
  
  public static final int OperatorIdentificationSequence = 528498;
  
  public static final int AdmittingDiagnosesDescription = 528512;
  
  public static final int AdmittingDiagnosesCodeSequence = 528516;
  
  public static final int ManufacturerModelName = 528528;
  
  public static final int ReferencedResultsSequence = 528640;
  
  public static final int ReferencedStudySequence = 528656;
  
  public static final int ReferencedPerformedProcedureStepSequence = 528657;
  
  public static final int ReferencedSeriesSequence = 528661;
  
  public static final int ReferencedPatientSequence = 528672;
  
  public static final int ReferencedVisitSequence = 528677;
  
  public static final int ReferencedOverlaySequence = 528688;
  
  public static final int ReferencedStereometricInstanceSequence = 528692;
  
  public static final int ReferencedWaveformSequence = 528698;
  
  public static final int ReferencedImageSequence = 528704;
  
  public static final int ReferencedCurveSequence = 528709;
  
  public static final int ReferencedInstanceSequence = 528714;
  
  public static final int ReferencedRealWorldValueMappingInstanceSequence = 528715;
  
  public static final int ReferencedSOPClassUID = 528720;
  
  public static final int ReferencedSOPInstanceUID = 528725;
  
  public static final int SOPClassesSupported = 528730;
  
  public static final int ReferencedFrameNumber = 528736;
  
  public static final int SimpleFrameList = 528737;
  
  public static final int CalculatedFrameList = 528738;
  
  public static final int TimeRange = 528739;
  
  public static final int FrameExtractionSequence = 528740;
  
  public static final int MultiFrameSourceSOPInstanceUID = 528743;
  
  public static final int RetrieveURL = 528784;
  
  public static final int TransactionUID = 528789;
  
  public static final int WarningReason = 528790;
  
  public static final int FailureReason = 528791;
  
  public static final int FailedSOPSequence = 528792;
  
  public static final int ReferencedSOPSequence = 528793;
  
  public static final int StudiesContainingOtherReferencedInstancesSequence = 528896;
  
  public static final int RelatedSeriesSequence = 528976;
  
  public static final int LossyImageCompressionRetired = 532752;
  
  public static final int DerivationDescription = 532753;
  
  public static final int SourceImageSequence = 532754;
  
  public static final int StageName = 532768;
  
  public static final int StageNumber = 532770;
  
  public static final int NumberOfStages = 532772;
  
  public static final int ViewName = 532775;
  
  public static final int ViewNumber = 532776;
  
  public static final int NumberOfEventTimers = 532777;
  
  public static final int NumberOfViewsInStage = 532778;
  
  public static final int EventElapsedTimes = 532784;
  
  public static final int EventTimerNames = 532786;
  
  public static final int EventTimerSequence = 532787;
  
  public static final int EventTimeOffset = 532788;
  
  public static final int EventCodeSequence = 532789;
  
  public static final int StartTrim = 532802;
  
  public static final int StopTrim = 532803;
  
  public static final int RecommendedDisplayFrameRate = 532804;
  
  public static final int TransducerPosition = 532992;
  
  public static final int TransducerOrientation = 532996;
  
  public static final int AnatomicStructure = 533000;
  
  public static final int AnatomicRegionSequence = 533016;
  
  public static final int AnatomicRegionModifierSequence = 533024;
  
  public static final int PrimaryAnatomicStructureSequence = 533032;
  
  public static final int AnatomicStructureSpaceOrRegionSequence = 533033;
  
  public static final int PrimaryAnatomicStructureModifierSequence = 533040;
  
  public static final int TransducerPositionSequence = 533056;
  
  public static final int TransducerPositionModifierSequence = 533058;
  
  public static final int TransducerOrientationSequence = 533060;
  
  public static final int TransducerOrientationModifierSequence = 533062;
  
  public static final int AnatomicStructureSpaceOrRegionCodeSequenceTrial = 533073;
  
  public static final int AnatomicPortalOfEntranceCodeSequenceTrial = 533075;
  
  public static final int AnatomicApproachDirectionCodeSequenceTrial = 533077;
  
  public static final int AnatomicPerspectiveDescriptionTrial = 533078;
  
  public static final int AnatomicPerspectiveCodeSequenceTrial = 533079;
  
  public static final int AnatomicLocationOfExaminingInstrumentDescriptionTrial = 533080;
  
  public static final int AnatomicLocationOfExaminingInstrumentCodeSequenceTrial = 533081;
  
  public static final int AnatomicStructureSpaceOrRegionModifierCodeSequenceTrial = 533082;
  
  public static final int OnAxisBackgroundAnatomicStructureCodeSequenceTrial = 533084;
  
  public static final int AlternateRepresentationSequence = 536577;
  
  public static final int IrradiationEventUID = 536592;
  
  public static final int SourceIrradiationEventSequence = 536593;
  
  public static final int RadiopharmaceuticalAdministrationEventUID = 536594;
  
  public static final int IdentifyingComments = 540672;
  
  public static final int FrameType = 561159;
  
  public static final int ReferencedImageEvidenceSequence = 561298;
  
  public static final int ReferencedRawDataSequence = 561441;
  
  public static final int CreatorVersionUID = 561443;
  
  public static final int DerivationImageSequence = 561444;
  
  public static final int SourceImageEvidenceSequence = 561492;
  
  public static final int PixelPresentation = 561669;
  
  public static final int VolumetricProperties = 561670;
  
  public static final int VolumeBasedCalculationTechnique = 561671;
  
  public static final int ComplexImageComponent = 561672;
  
  public static final int AcquisitionContrast = 561673;
  
  public static final int DerivationCodeSequence = 561685;
  
  public static final int ReferencedPresentationStateSequence = 561719;
  
  public static final int ReferencedOtherPlaneSequence = 562192;
  
  public static final int FrameDisplaySequence = 562264;
  
  public static final int RecommendedDisplayFrameRateInFloat = 562265;
  
  public static final int SkipFrameRangeFlag = 562272;
  
  public static final int PatientName = 1048592;
  
  public static final int PatientID = 1048608;
  
  public static final int IssuerOfPatientID = 1048609;
  
  public static final int TypeOfPatientID = 1048610;
  
  public static final int IssuerOfPatientIDQualifiersSequence = 1048612;
  
  public static final int PatientBirthDate = 1048624;
  
  public static final int PatientBirthTime = 1048626;
  
  public static final int PatientSex = 1048640;
  
  public static final int PatientInsurancePlanCodeSequence = 1048656;
  
  public static final int PatientPrimaryLanguageCodeSequence = 1048833;
  
  public static final int PatientPrimaryLanguageModifierCodeSequence = 1048834;
  
  public static final int QualityControlSubject = 1049088;
  
  public static final int QualityControlSubjectTypeCodeSequence = 1049089;
  
  public static final int OtherPatientIDs = 1052672;
  
  public static final int OtherPatientNames = 1052673;
  
  public static final int OtherPatientIDsSequence = 1052674;
  
  public static final int PatientBirthName = 1052677;
  
  public static final int PatientAge = 1052688;
  
  public static final int PatientSize = 1052704;
  
  public static final int PatientSizeCodeSequence = 1052705;
  
  public static final int PatientWeight = 1052720;
  
  public static final int PatientAddress = 1052736;
  
  public static final int InsurancePlanIdentification = 1052752;
  
  public static final int PatientMotherBirthName = 1052768;
  
  public static final int MilitaryRank = 1052800;
  
  public static final int BranchOfService = 1052801;
  
  public static final int MedicalRecordLocator = 1052816;
  
  public static final int ReferencedPatientPhotoSequence = 1052928;
  
  public static final int MedicalAlerts = 1056768;
  
  public static final int Allergies = 1057040;
  
  public static final int CountryOfResidence = 1057104;
  
  public static final int RegionOfResidence = 1057106;
  
  public static final int PatientTelephoneNumbers = 1057108;
  
  public static final int EthnicGroup = 1057120;
  
  public static final int Occupation = 1057152;
  
  public static final int SmokingStatus = 1057184;
  
  public static final int AdditionalPatientHistory = 1057200;
  
  public static final int PregnancyStatus = 1057216;
  
  public static final int LastMenstrualDate = 1057232;
  
  public static final int PatientReligiousPreference = 1057264;
  
  public static final int PatientSpeciesDescription = 1057281;
  
  public static final int PatientSpeciesCodeSequence = 1057282;
  
  public static final int PatientSexNeutered = 1057283;
  
  public static final int AnatomicalOrientationType = 1057296;
  
  public static final int PatientBreedDescription = 1057426;
  
  public static final int PatientBreedCodeSequence = 1057427;
  
  public static final int BreedRegistrationSequence = 1057428;
  
  public static final int BreedRegistrationNumber = 1057429;
  
  public static final int BreedRegistryCodeSequence = 1057430;
  
  public static final int ResponsiblePerson = 1057431;
  
  public static final int ResponsiblePersonRole = 1057432;
  
  public static final int ResponsibleOrganization = 1057433;
  
  public static final int PatientComments = 1064960;
  
  public static final int ExaminedBodyThickness = 1086513;
  
  public static final int ClinicalTrialSponsorName = 1179664;
  
  public static final int ClinicalTrialProtocolID = 1179680;
  
  public static final int ClinicalTrialProtocolName = 1179681;
  
  public static final int ClinicalTrialSiteID = 1179696;
  
  public static final int ClinicalTrialSiteName = 1179697;
  
  public static final int ClinicalTrialSubjectID = 1179712;
  
  public static final int ClinicalTrialSubjectReadingID = 1179714;
  
  public static final int ClinicalTrialTimePointID = 1179728;
  
  public static final int ClinicalTrialTimePointDescription = 1179729;
  
  public static final int ClinicalTrialCoordinatingCenterName = 1179744;
  
  public static final int PatientIdentityRemoved = 1179746;
  
  public static final int DeidentificationMethod = 1179747;
  
  public static final int DeidentificationMethodCodeSequence = 1179748;
  
  public static final int ClinicalTrialSeriesID = 1179761;
  
  public static final int ClinicalTrialSeriesDescription = 1179762;
  
  public static final int ClinicalTrialProtocolEthicsCommitteeName = 1179777;
  
  public static final int ClinicalTrialProtocolEthicsCommitteeApprovalNumber = 1179778;
  
  public static final int ConsentForClinicalTrialUseSequence = 1179779;
  
  public static final int DistributionType = 1179780;
  
  public static final int ConsentForDistributionFlag = 1179781;
  
  public static final int CADFileFormat = 1310755;
  
  public static final int ComponentReferenceSystem = 1310756;
  
  public static final int ComponentManufacturingProcedure = 1310757;
  
  public static final int ComponentManufacturer = 1310760;
  
  public static final int MaterialThickness = 1310768;
  
  public static final int MaterialPipeDiameter = 1310770;
  
  public static final int MaterialIsolationDiameter = 1310772;
  
  public static final int MaterialGrade = 1310786;
  
  public static final int MaterialPropertiesDescription = 1310788;
  
  public static final int MaterialPropertiesFileFormatRetired = 1310789;
  
  public static final int MaterialNotes = 1310790;
  
  public static final int ComponentShape = 1310800;
  
  public static final int CurvatureType = 1310802;
  
  public static final int OuterDiameter = 1310804;
  
  public static final int InnerDiameter = 1310806;
  
  public static final int ActualEnvironmentalConditions = 1314832;
  
  public static final int ExpiryDate = 1314848;
  
  public static final int EnvironmentalConditions = 1314880;
  
  public static final int EvaluatorSequence = 1318914;
  
  public static final int EvaluatorNumber = 1318916;
  
  public static final int EvaluatorName = 1318918;
  
  public static final int EvaluationAttempt = 1318920;
  
  public static final int IndicationSequence = 1318930;
  
  public static final int IndicationNumber = 1318932;
  
  public static final int IndicationLabel = 1318934;
  
  public static final int IndicationDescription = 1318936;
  
  public static final int IndicationType = 1318938;
  
  public static final int IndicationDisposition = 1318940;
  
  public static final int IndicationROISequence = 1318942;
  
  public static final int IndicationPhysicalPropertySequence = 1318960;
  
  public static final int PropertyLabel = 1318962;
  
  public static final int CoordinateSystemNumberOfAxes = 1319426;
  
  public static final int CoordinateSystemAxesSequence = 1319428;
  
  public static final int CoordinateSystemAxisDescription = 1319430;
  
  public static final int CoordinateSystemDataSetMapping = 1319432;
  
  public static final int CoordinateSystemAxisNumber = 1319434;
  
  public static final int CoordinateSystemAxisType = 1319436;
  
  public static final int CoordinateSystemAxisUnits = 1319438;
  
  public static final int CoordinateSystemAxisValues = 1319440;
  
  public static final int CoordinateSystemTransformSequence = 1319456;
  
  public static final int TransformDescription = 1319458;
  
  public static final int TransformNumberOfAxes = 1319460;
  
  public static final int TransformOrderOfAxes = 1319462;
  
  public static final int TransformedAxisUnits = 1319464;
  
  public static final int CoordinateSystemTransformRotationAndScaleMatrix = 1319466;
  
  public static final int CoordinateSystemTransformTranslationMatrix = 1319468;
  
  public static final int InternalDetectorFrameTime = 1323025;
  
  public static final int NumberOfFramesIntegrated = 1323026;
  
  public static final int DetectorTemperatureSequence = 1323040;
  
  public static final int SensorName = 1323042;
  
  public static final int HorizontalOffsetOfSensor = 1323044;
  
  public static final int VerticalOffsetOfSensor = 1323046;
  
  public static final int SensorTemperature = 1323048;
  
  public static final int DarkCurrentSequence = 1323072;
  
  public static final int DarkCurrentCounts = 1323088;
  
  public static final int GainCorrectionReferenceSequence = 1323104;
  
  public static final int AirCounts = 1323120;
  
  public static final int KVUsedInGainCalibration = 1323121;
  
  public static final int MAUsedInGainCalibration = 1323122;
  
  public static final int NumberOfFramesUsedForIntegration = 1323123;
  
  public static final int FilterMaterialUsedInGainCalibration = 1323124;
  
  public static final int FilterThicknessUsedInGainCalibration = 1323125;
  
  public static final int DateOfGainCalibration = 1323126;
  
  public static final int TimeOfGainCalibration = 1323127;
  
  public static final int BadPixelImage = 1323136;
  
  public static final int CalibrationNotes = 1323161;
  
  public static final int PulserEquipmentSequence = 1327106;
  
  public static final int PulserType = 1327108;
  
  public static final int PulserNotes = 1327110;
  
  public static final int ReceiverEquipmentSequence = 1327112;
  
  public static final int AmplifierType = 1327114;
  
  public static final int ReceiverNotes = 1327116;
  
  public static final int PreAmplifierEquipmentSequence = 1327118;
  
  public static final int PreAmplifierNotes = 1327119;
  
  public static final int TransmitTransducerSequence = 1327120;
  
  public static final int ReceiveTransducerSequence = 1327121;
  
  public static final int NumberOfElements = 1327122;
  
  public static final int ElementShape = 1327123;
  
  public static final int ElementDimensionA = 1327124;
  
  public static final int ElementDimensionB = 1327125;
  
  public static final int ElementPitchA = 1327126;
  
  public static final int MeasuredBeamDimensionA = 1327127;
  
  public static final int MeasuredBeamDimensionB = 1327128;
  
  public static final int LocationOfMeasuredBeamDiameter = 1327129;
  
  public static final int NominalFrequency = 1327130;
  
  public static final int MeasuredCenterFrequency = 1327131;
  
  public static final int MeasuredBandwidth = 1327132;
  
  public static final int ElementPitchB = 1327133;
  
  public static final int PulserSettingsSequence = 1327136;
  
  public static final int PulseWidth = 1327138;
  
  public static final int ExcitationFrequency = 1327140;
  
  public static final int ModulationType = 1327142;
  
  public static final int Damping = 1327144;
  
  public static final int ReceiverSettingsSequence = 1327152;
  
  public static final int AcquiredSoundpathLength = 1327153;
  
  public static final int AcquisitionCompressionType = 1327154;
  
  public static final int AcquisitionSampleSize = 1327155;
  
  public static final int RectifierSmoothing = 1327156;
  
  public static final int DACSequence = 1327157;
  
  public static final int DACType = 1327158;
  
  public static final int DACGainPoints = 1327160;
  
  public static final int DACTimePoints = 1327162;
  
  public static final int DACAmplitude = 1327164;
  
  public static final int PreAmplifierSettingsSequence = 1327168;
  
  public static final int TransmitTransducerSettingsSequence = 1327184;
  
  public static final int ReceiveTransducerSettingsSequence = 1327185;
  
  public static final int IncidentAngle = 1327186;
  
  public static final int CouplingTechnique = 1327188;
  
  public static final int CouplingMedium = 1327190;
  
  public static final int CouplingVelocity = 1327191;
  
  public static final int ProbeCenterLocationX = 1327192;
  
  public static final int ProbeCenterLocationZ = 1327193;
  
  public static final int SoundPathLength = 1327194;
  
  public static final int DelayLawIdentifier = 1327196;
  
  public static final int GateSettingsSequence = 1327200;
  
  public static final int GateThreshold = 1327202;
  
  public static final int VelocityOfSound = 1327204;
  
  public static final int CalibrationSettingsSequence = 1327216;
  
  public static final int CalibrationProcedure = 1327218;
  
  public static final int ProcedureVersion = 1327220;
  
  public static final int ProcedureCreationDate = 1327222;
  
  public static final int ProcedureExpirationDate = 1327224;
  
  public static final int ProcedureLastModifiedDate = 1327226;
  
  public static final int CalibrationTime = 1327228;
  
  public static final int CalibrationDate = 1327230;
  
  public static final int ProbeDriveEquipmentSequence = 1327232;
  
  public static final int DriveType = 1327233;
  
  public static final int ProbeDriveNotes = 1327234;
  
  public static final int DriveProbeSequence = 1327235;
  
  public static final int ProbeInductance = 1327236;
  
  public static final int ProbeResistance = 1327237;
  
  public static final int ReceiveProbeSequence = 1327238;
  
  public static final int ProbeDriveSettingsSequence = 1327239;
  
  public static final int BridgeResistors = 1327240;
  
  public static final int ProbeOrientationAngle = 1327241;
  
  public static final int UserSelectedGainY = 1327243;
  
  public static final int UserSelectedPhase = 1327244;
  
  public static final int UserSelectedOffsetX = 1327245;
  
  public static final int UserSelectedOffsetY = 1327246;
  
  public static final int ChannelSettingsSequence = 1327249;
  
  public static final int ChannelThreshold = 1327250;
  
  public static final int ScannerSettingsSequence = 1327258;
  
  public static final int ScanProcedure = 1327259;
  
  public static final int TranslationRateX = 1327260;
  
  public static final int TranslationRateY = 1327261;
  
  public static final int ChannelOverlap = 1327263;
  
  public static final int ImageQualityIndicatorType = 1327264;
  
  public static final int ImageQualityIndicatorMaterial = 1327265;
  
  public static final int ImageQualityIndicatorSize = 1327266;
  
  public static final int LINACEnergy = 1331202;
  
  public static final int LINACOutput = 1331204;
  
  public static final int ActiveAperture = 1331456;
  
  public static final int TotalAperture = 1331457;
  
  public static final int ApertureElevation = 1331458;
  
  public static final int MainLobeAngle = 1331459;
  
  public static final int MainRoofAngle = 1331460;
  
  public static final int ConnectorType = 1331461;
  
  public static final int WedgeModelNumber = 1331462;
  
  public static final int WedgeAngleFloat = 1331463;
  
  public static final int WedgeRoofAngle = 1331464;
  
  public static final int WedgeElement1Position = 1331465;
  
  public static final int WedgeMaterialVelocity = 1331466;
  
  public static final int WedgeMaterial = 1331467;
  
  public static final int WedgeOffsetZ = 1331468;
  
  public static final int WedgeOriginOffsetX = 1331469;
  
  public static final int WedgeTimeDelay = 1331470;
  
  public static final int WedgeName = 1331471;
  
  public static final int WedgeManufacturerName = 1331472;
  
  public static final int WedgeDescription = 1331473;
  
  public static final int NominalBeamAngle = 1331474;
  
  public static final int WedgeOffsetX = 1331475;
  
  public static final int WedgeOffsetY = 1331476;
  
  public static final int WedgeTotalLength = 1331477;
  
  public static final int WedgeInContactLength = 1331478;
  
  public static final int WedgeFrontGap = 1331479;
  
  public static final int WedgeTotalHeight = 1331480;
  
  public static final int WedgeFrontHeight = 1331481;
  
  public static final int WedgeRearHeight = 1331482;
  
  public static final int WedgeTotalWidth = 1331483;
  
  public static final int WedgeInContactWidth = 1331484;
  
  public static final int WedgeChamferHeight = 1331485;
  
  public static final int WedgeCurve = 1331486;
  
  public static final int RadiusAlongWedge = 1331487;
  
  public static final int ContrastBolusAgent = 1572880;
  
  public static final int ContrastBolusAgentSequence = 1572882;
  
  public static final int ContrastBolusT1Relaxivity = 1572883;
  
  public static final int ContrastBolusAdministrationRouteSequence = 1572884;
  
  public static final int BodyPartExamined = 1572885;
  
  public static final int ScanningSequence = 1572896;
  
  public static final int SequenceVariant = 1572897;
  
  public static final int ScanOptions = 1572898;
  
  public static final int MRAcquisitionType = 1572899;
  
  public static final int SequenceName = 1572900;
  
  public static final int AngioFlag = 1572901;
  
  public static final int InterventionDrugInformationSequence = 1572902;
  
  public static final int InterventionDrugStopTime = 1572903;
  
  public static final int InterventionDrugDose = 1572904;
  
  public static final int InterventionDrugCodeSequence = 1572905;
  
  public static final int AdditionalDrugSequence = 1572906;
  
  public static final int Radionuclide = 1572912;
  
  public static final int Radiopharmaceutical = 1572913;
  
  public static final int EnergyWindowCenterline = 1572914;
  
  public static final int EnergyWindowTotalWidth = 1572915;
  
  public static final int InterventionDrugName = 1572916;
  
  public static final int InterventionDrugStartTime = 1572917;
  
  public static final int InterventionSequence = 1572918;
  
  public static final int TherapyType = 1572919;
  
  public static final int InterventionStatus = 1572920;
  
  public static final int TherapyDescription = 1572921;
  
  public static final int InterventionDescription = 1572922;
  
  public static final int CineRate = 1572928;
  
  public static final int InitialCineRunState = 1572930;
  
  public static final int SliceThickness = 1572944;
  
  public static final int KVP = 1572960;
  
  public static final int CountsAccumulated = 1572976;
  
  public static final int AcquisitionTerminationCondition = 1572977;
  
  public static final int EffectiveDuration = 1572978;
  
  public static final int AcquisitionStartCondition = 1572979;
  
  public static final int AcquisitionStartConditionData = 1572980;
  
  public static final int AcquisitionTerminationConditionData = 1572981;
  
  public static final int RepetitionTime = 1572992;
  
  public static final int EchoTime = 1572993;
  
  public static final int InversionTime = 1572994;
  
  public static final int NumberOfAverages = 1572995;
  
  public static final int ImagingFrequency = 1572996;
  
  public static final int ImagedNucleus = 1572997;
  
  public static final int EchoNumbers = 1572998;
  
  public static final int MagneticFieldStrength = 1572999;
  
  public static final int SpacingBetweenSlices = 1573000;
  
  public static final int NumberOfPhaseEncodingSteps = 1573001;
  
  public static final int DataCollectionDiameter = 1573008;
  
  public static final int EchoTrainLength = 1573009;
  
  public static final int PercentSampling = 1573011;
  
  public static final int PercentPhaseFieldOfView = 1573012;
  
  public static final int PixelBandwidth = 1573013;
  
  public static final int DeviceSerialNumber = 1576960;
  
  public static final int DeviceUID = 1576962;
  
  public static final int DeviceID = 1576963;
  
  public static final int PlateID = 1576964;
  
  public static final int GeneratorID = 1576965;
  
  public static final int GridID = 1576966;
  
  public static final int CassetteID = 1576967;
  
  public static final int GantryID = 1576968;
  
  public static final int SecondaryCaptureDeviceID = 1576976;
  
  public static final int HardcopyCreationDeviceID = 1576977;
  
  public static final int DateOfSecondaryCapture = 1576978;
  
  public static final int TimeOfSecondaryCapture = 1576980;
  
  public static final int SecondaryCaptureDeviceManufacturer = 1576982;
  
  public static final int HardcopyDeviceManufacturer = 1576983;
  
  public static final int SecondaryCaptureDeviceManufacturerModelName = 1576984;
  
  public static final int SecondaryCaptureDeviceSoftwareVersions = 1576985;
  
  public static final int HardcopyDeviceSoftwareVersion = 1576986;
  
  public static final int HardcopyDeviceManufacturerModelName = 1576987;
  
  public static final int SoftwareVersions = 1576992;
  
  public static final int VideoImageFormatAcquired = 1576994;
  
  public static final int DigitalImageFormatAcquired = 1576995;
  
  public static final int ProtocolName = 1577008;
  
  public static final int ContrastBolusRoute = 1577024;
  
  public static final int ContrastBolusVolume = 1577025;
  
  public static final int ContrastBolusStartTime = 1577026;
  
  public static final int ContrastBolusStopTime = 1577027;
  
  public static final int ContrastBolusTotalDose = 1577028;
  
  public static final int SyringeCounts = 1577029;
  
  public static final int ContrastFlowRate = 1577030;
  
  public static final int ContrastFlowDuration = 1577031;
  
  public static final int ContrastBolusIngredient = 1577032;
  
  public static final int ContrastBolusIngredientConcentration = 1577033;
  
  public static final int SpatialResolution = 1577040;
  
  public static final int TriggerTime = 1577056;
  
  public static final int TriggerSourceOrType = 1577057;
  
  public static final int NominalInterval = 1577058;
  
  public static final int FrameTime = 1577059;
  
  public static final int CardiacFramingType = 1577060;
  
  public static final int FrameTimeVector = 1577061;
  
  public static final int FrameDelay = 1577062;
  
  public static final int ImageTriggerDelay = 1577063;
  
  public static final int MultiplexGroupTimeOffset = 1577064;
  
  public static final int TriggerTimeOffset = 1577065;
  
  public static final int SynchronizationTrigger = 1577066;
  
  public static final int SynchronizationChannel = 1577068;
  
  public static final int TriggerSamplePosition = 1577070;
  
  public static final int RadiopharmaceuticalRoute = 1577072;
  
  public static final int RadiopharmaceuticalVolume = 1577073;
  
  public static final int RadiopharmaceuticalStartTime = 1577074;
  
  public static final int RadiopharmaceuticalStopTime = 1577075;
  
  public static final int RadionuclideTotalDose = 1577076;
  
  public static final int RadionuclideHalfLife = 1577077;
  
  public static final int RadionuclidePositronFraction = 1577078;
  
  public static final int RadiopharmaceuticalSpecificActivity = 1577079;
  
  public static final int RadiopharmaceuticalStartDateTime = 1577080;
  
  public static final int RadiopharmaceuticalStopDateTime = 1577081;
  
  public static final int BeatRejectionFlag = 1577088;
  
  public static final int LowRRValue = 1577089;
  
  public static final int HighRRValue = 1577090;
  
  public static final int IntervalsAcquired = 1577091;
  
  public static final int IntervalsRejected = 1577092;
  
  public static final int PVCRejection = 1577093;
  
  public static final int SkipBeats = 1577094;
  
  public static final int HeartRate = 1577096;
  
  public static final int CardiacNumberOfImages = 1577104;
  
  public static final int TriggerWindow = 1577108;
  
  public static final int ReconstructionDiameter = 1577216;
  
  public static final int DistanceSourceToDetector = 1577232;
  
  public static final int DistanceSourceToPatient = 1577233;
  
  public static final int EstimatedRadiographicMagnificationFactor = 1577236;
  
  public static final int GantryDetectorTilt = 1577248;
  
  public static final int GantryDetectorSlew = 1577249;
  
  public static final int TableHeight = 1577264;
  
  public static final int TableTraverse = 1577265;
  
  public static final int TableMotion = 1577268;
  
  public static final int TableVerticalIncrement = 1577269;
  
  public static final int TableLateralIncrement = 1577270;
  
  public static final int TableLongitudinalIncrement = 1577271;
  
  public static final int TableAngle = 1577272;
  
  public static final int TableType = 1577274;
  
  public static final int RotationDirection = 1577280;
  
  public static final int AngularPosition = 1577281;
  
  public static final int RadialPosition = 1577282;
  
  public static final int ScanArc = 1577283;
  
  public static final int AngularStep = 1577284;
  
  public static final int CenterOfRotationOffset = 1577285;
  
  public static final int RotationOffset = 1577286;
  
  public static final int FieldOfViewShape = 1577287;
  
  public static final int FieldOfViewDimensions = 1577289;
  
  public static final int ExposureTime = 1577296;
  
  public static final int XRayTubeCurrent = 1577297;
  
  public static final int Exposure = 1577298;
  
  public static final int ExposureInuAs = 1577299;
  
  public static final int AveragePulseWidth = 1577300;
  
  public static final int RadiationSetting = 1577301;
  
  public static final int RectificationType = 1577302;
  
  public static final int RadiationMode = 1577306;
  
  public static final int ImageAndFluoroscopyAreaDoseProduct = 1577310;
  
  public static final int FilterType = 1577312;
  
  public static final int TypeOfFilters = 1577313;
  
  public static final int IntensifierSize = 1577314;
  
  public static final int ImagerPixelSpacing = 1577316;
  
  public static final int Grid = 1577318;
  
  public static final int GeneratorPower = 1577328;
  
  public static final int CollimatorGridName = 1577344;
  
  public static final int CollimatorType = 1577345;
  
  public static final int FocalDistance = 1577346;
  
  public static final int XFocusCenter = 1577347;
  
  public static final int YFocusCenter = 1577348;
  
  public static final int FocalSpots = 1577360;
  
  public static final int AnodeTargetMaterial = 1577361;
  
  public static final int BodyPartThickness = 1577376;
  
  public static final int CompressionForce = 1577378;
  
  public static final int PaddleDescription = 1577380;
  
  public static final int DateOfLastCalibration = 1577472;
  
  public static final int TimeOfLastCalibration = 1577473;
  
  public static final int DateTimeOfLastCalibration = 1577474;
  
  public static final int ConvolutionKernel = 1577488;
  
  public static final int UpperLowerPixelValues = 1577536;
  
  public static final int ActualFrameDuration = 1577538;
  
  public static final int CountRate = 1577539;
  
  public static final int PreferredPlaybackSequencing = 1577540;
  
  public static final int ReceiveCoilName = 1577552;
  
  public static final int TransmitCoilName = 1577553;
  
  public static final int PlateType = 1577568;
  
  public static final int PhosphorType = 1577569;
  
  public static final int ScanVelocity = 1577728;
  
  public static final int WholeBodyTechnique = 1577729;
  
  public static final int ScanLength = 1577730;
  
  public static final int AcquisitionMatrix = 1577744;
  
  public static final int InPlanePhaseEncodingDirection = 1577746;
  
  public static final int FlipAngle = 1577748;
  
  public static final int VariableFlipAngleFlag = 1577749;
  
  public static final int SAR = 1577750;
  
  public static final int dBdt = 1577752;
  
  public static final int AcquisitionDeviceProcessingDescription = 1577984;
  
  public static final int AcquisitionDeviceProcessingCode = 1577985;
  
  public static final int CassetteOrientation = 1577986;
  
  public static final int CassetteSize = 1577987;
  
  public static final int ExposuresOnPlate = 1577988;
  
  public static final int RelativeXRayExposure = 1577989;
  
  public static final int ExposureIndex = 1578001;
  
  public static final int TargetExposureIndex = 1578002;
  
  public static final int DeviationIndex = 1578003;
  
  public static final int ColumnAngulation = 1578064;
  
  public static final int TomoLayerHeight = 1578080;
  
  public static final int TomoAngle = 1578096;
  
  public static final int TomoTime = 1578112;
  
  public static final int TomoType = 1578128;
  
  public static final int TomoClass = 1578129;
  
  public static final int NumberOfTomosynthesisSourceImages = 1578133;
  
  public static final int PositionerMotion = 1578240;
  
  public static final int PositionerType = 1578248;
  
  public static final int PositionerPrimaryAngle = 1578256;
  
  public static final int PositionerSecondaryAngle = 1578257;
  
  public static final int PositionerPrimaryAngleIncrement = 1578272;
  
  public static final int PositionerSecondaryAngleIncrement = 1578273;
  
  public static final int DetectorPrimaryAngle = 1578288;
  
  public static final int DetectorSecondaryAngle = 1578289;
  
  public static final int ShutterShape = 1578496;
  
  public static final int ShutterLeftVerticalEdge = 1578498;
  
  public static final int ShutterRightVerticalEdge = 1578500;
  
  public static final int ShutterUpperHorizontalEdge = 1578502;
  
  public static final int ShutterLowerHorizontalEdge = 1578504;
  
  public static final int CenterOfCircularShutter = 1578512;
  
  public static final int RadiusOfCircularShutter = 1578514;
  
  public static final int VerticesOfThePolygonalShutter = 1578528;
  
  public static final int ShutterPresentationValue = 1578530;
  
  public static final int ShutterOverlayGroup = 1578531;
  
  public static final int ShutterPresentationColorCIELabValue = 1578532;
  
  public static final int CollimatorShape = 1578752;
  
  public static final int CollimatorLeftVerticalEdge = 1578754;
  
  public static final int CollimatorRightVerticalEdge = 1578756;
  
  public static final int CollimatorUpperHorizontalEdge = 1578758;
  
  public static final int CollimatorLowerHorizontalEdge = 1578760;
  
  public static final int CenterOfCircularCollimator = 1578768;
  
  public static final int RadiusOfCircularCollimator = 1578770;
  
  public static final int VerticesOfThePolygonalCollimator = 1578784;
  
  public static final int AcquisitionTimeSynchronized = 1579008;
  
  public static final int TimeSource = 1579009;
  
  public static final int TimeDistributionProtocol = 1579010;
  
  public static final int NTPSourceAddress = 1579011;
  
  public static final int PageNumberVector = 1581057;
  
  public static final int FrameLabelVector = 1581058;
  
  public static final int FramePrimaryAngleVector = 1581059;
  
  public static final int FrameSecondaryAngleVector = 1581060;
  
  public static final int SliceLocationVector = 1581061;
  
  public static final int DisplayWindowLabelVector = 1581062;
  
  public static final int NominalScannedPixelSpacing = 1581072;
  
  public static final int DigitizingDeviceTransportDirection = 1581088;
  
  public static final int RotationOfScannedFilm = 1581104;
  
  public static final int BiopsyTargetSequence = 1581121;
  
  public static final int TargetUID = 1581122;
  
  public static final int LocalizingCursorPosition = 1581123;
  
  public static final int CalculatedTargetPosition = 1581124;
  
  public static final int TargetLabel = 1581125;
  
  public static final int DisplayedZValue = 1581126;
  
  public static final int IVUSAcquisition = 1585408;
  
  public static final int IVUSPullbackRate = 1585409;
  
  public static final int IVUSGatedRate = 1585410;
  
  public static final int IVUSPullbackStartFrameNumber = 1585411;
  
  public static final int IVUSPullbackStopFrameNumber = 1585412;
  
  public static final int LesionNumber = 1585413;
  
  public static final int AcquisitionComments = 1589248;
  
  public static final int OutputPower = 1593344;
  
  public static final int TransducerData = 1593360;
  
  public static final int FocusDepth = 1593362;
  
  public static final int ProcessingFunction = 1593376;
  
  public static final int PostprocessingFunction = 1593377;
  
  public static final int MechanicalIndex = 1593378;
  
  public static final int BoneThermalIndex = 1593380;
  
  public static final int CranialThermalIndex = 1593382;
  
  public static final int SoftTissueThermalIndex = 1593383;
  
  public static final int SoftTissueFocusThermalIndex = 1593384;
  
  public static final int SoftTissueSurfaceThermalIndex = 1593385;
  
  public static final int DynamicRange = 1593392;
  
  public static final int TotalGain = 1593408;
  
  public static final int DepthOfScanField = 1593424;
  
  public static final int PatientPosition = 1593600;
  
  public static final int ViewPosition = 1593601;
  
  public static final int ProjectionEponymousNameCodeSequence = 1593604;
  
  public static final int ImageTransformationMatrix = 1593872;
  
  public static final int ImageTranslationVector = 1593874;
  
  public static final int Sensitivity = 1597440;
  
  public static final int SequenceOfUltrasoundRegions = 1597457;
  
  public static final int RegionSpatialFormat = 1597458;
  
  public static final int RegionDataType = 1597460;
  
  public static final int RegionFlags = 1597462;
  
  public static final int RegionLocationMinX0 = 1597464;
  
  public static final int RegionLocationMinY0 = 1597466;
  
  public static final int RegionLocationMaxX1 = 1597468;
  
  public static final int RegionLocationMaxY1 = 1597470;
  
  public static final int ReferencePixelX0 = 1597472;
  
  public static final int ReferencePixelY0 = 1597474;
  
  public static final int PhysicalUnitsXDirection = 1597476;
  
  public static final int PhysicalUnitsYDirection = 1597478;
  
  public static final int ReferencePixelPhysicalValueX = 1597480;
  
  public static final int ReferencePixelPhysicalValueY = 1597482;
  
  public static final int PhysicalDeltaX = 1597484;
  
  public static final int PhysicalDeltaY = 1597486;
  
  public static final int TransducerFrequency = 1597488;
  
  public static final int TransducerType = 1597489;
  
  public static final int PulseRepetitionFrequency = 1597490;
  
  public static final int DopplerCorrectionAngle = 1597492;
  
  public static final int SteeringAngle = 1597494;
  
  public static final int DopplerSampleVolumeXPositionRetired = 1597496;
  
  public static final int DopplerSampleVolumeXPosition = 1597497;
  
  public static final int DopplerSampleVolumeYPositionRetired = 1597498;
  
  public static final int DopplerSampleVolumeYPosition = 1597499;
  
  public static final int TMLinePositionX0Retired = 1597500;
  
  public static final int TMLinePositionX0 = 1597501;
  
  public static final int TMLinePositionY0Retired = 1597502;
  
  public static final int TMLinePositionY0 = 1597503;
  
  public static final int TMLinePositionX1Retired = 1597504;
  
  public static final int TMLinePositionX1 = 1597505;
  
  public static final int TMLinePositionY1Retired = 1597506;
  
  public static final int TMLinePositionY1 = 1597507;
  
  public static final int PixelComponentOrganization = 1597508;
  
  public static final int PixelComponentMask = 1597510;
  
  public static final int PixelComponentRangeStart = 1597512;
  
  public static final int PixelComponentRangeStop = 1597514;
  
  public static final int PixelComponentPhysicalUnits = 1597516;
  
  public static final int PixelComponentDataType = 1597518;
  
  public static final int NumberOfTableBreakPoints = 1597520;
  
  public static final int TableOfXBreakPoints = 1597522;
  
  public static final int TableOfYBreakPoints = 1597524;
  
  public static final int NumberOfTableEntries = 1597526;
  
  public static final int TableOfPixelValues = 1597528;
  
  public static final int TableOfParameterValues = 1597530;
  
  public static final int RWaveTimeVector = 1597536;
  
  public static final int DetectorConditionsNominalFlag = 1601536;
  
  public static final int DetectorTemperature = 1601537;
  
  public static final int DetectorType = 1601540;
  
  public static final int DetectorConfiguration = 1601541;
  
  public static final int DetectorDescription = 1601542;
  
  public static final int DetectorMode = 1601544;
  
  public static final int DetectorID = 1601546;
  
  public static final int DateOfLastDetectorCalibration = 1601548;
  
  public static final int TimeOfLastDetectorCalibration = 1601550;
  
  public static final int ExposuresOnDetectorSinceLastCalibration = 1601552;
  
  public static final int ExposuresOnDetectorSinceManufactured = 1601553;
  
  public static final int DetectorTimeSinceLastExposure = 1601554;
  
  public static final int DetectorActiveTime = 1601556;
  
  public static final int DetectorActivationOffsetFromExposure = 1601558;
  
  public static final int DetectorBinning = 1601562;
  
  public static final int DetectorElementPhysicalSize = 1601568;
  
  public static final int DetectorElementSpacing = 1601570;
  
  public static final int DetectorActiveShape = 1601572;
  
  public static final int DetectorActiveDimensions = 1601574;
  
  public static final int DetectorActiveOrigin = 1601576;
  
  public static final int DetectorManufacturerName = 1601578;
  
  public static final int DetectorManufacturerModelName = 1601579;
  
  public static final int FieldOfViewOrigin = 1601584;
  
  public static final int FieldOfViewRotation = 1601586;
  
  public static final int FieldOfViewHorizontalFlip = 1601588;
  
  public static final int PixelDataAreaOriginRelativeToFOV = 1601590;
  
  public static final int PixelDataAreaRotationAngleRelativeToFOV = 1601592;
  
  public static final int GridAbsorbingMaterial = 1601600;
  
  public static final int GridSpacingMaterial = 1601601;
  
  public static final int GridThickness = 1601602;
  
  public static final int GridPitch = 1601604;
  
  public static final int GridAspectRatio = 1601606;
  
  public static final int GridPeriod = 1601608;
  
  public static final int GridFocalDistance = 1601612;
  
  public static final int FilterMaterial = 1601616;
  
  public static final int FilterThicknessMinimum = 1601618;
  
  public static final int FilterThicknessMaximum = 1601620;
  
  public static final int FilterBeamPathLengthMinimum = 1601622;
  
  public static final int FilterBeamPathLengthMaximum = 1601624;
  
  public static final int ExposureControlMode = 1601632;
  
  public static final int ExposureControlModeDescription = 1601634;
  
  public static final int ExposureStatus = 1601636;
  
  public static final int PhototimerSetting = 1601637;
  
  public static final int ExposureTimeInuS = 1605968;
  
  public static final int XRayTubeCurrentInuA = 1605969;
  
  public static final int ContentQualification = 1609732;
  
  public static final int PulseSequenceName = 1609733;
  
  public static final int MRImagingModifierSequence = 1609734;
  
  public static final int EchoPulseSequence = 1609736;
  
  public static final int InversionRecovery = 1609737;
  
  public static final int FlowCompensation = 1609744;
  
  public static final int MultipleSpinEcho = 1609745;
  
  public static final int MultiPlanarExcitation = 1609746;
  
  public static final int PhaseContrast = 1609748;
  
  public static final int TimeOfFlightContrast = 1609749;
  
  public static final int Spoiling = 1609750;
  
  public static final int SteadyStatePulseSequence = 1609751;
  
  public static final int EchoPlanarPulseSequence = 1609752;
  
  public static final int TagAngleFirstAxis = 1609753;
  
  public static final int MagnetizationTransfer = 1609760;
  
  public static final int T2Preparation = 1609761;
  
  public static final int BloodSignalNulling = 1609762;
  
  public static final int SaturationRecovery = 1609764;
  
  public static final int SpectrallySelectedSuppression = 1609765;
  
  public static final int SpectrallySelectedExcitation = 1609766;
  
  public static final int SpatialPresaturation = 1609767;
  
  public static final int Tagging = 1609768;
  
  public static final int OversamplingPhase = 1609769;
  
  public static final int TagSpacingFirstDimension = 1609776;
  
  public static final int GeometryOfKSpaceTraversal = 1609778;
  
  public static final int SegmentedKSpaceTraversal = 1609779;
  
  public static final int RectilinearPhaseEncodeReordering = 1609780;
  
  public static final int TagThickness = 1609781;
  
  public static final int PartialFourierDirection = 1609782;
  
  public static final int CardiacSynchronizationTechnique = 1609783;
  
  public static final int ReceiveCoilManufacturerName = 1609793;
  
  public static final int MRReceiveCoilSequence = 1609794;
  
  public static final int ReceiveCoilType = 1609795;
  
  public static final int QuadratureReceiveCoil = 1609796;
  
  public static final int MultiCoilDefinitionSequence = 1609797;
  
  public static final int MultiCoilConfiguration = 1609798;
  
  public static final int MultiCoilElementName = 1609799;
  
  public static final int MultiCoilElementUsed = 1609800;
  
  public static final int MRTransmitCoilSequence = 1609801;
  
  public static final int TransmitCoilManufacturerName = 1609808;
  
  public static final int TransmitCoilType = 1609809;
  
  public static final int SpectralWidth = 1609810;
  
  public static final int ChemicalShiftReference = 1609811;
  
  public static final int VolumeLocalizationTechnique = 1609812;
  
  public static final int MRAcquisitionFrequencyEncodingSteps = 1609816;
  
  public static final int Decoupling = 1609817;
  
  public static final int DecoupledNucleus = 1609824;
  
  public static final int DecouplingFrequency = 1609825;
  
  public static final int DecouplingMethod = 1609826;
  
  public static final int DecouplingChemicalShiftReference = 1609827;
  
  public static final int KSpaceFiltering = 1609828;
  
  public static final int TimeDomainFiltering = 1609829;
  
  public static final int NumberOfZeroFills = 1609830;
  
  public static final int BaselineCorrection = 1609831;
  
  public static final int ParallelReductionFactorInPlane = 1609833;
  
  public static final int CardiacRRIntervalSpecified = 1609840;
  
  public static final int AcquisitionDuration = 1609843;
  
  public static final int FrameAcquisitionDateTime = 1609844;
  
  public static final int DiffusionDirectionality = 1609845;
  
  public static final int DiffusionGradientDirectionSequence = 1609846;
  
  public static final int ParallelAcquisition = 1609847;
  
  public static final int ParallelAcquisitionTechnique = 1609848;
  
  public static final int InversionTimes = 1609849;
  
  public static final int MetaboliteMapDescription = 1609856;
  
  public static final int PartialFourier = 1609857;
  
  public static final int EffectiveEchoTime = 1609858;
  
  public static final int MetaboliteMapCodeSequence = 1609859;
  
  public static final int ChemicalShiftSequence = 1609860;
  
  public static final int CardiacSignalSource = 1609861;
  
  public static final int DiffusionBValue = 1609863;
  
  public static final int DiffusionGradientOrientation = 1609865;
  
  public static final int VelocityEncodingDirection = 1609872;
  
  public static final int VelocityEncodingMinimumValue = 1609873;
  
  public static final int VelocityEncodingAcquisitionSequence = 1609874;
  
  public static final int NumberOfKSpaceTrajectories = 1609875;
  
  public static final int CoverageOfKSpace = 1609876;
  
  public static final int SpectroscopyAcquisitionPhaseRows = 1609877;
  
  public static final int ParallelReductionFactorInPlaneRetired = 1609878;
  
  public static final int TransmitterFrequency = 1609880;
  
  public static final int ResonantNucleus = 1609984;
  
  public static final int FrequencyCorrection = 1609985;
  
  public static final int MRSpectroscopyFOVGeometrySequence = 1609987;
  
  public static final int SlabThickness = 1609988;
  
  public static final int SlabOrientation = 1609989;
  
  public static final int MidSlabPosition = 1609990;
  
  public static final int MRSpatialSaturationSequence = 1609991;
  
  public static final int MRTimingAndRelatedParametersSequence = 1610002;
  
  public static final int MREchoSequence = 1610004;
  
  public static final int MRModifierSequence = 1610005;
  
  public static final int MRDiffusionSequence = 1610007;
  
  public static final int CardiacSynchronizationSequence = 1610008;
  
  public static final int MRAveragesSequence = 1610009;
  
  public static final int MRFOVGeometrySequence = 1610021;
  
  public static final int VolumeLocalizationSequence = 1610022;
  
  public static final int SpectroscopyAcquisitionDataColumns = 1610023;
  
  public static final int DiffusionAnisotropyType = 1610055;
  
  public static final int FrameReferenceDateTime = 1610065;
  
  public static final int MRMetaboliteMapSequence = 1610066;
  
  public static final int ParallelReductionFactorOutOfPlane = 1610069;
  
  public static final int SpectroscopyAcquisitionOutOfPlanePhaseSteps = 1610073;
  
  public static final int BulkMotionStatus = 1610086;
  
  public static final int ParallelReductionFactorSecondInPlane = 1610088;
  
  public static final int CardiacBeatRejectionTechnique = 1610089;
  
  public static final int RespiratoryMotionCompensationTechnique = 1610096;
  
  public static final int RespiratorySignalSource = 1610097;
  
  public static final int BulkMotionCompensationTechnique = 1610098;
  
  public static final int BulkMotionSignalSource = 1610099;
  
  public static final int ApplicableSafetyStandardAgency = 1610100;
  
  public static final int ApplicableSafetyStandardDescription = 1610101;
  
  public static final int OperatingModeSequence = 1610102;
  
  public static final int OperatingModeType = 1610103;
  
  public static final int OperatingMode = 1610104;
  
  public static final int SpecificAbsorptionRateDefinition = 1610105;
  
  public static final int GradientOutputType = 1610112;
  
  public static final int SpecificAbsorptionRateValue = 1610113;
  
  public static final int GradientOutput = 1610114;
  
  public static final int FlowCompensationDirection = 1610115;
  
  public static final int TaggingDelay = 1610116;
  
  public static final int RespiratoryMotionCompensationTechniqueDescription = 1610117;
  
  public static final int RespiratorySignalSourceID = 1610118;
  
  public static final int ChemicalShiftMinimumIntegrationLimitInHz = 1610133;
  
  public static final int ChemicalShiftMaximumIntegrationLimitInHz = 1610134;
  
  public static final int MRVelocityEncodingSequence = 1610135;
  
  public static final int FirstOrderPhaseCorrection = 1610136;
  
  public static final int WaterReferencedPhaseCorrection = 1610137;
  
  public static final int MRSpectroscopyAcquisitionType = 1610240;
  
  public static final int RespiratoryCyclePosition = 1610260;
  
  public static final int VelocityEncodingMaximumValue = 1610263;
  
  public static final int TagSpacingSecondDimension = 1610264;
  
  public static final int TagAngleSecondAxis = 1610265;
  
  public static final int FrameAcquisitionDuration = 1610272;
  
  public static final int MRImageFrameTypeSequence = 1610278;
  
  public static final int MRSpectroscopyFrameTypeSequence = 1610279;
  
  public static final int MRAcquisitionPhaseEncodingStepsInPlane = 1610289;
  
  public static final int MRAcquisitionPhaseEncodingStepsOutOfPlane = 1610290;
  
  public static final int SpectroscopyAcquisitionPhaseColumns = 1610292;
  
  public static final int CardiacCyclePosition = 1610294;
  
  public static final int SpecificAbsorptionRateSequence = 1610297;
  
  public static final int RFEchoTrainLength = 1610304;
  
  public static final int GradientEchoTrainLength = 1610305;
  
  public static final int ArterialSpinLabelingContrast = 1610320;
  
  public static final int MRArterialSpinLabelingSequence = 1610321;
  
  public static final int ASLTechniqueDescription = 1610322;
  
  public static final int ASLSlabNumber = 1610323;
  
  public static final int ASLSlabThickness = 1610324;
  
  public static final int ASLSlabOrientation = 1610325;
  
  public static final int ASLMidSlabPosition = 1610326;
  
  public static final int ASLContext = 1610327;
  
  public static final int ASLPulseTrainDuration = 1610328;
  
  public static final int ASLCrusherFlag = 1610329;
  
  public static final int ASLCrusherFlowLimit = 1610330;
  
  public static final int ASLCrusherDescription = 1610331;
  
  public static final int ASLBolusCutoffFlag = 1610332;
  
  public static final int ASLBolusCutoffTimingSequence = 1610333;
  
  public static final int ASLBolusCutoffTechnique = 1610334;
  
  public static final int ASLBolusCutoffDelayTime = 1610335;
  
  public static final int ASLSlabSequence = 1610336;
  
  public static final int ChemicalShiftMinimumIntegrationLimitInppm = 1610389;
  
  public static final int ChemicalShiftMaximumIntegrationLimitInppm = 1610390;
  
  public static final int WaterReferenceAcquisition = 1610391;
  
  public static final int EchoPeakPosition = 1610392;
  
  public static final int CTAcquisitionTypeSequence = 1610497;
  
  public static final int AcquisitionType = 1610498;
  
  public static final int TubeAngle = 1610499;
  
  public static final int CTAcquisitionDetailsSequence = 1610500;
  
  public static final int RevolutionTime = 1610501;
  
  public static final int SingleCollimationWidth = 1610502;
  
  public static final int TotalCollimationWidth = 1610503;
  
  public static final int CTTableDynamicsSequence = 1610504;
  
  public static final int TableSpeed = 1610505;
  
  public static final int TableFeedPerRotation = 1610512;
  
  public static final int SpiralPitchFactor = 1610513;
  
  public static final int CTGeometrySequence = 1610514;
  
  public static final int DataCollectionCenterPatient = 1610515;
  
  public static final int CTReconstructionSequence = 1610516;
  
  public static final int ReconstructionAlgorithm = 1610517;
  
  public static final int ConvolutionKernelGroup = 1610518;
  
  public static final int ReconstructionFieldOfView = 1610519;
  
  public static final int ReconstructionTargetCenterPatient = 1610520;
  
  public static final int ReconstructionAngle = 1610521;
  
  public static final int ImageFilter = 1610528;
  
  public static final int CTExposureSequence = 1610529;
  
  public static final int ReconstructionPixelSpacing = 1610530;
  
  public static final int ExposureModulationType = 1610531;
  
  public static final int EstimatedDoseSaving = 1610532;
  
  public static final int CTXRayDetailsSequence = 1610533;
  
  public static final int CTPositionSequence = 1610534;
  
  public static final int TablePosition = 1610535;
  
  public static final int ExposureTimeInms = 1610536;
  
  public static final int CTImageFrameTypeSequence = 1610537;
  
  public static final int XRayTubeCurrentInmA = 1610544;
  
  public static final int ExposureInmAs = 1610546;
  
  public static final int ConstantVolumeFlag = 1610547;
  
  public static final int FluoroscopyFlag = 1610548;
  
  public static final int DistanceSourceToDataCollectionCenter = 1610549;
  
  public static final int ContrastBolusAgentNumber = 1610551;
  
  public static final int ContrastBolusIngredientCodeSequence = 1610552;
  
  public static final int ContrastAdministrationProfileSequence = 1610560;
  
  public static final int ContrastBolusUsageSequence = 1610561;
  
  public static final int ContrastBolusAgentAdministered = 1610562;
  
  public static final int ContrastBolusAgentDetected = 1610563;
  
  public static final int ContrastBolusAgentPhase = 1610564;
  
  public static final int CTDIvol = 1610565;
  
  public static final int CTDIPhantomTypeCodeSequence = 1610566;
  
  public static final int CalciumScoringMassFactorPatient = 1610577;
  
  public static final int CalciumScoringMassFactorDevice = 1610578;
  
  public static final int EnergyWeightingFactor = 1610579;
  
  public static final int CTAdditionalXRaySourceSequence = 1610592;
  
  public static final int ProjectionPixelCalibrationSequence = 1610753;
  
  public static final int DistanceSourceToIsocenter = 1610754;
  
  public static final int DistanceObjectToTableTop = 1610755;
  
  public static final int ObjectPixelSpacingInCenterOfBeam = 1610756;
  
  public static final int PositionerPositionSequence = 1610757;
  
  public static final int TablePositionSequence = 1610758;
  
  public static final int CollimatorShapeSequence = 1610759;
  
  public static final int PlanesInAcquisition = 1610768;
  
  public static final int XAXRFFrameCharacteristicsSequence = 1610770;
  
  public static final int FrameAcquisitionSequence = 1610775;
  
  public static final int XRayReceptorType = 1610784;
  
  public static final int AcquisitionProtocolName = 1610787;
  
  public static final int AcquisitionProtocolDescription = 1610788;
  
  public static final int ContrastBolusIngredientOpaque = 1610789;
  
  public static final int DistanceReceptorPlaneToDetectorHousing = 1610790;
  
  public static final int IntensifierActiveShape = 1610791;
  
  public static final int IntensifierActiveDimensions = 1610792;
  
  public static final int PhysicalDetectorSize = 1610793;
  
  public static final int PositionOfIsocenterProjection = 1610800;
  
  public static final int FieldOfViewSequence = 1610802;
  
  public static final int FieldOfViewDescription = 1610803;
  
  public static final int ExposureControlSensingRegionsSequence = 1610804;
  
  public static final int ExposureControlSensingRegionShape = 1610805;
  
  public static final int ExposureControlSensingRegionLeftVerticalEdge = 1610806;
  
  public static final int ExposureControlSensingRegionRightVerticalEdge = 1610807;
  
  public static final int ExposureControlSensingRegionUpperHorizontalEdge = 1610808;
  
  public static final int ExposureControlSensingRegionLowerHorizontalEdge = 1610809;
  
  public static final int CenterOfCircularExposureControlSensingRegion = 1610816;
  
  public static final int RadiusOfCircularExposureControlSensingRegion = 1610817;
  
  public static final int VerticesOfThePolygonalExposureControlSensingRegion = 1610818;
  
  public static final int ColumnAngulationPatient = 1610823;
  
  public static final int BeamAngle = 1610825;
  
  public static final int FrameDetectorParametersSequence = 1610833;
  
  public static final int CalculatedAnatomyThickness = 1610834;
  
  public static final int CalibrationSequence = 1610837;
  
  public static final int ObjectThicknessSequence = 1610838;
  
  public static final int PlaneIdentification = 1610839;
  
  public static final int FieldOfViewDimensionsInFloat = 1610849;
  
  public static final int IsocenterReferenceSystemSequence = 1610850;
  
  public static final int PositionerIsocenterPrimaryAngle = 1610851;
  
  public static final int PositionerIsocenterSecondaryAngle = 1610852;
  
  public static final int PositionerIsocenterDetectorRotationAngle = 1610853;
  
  public static final int TableXPositionToIsocenter = 1610854;
  
  public static final int TableYPositionToIsocenter = 1610855;
  
  public static final int TableZPositionToIsocenter = 1610856;
  
  public static final int TableHorizontalRotationAngle = 1610857;
  
  public static final int TableHeadTiltAngle = 1610864;
  
  public static final int TableCradleTiltAngle = 1610865;
  
  public static final int FrameDisplayShutterSequence = 1610866;
  
  public static final int AcquiredImageAreaDoseProduct = 1610867;
  
  public static final int CArmPositionerTabletopRelationship = 1610868;
  
  public static final int XRayGeometrySequence = 1610870;
  
  public static final int IrradiationEventIdentificationSequence = 1610871;
  
  public static final int XRay3DFrameTypeSequence = 1611012;
  
  public static final int ContributingSourcesSequence = 1611014;
  
  public static final int XRay3DAcquisitionSequence = 1611015;
  
  public static final int PrimaryPositionerScanArc = 1611016;
  
  public static final int SecondaryPositionerScanArc = 1611017;
  
  public static final int PrimaryPositionerScanStartAngle = 1611024;
  
  public static final int SecondaryPositionerScanStartAngle = 1611025;
  
  public static final int PrimaryPositionerIncrement = 1611028;
  
  public static final int SecondaryPositionerIncrement = 1611029;
  
  public static final int StartAcquisitionDateTime = 1611030;
  
  public static final int EndAcquisitionDateTime = 1611031;
  
  public static final int PrimaryPositionerIncrementSign = 1611032;
  
  public static final int SecondaryPositionerIncrementSign = 1611033;
  
  public static final int ApplicationName = 1611044;
  
  public static final int ApplicationVersion = 1611045;
  
  public static final int ApplicationManufacturer = 1611046;
  
  public static final int AlgorithmType = 1611047;
  
  public static final int AlgorithmDescription = 1611048;
  
  public static final int XRay3DReconstructionSequence = 1611056;
  
  public static final int ReconstructionDescription = 1611057;
  
  public static final int PerProjectionAcquisitionSequence = 1611064;
  
  public static final int DetectorPositionSequence = 1611073;
  
  public static final int XRayAcquisitionDoseSequence = 1611074;
  
  public static final int XRaySourceIsocenterPrimaryAngle = 1611075;
  
  public static final int XRaySourceIsocenterSecondaryAngle = 1611076;
  
  public static final int BreastSupportIsocenterPrimaryAngle = 1611077;
  
  public static final int BreastSupportIsocenterSecondaryAngle = 1611078;
  
  public static final int BreastSupportXPositionToIsocenter = 1611079;
  
  public static final int BreastSupportYPositionToIsocenter = 1611080;
  
  public static final int BreastSupportZPositionToIsocenter = 1611081;
  
  public static final int DetectorIsocenterPrimaryAngle = 1611088;
  
  public static final int DetectorIsocenterSecondaryAngle = 1611089;
  
  public static final int DetectorXPositionToIsocenter = 1611090;
  
  public static final int DetectorYPositionToIsocenter = 1611091;
  
  public static final int DetectorZPositionToIsocenter = 1611092;
  
  public static final int XRayGridSequence = 1611093;
  
  public static final int XRayFilterSequence = 1611094;
  
  public static final int DetectorActiveAreaTLHCPosition = 1611095;
  
  public static final int DetectorActiveAreaOrientation = 1611096;
  
  public static final int PositionerPrimaryAngleDirection = 1611097;
  
  public static final int DiffusionBMatrixSequence = 1611265;
  
  public static final int DiffusionBValueXX = 1611266;
  
  public static final int DiffusionBValueXY = 1611267;
  
  public static final int DiffusionBValueXZ = 1611268;
  
  public static final int DiffusionBValueYY = 1611269;
  
  public static final int DiffusionBValueYZ = 1611270;
  
  public static final int DiffusionBValueZZ = 1611271;
  
  public static final int DecayCorrectionDateTime = 1611521;
  
  public static final int StartDensityThreshold = 1611541;
  
  public static final int StartRelativeDensityDifferenceThreshold = 1611542;
  
  public static final int StartCardiacTriggerCountThreshold = 1611543;
  
  public static final int StartRespiratoryTriggerCountThreshold = 1611544;
  
  public static final int TerminationCountsThreshold = 1611545;
  
  public static final int TerminationDensityThreshold = 1611552;
  
  public static final int TerminationRelativeDensityThreshold = 1611553;
  
  public static final int TerminationTimeThreshold = 1611554;
  
  public static final int TerminationCardiacTriggerCountThreshold = 1611555;
  
  public static final int TerminationRespiratoryTriggerCountThreshold = 1611556;
  
  public static final int DetectorGeometry = 1611557;
  
  public static final int TransverseDetectorSeparation = 1611558;
  
  public static final int AxialDetectorDimension = 1611559;
  
  public static final int RadiopharmaceuticalAgentNumber = 1611561;
  
  public static final int PETFrameAcquisitionSequence = 1611570;
  
  public static final int PETDetectorMotionDetailsSequence = 1611571;
  
  public static final int PETTableDynamicsSequence = 1611572;
  
  public static final int PETPositionSequence = 1611573;
  
  public static final int PETFrameCorrectionFactorsSequence = 1611574;
  
  public static final int RadiopharmaceuticalUsageSequence = 1611575;
  
  public static final int AttenuationCorrectionSource = 1611576;
  
  public static final int NumberOfIterations = 1611577;
  
  public static final int NumberOfSubsets = 1611584;
  
  public static final int PETReconstructionSequence = 1611593;
  
  public static final int PETFrameTypeSequence = 1611601;
  
  public static final int TimeOfFlightInformationUsed = 1611605;
  
  public static final int ReconstructionType = 1611606;
  
  public static final int DecayCorrected = 1611608;
  
  public static final int AttenuationCorrected = 1611609;
  
  public static final int ScatterCorrected = 1611616;
  
  public static final int DeadTimeCorrected = 1611617;
  
  public static final int GantryMotionCorrected = 1611618;
  
  public static final int PatientMotionCorrected = 1611619;
  
  public static final int CountLossNormalizationCorrected = 1611620;
  
  public static final int RandomsCorrected = 1611621;
  
  public static final int NonUniformRadialSamplingCorrected = 1611622;
  
  public static final int SensitivityCalibrated = 1611623;
  
  public static final int DetectorNormalizationCorrection = 1611624;
  
  public static final int IterativeReconstructionMethod = 1611625;
  
  public static final int AttenuationCorrectionTemporalRelationship = 1611632;
  
  public static final int PatientPhysiologicalStateSequence = 1611633;
  
  public static final int PatientPhysiologicalStateCodeSequence = 1611634;
  
  public static final int DepthsOfFocus = 1611777;
  
  public static final int ExcludedIntervalsSequence = 1611779;
  
  public static final int ExclusionStartDateTime = 1611780;
  
  public static final int ExclusionDuration = 1611781;
  
  public static final int USImageDescriptionSequence = 1611782;
  
  public static final int ImageDataTypeSequence = 1611783;
  
  public static final int DataType = 1611784;
  
  public static final int TransducerScanPatternCodeSequence = 1611785;
  
  public static final int AliasedDataType = 1611787;
  
  public static final int PositionMeasuringDeviceUsed = 1611788;
  
  public static final int TransducerGeometryCodeSequence = 1611789;
  
  public static final int TransducerBeamSteeringCodeSequence = 1611790;
  
  public static final int TransducerApplicationCodeSequence = 1611791;
  
  public static final int ZeroVelocityPixelValue = 1611792;
  
  public static final int ContributingEquipmentSequence = 1613825;
  
  public static final int ContributionDateTime = 1613826;
  
  public static final int ContributionDescription = 1613827;
  
  public static final int StudyInstanceUID = 2097165;
  
  public static final int SeriesInstanceUID = 2097166;
  
  public static final int StudyID = 2097168;
  
  public static final int SeriesNumber = 2097169;
  
  public static final int AcquisitionNumber = 2097170;
  
  public static final int InstanceNumber = 2097171;
  
  public static final int IsotopeNumber = 2097172;
  
  public static final int PhaseNumber = 2097173;
  
  public static final int IntervalNumber = 2097174;
  
  public static final int TimeSlotNumber = 2097175;
  
  public static final int AngleNumber = 2097176;
  
  public static final int ItemNumber = 2097177;
  
  public static final int PatientOrientation = 2097184;
  
  public static final int OverlayNumber = 2097186;
  
  public static final int CurveNumber = 2097188;
  
  public static final int LUTNumber = 2097190;
  
  public static final int ImagePosition = 2097200;
  
  public static final int ImagePositionPatient = 2097202;
  
  public static final int ImageOrientation = 2097205;
  
  public static final int ImageOrientationPatient = 2097207;
  
  public static final int Location = 2097232;
  
  public static final int FrameOfReferenceUID = 2097234;
  
  public static final int Laterality = 2097248;
  
  public static final int ImageLaterality = 2097250;
  
  public static final int ImageGeometryType = 2097264;
  
  public static final int MaskingImage = 2097280;
  
  public static final int ReportNumber = 2097322;
  
  public static final int TemporalPositionIdentifier = 2097408;
  
  public static final int NumberOfTemporalPositions = 2097413;
  
  public static final int TemporalResolution = 2097424;
  
  public static final int SynchronizationFrameOfReferenceUID = 2097664;
  
  public static final int SOPInstanceUIDOfConcatenationSource = 2097730;
  
  public static final int SeriesInStudy = 2101248;
  
  public static final int AcquisitionsInSeries = 2101249;
  
  public static final int ImagesInAcquisition = 2101250;
  
  public static final int ImagesInSeries = 2101251;
  
  public static final int AcquisitionsInStudy = 2101252;
  
  public static final int ImagesInStudy = 2101253;
  
  public static final int Reference = 2101280;
  
  public static final int PositionReferenceIndicator = 2101312;
  
  public static final int SliceLocation = 2101313;
  
  public static final int OtherStudyNumbers = 2101360;
  
  public static final int NumberOfPatientRelatedStudies = 2101760;
  
  public static final int NumberOfPatientRelatedSeries = 2101762;
  
  public static final int NumberOfPatientRelatedInstances = 2101764;
  
  public static final int NumberOfStudyRelatedSeries = 2101766;
  
  public static final int NumberOfStudyRelatedInstances = 2101768;
  
  public static final int NumberOfSeriesRelatedInstances = 2101769;
  
  public static final int SourceImageIDs = 2109696;
  
  public static final int ModifyingDeviceID = 2110465;
  
  public static final int ModifiedImageID = 2110466;
  
  public static final int ModifiedImageDate = 2110467;
  
  public static final int ModifyingDeviceManufacturer = 2110468;
  
  public static final int ModifiedImageTime = 2110469;
  
  public static final int ModifiedImageDescription = 2110470;
  
  public static final int ImageComments = 2113536;
  
  public static final int OriginalImageIdentification = 2117632;
  
  public static final int OriginalImageIdentificationNomenclature = 2117634;
  
  public static final int StackID = 2134102;
  
  public static final int InStackPositionNumber = 2134103;
  
  public static final int FrameAnatomySequence = 2134129;
  
  public static final int FrameLaterality = 2134130;
  
  public static final int FrameContentSequence = 2134289;
  
  public static final int PlanePositionSequence = 2134291;
  
  public static final int PlaneOrientationSequence = 2134294;
  
  public static final int TemporalPositionIndex = 2134312;
  
  public static final int NominalCardiacTriggerDelayTime = 2134355;
  
  public static final int NominalCardiacTriggerTimePriorToRPeak = 2134356;
  
  public static final int ActualCardiacTriggerTimePriorToRPeak = 2134357;
  
  public static final int FrameAcquisitionNumber = 2134358;
  
  public static final int DimensionIndexValues = 2134359;
  
  public static final int FrameComments = 2134360;
  
  public static final int ConcatenationUID = 2134369;
  
  public static final int InConcatenationNumber = 2134370;
  
  public static final int InConcatenationTotalNumber = 2134371;
  
  public static final int DimensionOrganizationUID = 2134372;
  
  public static final int DimensionIndexPointer = 2134373;
  
  public static final int FunctionalGroupPointer = 2134375;
  
  public static final int UnassignedSharedConvertedAttributesSequence = 2134384;
  
  public static final int UnassignedPerFrameConvertedAttributesSequence = 2134385;
  
  public static final int ConversionSourceAttributesSequence = 2134386;
  
  public static final int DimensionIndexPrivateCreator = 2134547;
  
  public static final int DimensionOrganizationSequence = 2134561;
  
  public static final int DimensionIndexSequence = 2134562;
  
  public static final int ConcatenationFrameOffsetNumber = 2134568;
  
  public static final int FunctionalGroupPrivateCreator = 2134584;
  
  public static final int NominalPercentageOfCardiacPhase = 2134593;
  
  public static final int NominalPercentageOfRespiratoryPhase = 2134597;
  
  public static final int StartingRespiratoryAmplitude = 2134598;
  
  public static final int StartingRespiratoryPhase = 2134599;
  
  public static final int EndingRespiratoryAmplitude = 2134600;
  
  public static final int EndingRespiratoryPhase = 2134601;
  
  public static final int RespiratoryTriggerType = 2134608;
  
  public static final int RRIntervalTimeNominal = 2134609;
  
  public static final int ActualCardiacTriggerDelayTime = 2134610;
  
  public static final int RespiratorySynchronizationSequence = 2134611;
  
  public static final int RespiratoryIntervalTime = 2134612;
  
  public static final int NominalRespiratoryTriggerDelayTime = 2134613;
  
  public static final int RespiratoryTriggerDelayThreshold = 2134614;
  
  public static final int ActualRespiratoryTriggerDelayTime = 2134615;
  
  public static final int ImagePositionVolume = 2134785;
  
  public static final int ImageOrientationVolume = 2134786;
  
  public static final int UltrasoundAcquisitionGeometry = 2134791;
  
  public static final int ApexPosition = 2134792;
  
  public static final int VolumeToTransducerMappingMatrix = 2134793;
  
  public static final int VolumeToTableMappingMatrix = 2134794;
  
  public static final int VolumeToTransducerRelationship = 2134795;
  
  public static final int PatientFrameOfReferenceSource = 2134796;
  
  public static final int TemporalPositionTimeOffset = 2134797;
  
  public static final int PlanePositionVolumeSequence = 2134798;
  
  public static final int PlaneOrientationVolumeSequence = 2134799;
  
  public static final int TemporalPositionSequence = 2134800;
  
  public static final int DimensionOrganizationType = 2134801;
  
  public static final int VolumeFrameOfReferenceUID = 2134802;
  
  public static final int TableFrameOfReferenceUID = 2134803;
  
  public static final int DimensionDescriptionLabel = 2135073;
  
  public static final int PatientOrientationInFrameSequence = 2135120;
  
  public static final int FrameLabel = 2135123;
  
  public static final int AcquisitionIndex = 2135320;
  
  public static final int ContributingSOPInstancesReferenceSequence = 2135337;
  
  public static final int ReconstructionIndex = 2135350;
  
  public static final int LightPathFilterPassThroughWavelength = 2228225;
  
  public static final int LightPathFilterPassBand = 2228226;
  
  public static final int ImagePathFilterPassThroughWavelength = 2228227;
  
  public static final int ImagePathFilterPassBand = 2228228;
  
  public static final int PatientEyeMovementCommanded = 2228229;
  
  public static final int PatientEyeMovementCommandCodeSequence = 2228230;
  
  public static final int SphericalLensPower = 2228231;
  
  public static final int CylinderLensPower = 2228232;
  
  public static final int CylinderAxis = 2228233;
  
  public static final int EmmetropicMagnification = 2228234;
  
  public static final int IntraOcularPressure = 2228235;
  
  public static final int HorizontalFieldOfView = 2228236;
  
  public static final int PupilDilated = 2228237;
  
  public static final int DegreeOfDilation = 2228238;
  
  public static final int StereoBaselineAngle = 2228240;
  
  public static final int StereoBaselineDisplacement = 2228241;
  
  public static final int StereoHorizontalPixelOffset = 2228242;
  
  public static final int StereoVerticalPixelOffset = 2228243;
  
  public static final int StereoRotation = 2228244;
  
  public static final int AcquisitionDeviceTypeCodeSequence = 2228245;
  
  public static final int IlluminationTypeCodeSequence = 2228246;
  
  public static final int LightPathFilterTypeStackCodeSequence = 2228247;
  
  public static final int ImagePathFilterTypeStackCodeSequence = 2228248;
  
  public static final int LensesCodeSequence = 2228249;
  
  public static final int ChannelDescriptionCodeSequence = 2228250;
  
  public static final int RefractiveStateSequence = 2228251;
  
  public static final int MydriaticAgentCodeSequence = 2228252;
  
  public static final int RelativeImagePositionCodeSequence = 2228253;
  
  public static final int CameraAngleOfView = 2228254;
  
  public static final int StereoPairsSequence = 2228256;
  
  public static final int LeftImageSequence = 2228257;
  
  public static final int RightImageSequence = 2228258;
  
  public static final int AxialLengthOfTheEye = 2228272;
  
  public static final int OphthalmicFrameLocationSequence = 2228273;
  
  public static final int ReferenceCoordinates = 2228274;
  
  public static final int DepthSpatialResolution = 2228277;
  
  public static final int MaximumDepthDistortion = 2228278;
  
  public static final int AlongScanSpatialResolution = 2228279;
  
  public static final int MaximumAlongScanDistortion = 2228280;
  
  public static final int OphthalmicImageOrientation = 2228281;
  
  public static final int DepthOfTransverseImage = 2228289;
  
  public static final int MydriaticAgentConcentrationUnitsSequence = 2228290;
  
  public static final int AcrossScanSpatialResolution = 2228296;
  
  public static final int MaximumAcrossScanDistortion = 2228297;
  
  public static final int MydriaticAgentConcentration = 2228302;
  
  public static final int IlluminationWaveLength = 2228309;
  
  public static final int IlluminationPower = 2228310;
  
  public static final int IlluminationBandwidth = 2228311;
  
  public static final int MydriaticAgentSequence = 2228312;
  
  public static final int OphthalmicAxialMeasurementsRightEyeSequence = 2232327;
  
  public static final int OphthalmicAxialMeasurementsLeftEyeSequence = 2232328;
  
  public static final int OphthalmicAxialMeasurementsDeviceType = 2232329;
  
  public static final int OphthalmicAxialLengthMeasurementsType = 2232336;
  
  public static final int OphthalmicAxialLengthSequence = 2232338;
  
  public static final int OphthalmicAxialLength = 2232345;
  
  public static final int LensStatusCodeSequence = 2232356;
  
  public static final int VitreousStatusCodeSequence = 2232357;
  
  public static final int IOLFormulaCodeSequence = 2232360;
  
  public static final int IOLFormulaDetail = 2232361;
  
  public static final int KeratometerIndex = 2232371;
  
  public static final int SourceOfOphthalmicAxialLengthCodeSequence = 2232373;
  
  public static final int TargetRefraction = 2232375;
  
  public static final int RefractiveProcedureOccurred = 2232377;
  
  public static final int RefractiveSurgeryTypeCodeSequence = 2232384;
  
  public static final int OphthalmicUltrasoundMethodCodeSequence = 2232388;
  
  public static final int OphthalmicAxialLengthMeasurementsSequence = 2232400;
  
  public static final int IOLPower = 2232403;
  
  public static final int PredictedRefractiveError = 2232404;
  
  public static final int OphthalmicAxialLengthVelocity = 2232409;
  
  public static final int LensStatusDescription = 2232421;
  
  public static final int VitreousStatusDescription = 2232422;
  
  public static final int IOLPowerSequence = 2232464;
  
  public static final int LensConstantSequence = 2232466;
  
  public static final int IOLManufacturer = 2232467;
  
  public static final int LensConstantDescription = 2232468;
  
  public static final int ImplantName = 2232469;
  
  public static final int KeratometryMeasurementTypeCodeSequence = 2232470;
  
  public static final int ImplantPartNumber = 2232471;
  
  public static final int ReferencedOphthalmicAxialMeasurementsSequence = 2232576;
  
  public static final int OphthalmicAxialLengthMeasurementsSegmentNameCodeSequence = 2232577;
  
  public static final int RefractiveErrorBeforeRefractiveSurgeryCodeSequence = 2232579;
  
  public static final int IOLPowerForExactEmmetropia = 2232609;
  
  public static final int IOLPowerForExactTargetRefraction = 2232610;
  
  public static final int AnteriorChamberDepthDefinitionCodeSequence = 2232613;
  
  public static final int LensThicknessSequence = 2232615;
  
  public static final int AnteriorChamberDepthSequence = 2232616;
  
  public static final int LensThickness = 2232624;
  
  public static final int AnteriorChamberDepth = 2232625;
  
  public static final int SourceOfLensThicknessDataCodeSequence = 2232626;
  
  public static final int SourceOfAnteriorChamberDepthDataCodeSequence = 2232627;
  
  public static final int SourceOfRefractiveMeasurementsSequence = 2232628;
  
  public static final int SourceOfRefractiveMeasurementsCodeSequence = 2232629;
  
  public static final int OphthalmicAxialLengthMeasurementModified = 2232640;
  
  public static final int OphthalmicAxialLengthDataSourceCodeSequence = 2232656;
  
  public static final int OphthalmicAxialLengthAcquisitionMethodCodeSequence = 2232659;
  
  public static final int SignalToNoiseRatio = 2232661;
  
  public static final int OphthalmicAxialLengthDataSourceDescription = 2232665;
  
  public static final int OphthalmicAxialLengthMeasurementsTotalLengthSequence = 2232848;
  
  public static final int OphthalmicAxialLengthMeasurementsSegmentalLengthSequence = 2232849;
  
  public static final int OphthalmicAxialLengthMeasurementsLengthSummationSequence = 2232850;
  
  public static final int UltrasoundOphthalmicAxialLengthMeasurementsSequence = 2232864;
  
  public static final int OpticalOphthalmicAxialLengthMeasurementsSequence = 2232869;
  
  public static final int UltrasoundSelectedOphthalmicAxialLengthSequence = 2232880;
  
  public static final int OphthalmicAxialLengthSelectionMethodCodeSequence = 2232912;
  
  public static final int OpticalSelectedOphthalmicAxialLengthSequence = 2232917;
  
  public static final int SelectedSegmentalOphthalmicAxialLengthSequence = 2232919;
  
  public static final int SelectedTotalOphthalmicAxialLengthSequence = 2232928;
  
  public static final int OphthalmicAxialLengthQualityMetricSequence = 2232930;
  
  public static final int OphthalmicAxialLengthQualityMetricTypeCodeSequence = 2232933;
  
  public static final int OphthalmicAxialLengthQualityMetricTypeDescription = 2232947;
  
  public static final int IntraocularLensCalculationsRightEyeSequence = 2233088;
  
  public static final int IntraocularLensCalculationsLeftEyeSequence = 2233104;
  
  public static final int ReferencedOphthalmicAxialLengthMeasurementQCImageSequence = 2233136;
  
  public static final int OphthalmicMappingDeviceType = 2233365;
  
  public static final int AcquisitionMethodCodeSequence = 2233376;
  
  public static final int AcquisitionMethodAlgorithmSequence = 2233379;
  
  public static final int OphthalmicThicknessMapTypeCodeSequence = 2233398;
  
  public static final int OphthalmicThicknessMappingNormalsSequence = 2233411;
  
  public static final int RetinalThicknessDefinitionCodeSequence = 2233413;
  
  public static final int PixelValueMappingToCodedConceptSequence = 2233424;
  
  public static final int MappedPixelValue = 2233426;
  
  public static final int PixelValueMappingExplanation = 2233428;
  
  public static final int OphthalmicThicknessMapQualityThresholdSequence = 2233432;
  
  public static final int OphthalmicThicknessMapThresholdQualityRating = 2233440;
  
  public static final int AnatomicStructureReferencePoint = 2233443;
  
  public static final int RegistrationToLocalizerSequence = 2233445;
  
  public static final int RegisteredLocalizerUnits = 2233446;
  
  public static final int RegisteredLocalizerTopLeftHandCorner = 2233447;
  
  public static final int RegisteredLocalizerBottomRightHandCorner = 2233448;
  
  public static final int OphthalmicThicknessMapQualityRatingSequence = 2233456;
  
  public static final int RelevantOPTAttributesSequence = 2233458;
  
  public static final int VisualFieldHorizontalExtent = 2359312;
  
  public static final int VisualFieldVerticalExtent = 2359313;
  
  public static final int VisualFieldShape = 2359314;
  
  public static final int ScreeningTestModeCodeSequence = 2359318;
  
  public static final int MaximumStimulusLuminance = 2359320;
  
  public static final int BackgroundLuminance = 2359328;
  
  public static final int StimulusColorCodeSequence = 2359329;
  
  public static final int BackgroundIlluminationColorCodeSequence = 2359332;
  
  public static final int StimulusArea = 2359333;
  
  public static final int StimulusPresentationTime = 2359336;
  
  public static final int FixationSequence = 2359346;
  
  public static final int FixationMonitoringCodeSequence = 2359347;
  
  public static final int VisualFieldCatchTrialSequence = 2359348;
  
  public static final int FixationCheckedQuantity = 2359349;
  
  public static final int PatientNotProperlyFixatedQuantity = 2359350;
  
  public static final int PresentedVisualStimuliDataFlag = 2359351;
  
  public static final int NumberOfVisualStimuli = 2359352;
  
  public static final int ExcessiveFixationLossesDataFlag = 2359353;
  
  public static final int ExcessiveFixationLosses = 2359360;
  
  public static final int StimuliRetestingQuantity = 2359362;
  
  public static final int CommentsOnPatientPerformanceOfVisualField = 2359364;
  
  public static final int FalseNegativesEstimateFlag = 2359365;
  
  public static final int FalseNegativesEstimate = 2359366;
  
  public static final int NegativeCatchTrialsQuantity = 2359368;
  
  public static final int FalseNegativesQuantity = 2359376;
  
  public static final int ExcessiveFalseNegativesDataFlag = 2359377;
  
  public static final int ExcessiveFalseNegatives = 2359378;
  
  public static final int FalsePositivesEstimateFlag = 2359379;
  
  public static final int FalsePositivesEstimate = 2359380;
  
  public static final int CatchTrialsDataFlag = 2359381;
  
  public static final int PositiveCatchTrialsQuantity = 2359382;
  
  public static final int TestPointNormalsDataFlag = 2359383;
  
  public static final int TestPointNormalsSequence = 2359384;
  
  public static final int GlobalDeviationProbabilityNormalsFlag = 2359385;
  
  public static final int FalsePositivesQuantity = 2359392;
  
  public static final int ExcessiveFalsePositivesDataFlag = 2359393;
  
  public static final int ExcessiveFalsePositives = 2359394;
  
  public static final int VisualFieldTestNormalsFlag = 2359395;
  
  public static final int ResultsNormalsSequence = 2359396;
  
  public static final int AgeCorrectedSensitivityDeviationAlgorithmSequence = 2359397;
  
  public static final int GlobalDeviationFromNormal = 2359398;
  
  public static final int GeneralizedDefectSensitivityDeviationAlgorithmSequence = 2359399;
  
  public static final int LocalizedDeviationFromNormal = 2359400;
  
  public static final int PatientReliabilityIndicator = 2359401;
  
  public static final int VisualFieldMeanSensitivity = 2359408;
  
  public static final int GlobalDeviationProbability = 2359409;
  
  public static final int LocalDeviationProbabilityNormalsFlag = 2359410;
  
  public static final int LocalizedDeviationProbability = 2359411;
  
  public static final int ShortTermFluctuationCalculated = 2359412;
  
  public static final int ShortTermFluctuation = 2359413;
  
  public static final int ShortTermFluctuationProbabilityCalculated = 2359414;
  
  public static final int ShortTermFluctuationProbability = 2359415;
  
  public static final int CorrectedLocalizedDeviationFromNormalCalculated = 2359416;
  
  public static final int CorrectedLocalizedDeviationFromNormal = 2359417;
  
  public static final int CorrectedLocalizedDeviationFromNormalProbabilityCalculated = 2359424;
  
  public static final int CorrectedLocalizedDeviationFromNormalProbability = 2359425;
  
  public static final int GlobalDeviationProbabilitySequence = 2359427;
  
  public static final int LocalizedDeviationProbabilitySequence = 2359429;
  
  public static final int FovealSensitivityMeasured = 2359430;
  
  public static final int FovealSensitivity = 2359431;
  
  public static final int VisualFieldTestDuration = 2359432;
  
  public static final int VisualFieldTestPointSequence = 2359433;
  
  public static final int VisualFieldTestPointXCoordinate = 2359440;
  
  public static final int VisualFieldTestPointYCoordinate = 2359441;
  
  public static final int AgeCorrectedSensitivityDeviationValue = 2359442;
  
  public static final int StimulusResults = 2359443;
  
  public static final int SensitivityValue = 2359444;
  
  public static final int RetestStimulusSeen = 2359445;
  
  public static final int RetestSensitivityValue = 2359446;
  
  public static final int VisualFieldTestPointNormalsSequence = 2359447;
  
  public static final int QuantifiedDefect = 2359448;
  
  public static final int AgeCorrectedSensitivityDeviationProbabilityValue = 2359552;
  
  public static final int GeneralizedDefectCorrectedSensitivityDeviationFlag = 2359554;
  
  public static final int GeneralizedDefectCorrectedSensitivityDeviationValue = 2359555;
  
  public static final int GeneralizedDefectCorrectedSensitivityDeviationProbabilityValue = 2359556;
  
  public static final int MinimumSensitivityValue = 2359557;
  
  public static final int BlindSpotLocalized = 2359558;
  
  public static final int BlindSpotXCoordinate = 2359559;
  
  public static final int BlindSpotYCoordinate = 2359560;
  
  public static final int VisualAcuityMeasurementSequence = 2359568;
  
  public static final int RefractiveParametersUsedOnPatientSequence = 2359570;
  
  public static final int MeasurementLaterality = 2359571;
  
  public static final int OphthalmicPatientClinicalInformationLeftEyeSequence = 2359572;
  
  public static final int OphthalmicPatientClinicalInformationRightEyeSequence = 2359573;
  
  public static final int FovealPointNormativeDataFlag = 2359575;
  
  public static final int FovealPointProbabilityValue = 2359576;
  
  public static final int ScreeningBaselineMeasured = 2359584;
  
  public static final int ScreeningBaselineMeasuredSequence = 2359586;
  
  public static final int ScreeningBaselineType = 2359588;
  
  public static final int ScreeningBaselineValue = 2359590;
  
  public static final int AlgorithmSource = 2359810;
  
  public static final int DataSetName = 2360070;
  
  public static final int DataSetVersion = 2360071;
  
  public static final int DataSetSource = 2360072;
  
  public static final int DataSetDescription = 2360073;
  
  public static final int VisualFieldTestReliabilityGlobalIndexSequence = 2360087;
  
  public static final int VisualFieldGlobalResultsIndexSequence = 2360096;
  
  public static final int DataObservationSequence = 2360101;
  
  public static final int IndexNormalsFlag = 2360120;
  
  public static final int IndexProbability = 2360129;
  
  public static final int IndexProbabilitySequence = 2360132;
  
  public static final int SamplesPerPixel = 2621442;
  
  public static final int SamplesPerPixelUsed = 2621443;
  
  public static final int PhotometricInterpretation = 2621444;
  
  public static final int ImageDimensions = 2621445;
  
  public static final int PlanarConfiguration = 2621446;
  
  public static final int NumberOfFrames = 2621448;
  
  public static final int FrameIncrementPointer = 2621449;
  
  public static final int FrameDimensionPointer = 2621450;
  
  public static final int Rows = 2621456;
  
  public static final int Columns = 2621457;
  
  public static final int Planes = 2621458;
  
  public static final int UltrasoundColorDataPresent = 2621460;
  
  public static final int PixelSpacing = 2621488;
  
  public static final int ZoomFactor = 2621489;
  
  public static final int ZoomCenter = 2621490;
  
  public static final int PixelAspectRatio = 2621492;
  
  public static final int ImageFormat = 2621504;
  
  public static final int ManipulatedImage = 2621520;
  
  public static final int CorrectedImage = 2621521;
  
  public static final int CompressionRecognitionCode = 2621535;
  
  public static final int CompressionCode = 2621536;
  
  public static final int CompressionOriginator = 2621537;
  
  public static final int CompressionLabel = 2621538;
  
  public static final int CompressionDescription = 2621539;
  
  public static final int CompressionSequence = 2621541;
  
  public static final int CompressionStepPointers = 2621542;
  
  public static final int RepeatInterval = 2621544;
  
  public static final int BitsGrouped = 2621545;
  
  public static final int PerimeterTable = 2621552;
  
  public static final int PerimeterValue = 2621553;
  
  public static final int PredictorRows = 2621568;
  
  public static final int PredictorColumns = 2621569;
  
  public static final int PredictorConstants = 2621570;
  
  public static final int BlockedPixels = 2621584;
  
  public static final int BlockRows = 2621585;
  
  public static final int BlockColumns = 2621586;
  
  public static final int RowOverlap = 2621587;
  
  public static final int ColumnOverlap = 2621588;
  
  public static final int BitsAllocated = 2621696;
  
  public static final int BitsStored = 2621697;
  
  public static final int HighBit = 2621698;
  
  public static final int PixelRepresentation = 2621699;
  
  public static final int SmallestValidPixelValue = 2621700;
  
  public static final int LargestValidPixelValue = 2621701;
  
  public static final int SmallestImagePixelValue = 2621702;
  
  public static final int LargestImagePixelValue = 2621703;
  
  public static final int SmallestPixelValueInSeries = 2621704;
  
  public static final int LargestPixelValueInSeries = 2621705;
  
  public static final int SmallestImagePixelValueInPlane = 2621712;
  
  public static final int LargestImagePixelValueInPlane = 2621713;
  
  public static final int PixelPaddingValue = 2621728;
  
  public static final int PixelPaddingRangeLimit = 2621729;
  
  public static final int FloatPixelPaddingValue = 2621730;
  
  public static final int DoubleFloatPixelPaddingValue = 2621731;
  
  public static final int FloatPixelPaddingRangeLimit = 2621732;
  
  public static final int DoubleFloatPixelPaddingRangeLimit = 2621733;
  
  public static final int ImageLocation = 2621952;
  
  public static final int QualityControlImage = 2622208;
  
  public static final int BurnedInAnnotation = 2622209;
  
  public static final int RecognizableVisualFeatures = 2622210;
  
  public static final int LongitudinalTemporalInformationModified = 2622211;
  
  public static final int ReferencedColorPaletteInstanceUID = 2622212;
  
  public static final int TransformLabel = 2622464;
  
  public static final int TransformVersionNumber = 2622465;
  
  public static final int NumberOfTransformSteps = 2622466;
  
  public static final int SequenceOfCompressedData = 2622467;
  
  public static final int DetailsOfCoefficients = 2622468;
  
  public static final int RowsForNthOrderCoefficients = 2622464;
  
  public static final int ColumnsForNthOrderCoefficients = 2622465;
  
  public static final int CoefficientCoding = 2622466;
  
  public static final int CoefficientCodingPointers = 2622467;
  
  public static final int DCTLabel = 2623232;
  
  public static final int DataBlockDescription = 2623233;
  
  public static final int DataBlock = 2623234;
  
  public static final int NormalizationFactorFormat = 2623248;
  
  public static final int ZonalMapNumberFormat = 2623264;
  
  public static final int ZonalMapLocation = 2623265;
  
  public static final int ZonalMapFormat = 2623266;
  
  public static final int AdaptiveMapFormat = 2623280;
  
  public static final int CodeNumberFormat = 2623296;
  
  public static final int CodeLabel = 2623488;
  
  public static final int NumberOfTables = 2623490;
  
  public static final int CodeTableLocation = 2623491;
  
  public static final int BitsForCodeWord = 2623492;
  
  public static final int ImageDataLocation = 2623496;
  
  public static final int PixelSpacingCalibrationType = 2624002;
  
  public static final int PixelSpacingCalibrationDescription = 2624004;
  
  public static final int PixelIntensityRelationship = 2625600;
  
  public static final int PixelIntensityRelationshipSign = 2625601;
  
  public static final int WindowCenter = 2625616;
  
  public static final int WindowWidth = 2625617;
  
  public static final int RescaleIntercept = 2625618;
  
  public static final int RescaleSlope = 2625619;
  
  public static final int RescaleType = 2625620;
  
  public static final int WindowCenterWidthExplanation = 2625621;
  
  public static final int VOILUTFunction = 2625622;
  
  public static final int GrayScale = 2625664;
  
  public static final int RecommendedViewingMode = 2625680;
  
  public static final int GrayLookupTableDescriptor = 2625792;
  
  public static final int RedPaletteColorLookupTableDescriptor = 2625793;
  
  public static final int GreenPaletteColorLookupTableDescriptor = 2625794;
  
  public static final int BluePaletteColorLookupTableDescriptor = 2625795;
  
  public static final int AlphaPaletteColorLookupTableDescriptor = 2625796;
  
  public static final int LargeRedPaletteColorLookupTableDescriptor = 2625809;
  
  public static final int LargeGreenPaletteColorLookupTableDescriptor = 2625810;
  
  public static final int LargeBluePaletteColorLookupTableDescriptor = 2625811;
  
  public static final int PaletteColorLookupTableUID = 2625945;
  
  public static final int GrayLookupTableData = 2626048;
  
  public static final int RedPaletteColorLookupTableData = 2626049;
  
  public static final int GreenPaletteColorLookupTableData = 2626050;
  
  public static final int BluePaletteColorLookupTableData = 2626051;
  
  public static final int AlphaPaletteColorLookupTableData = 2626052;
  
  public static final int LargeRedPaletteColorLookupTableData = 2626065;
  
  public static final int LargeGreenPaletteColorLookupTableData = 2626066;
  
  public static final int LargeBluePaletteColorLookupTableData = 2626067;
  
  public static final int LargePaletteColorLookupTableUID = 2626068;
  
  public static final int SegmentedRedPaletteColorLookupTableData = 2626081;
  
  public static final int SegmentedGreenPaletteColorLookupTableData = 2626082;
  
  public static final int SegmentedBluePaletteColorLookupTableData = 2626083;
  
  public static final int BreastImplantPresent = 2626304;
  
  public static final int PartialView = 2626384;
  
  public static final int PartialViewDescription = 2626385;
  
  public static final int PartialViewCodeSequence = 2626386;
  
  public static final int SpatialLocationsPreserved = 2626394;
  
  public static final int DataFrameAssignmentSequence = 2626561;
  
  public static final int DataPathAssignment = 2626562;
  
  public static final int BitsMappedToColorLookupTable = 2626563;
  
  public static final int BlendingLUT1Sequence = 2626564;
  
  public static final int BlendingLUT1TransferFunction = 2626565;
  
  public static final int BlendingWeightConstant = 2626566;
  
  public static final int BlendingLookupTableDescriptor = 2626567;
  
  public static final int BlendingLookupTableData = 2626568;
  
  public static final int EnhancedPaletteColorLookupTableSequence = 2626571;
  
  public static final int BlendingLUT2Sequence = 2626572;
  
  public static final int BlendingLUT2TransferFunction = 2626573;
  
  public static final int DataPathID = 2626574;
  
  public static final int RGBLUTTransferFunction = 2626575;
  
  public static final int AlphaLUTTransferFunction = 2626576;
  
  public static final int ICCProfile = 2629632;
  
  public static final int LossyImageCompression = 2629904;
  
  public static final int LossyImageCompressionRatio = 2629906;
  
  public static final int LossyImageCompressionMethod = 2629908;
  
  public static final int ModalityLUTSequence = 2633728;
  
  public static final int LUTDescriptor = 2633730;
  
  public static final int LUTExplanation = 2633731;
  
  public static final int ModalityLUTType = 2633732;
  
  public static final int LUTData = 2633734;
  
  public static final int VOILUTSequence = 2633744;
  
  public static final int SoftcopyVOILUTSequence = 2634000;
  
  public static final int ImagePresentationComments = 2637824;
  
  public static final int BiPlaneAcquisitionSequence = 2641920;
  
  public static final int RepresentativeFrameNumber = 2646032;
  
  public static final int FrameNumbersOfInterest = 2646048;
  
  public static final int FrameOfInterestDescription = 2646050;
  
  public static final int FrameOfInterestType = 2646051;
  
  public static final int MaskPointers = 2646064;
  
  public static final int RWavePointer = 2646080;
  
  public static final int MaskSubtractionSequence = 2646272;
  
  public static final int MaskOperation = 2646273;
  
  public static final int ApplicableFrameRange = 2646274;
  
  public static final int MaskFrameNumbers = 2646288;
  
  public static final int ContrastFrameAveraging = 2646290;
  
  public static final int MaskSubPixelShift = 2646292;
  
  public static final int TIDOffset = 2646304;
  
  public static final int MaskOperationExplanation = 2646416;
  
  public static final int EquipmentAdministratorSequence = 2650112;
  
  public static final int NumberOfDisplaySubsystems = 2650113;
  
  public static final int CurrentConfigurationID = 2650114;
  
  public static final int DisplaySubsystemID = 2650115;
  
  public static final int DisplaySubsystemName = 2650116;
  
  public static final int DisplaySubsystemDescription = 2650117;
  
  public static final int SystemStatus = 2650118;
  
  public static final int SystemStatusComment = 2650119;
  
  public static final int TargetLuminanceCharacteristicsSequence = 2650120;
  
  public static final int LuminanceCharacteristicsID = 2650121;
  
  public static final int DisplaySubsystemConfigurationSequence = 2650122;
  
  public static final int ConfigurationID = 2650123;
  
  public static final int ConfigurationName = 2650124;
  
  public static final int ConfigurationDescription = 2650125;
  
  public static final int ReferencedTargetLuminanceCharacteristicsID = 2650126;
  
  public static final int QAResultsSequence = 2650127;
  
  public static final int DisplaySubsystemQAResultsSequence = 2650128;
  
  public static final int ConfigurationQAResultsSequence = 2650129;
  
  public static final int MeasurementEquipmentSequence = 2650130;
  
  public static final int MeasurementFunctions = 2650131;
  
  public static final int MeasurementEquipmentType = 2650132;
  
  public static final int VisualEvaluationResultSequence = 2650133;
  
  public static final int DisplayCalibrationResultSequence = 2650134;
  
  public static final int DDLValue = 2650135;
  
  public static final int CIExyWhitePoint = 2650136;
  
  public static final int DisplayFunctionType = 2650137;
  
  public static final int GammaValue = 2650138;
  
  public static final int NumberOfLuminancePoints = 2650139;
  
  public static final int LuminanceResponseSequence = 2650140;
  
  public static final int TargetMinimumLuminance = 2650141;
  
  public static final int TargetMaximumLuminance = 2650142;
  
  public static final int LuminanceValue = 2650143;
  
  public static final int LuminanceResponseDescription = 2650144;
  
  public static final int WhitePointFlag = 2650145;
  
  public static final int DisplayDeviceTypeCodeSequence = 2650146;
  
  public static final int DisplaySubsystemSequence = 2650147;
  
  public static final int LuminanceResultSequence = 2650148;
  
  public static final int AmbientLightValueSource = 2650149;
  
  public static final int MeasuredCharacteristics = 2650150;
  
  public static final int LuminanceUniformityResultSequence = 2650151;
  
  public static final int VisualEvaluationTestSequence = 2650152;
  
  public static final int TestResult = 2650153;
  
  public static final int TestResultComment = 2650154;
  
  public static final int TestImageValidation = 2650155;
  
  public static final int TestPatternCodeSequence = 2650156;
  
  public static final int MeasurementPatternCodeSequence = 2650157;
  
  public static final int VisualEvaluationMethodCodeSequence = 2650158;
  
  public static final int PixelDataProviderURL = 2654176;
  
  public static final int DataPointRows = 2658305;
  
  public static final int DataPointColumns = 2658306;
  
  public static final int SignalDomainColumns = 2658307;
  
  public static final int LargestMonochromePixelValue = 2658457;
  
  public static final int DataRepresentation = 2658568;
  
  public static final int PixelMeasuresSequence = 2658576;
  
  public static final int FrameVOILUTSequence = 2658610;
  
  public static final int PixelValueTransformationSequence = 2658629;
  
  public static final int SignalDomainRows = 2658869;
  
  public static final int DisplayFilterPercentage = 2659345;
  
  public static final int FramePixelShiftSequence = 2659349;
  
  public static final int SubtractionItemID = 2659350;
  
  public static final int PixelIntensityRelationshipLUTSequence = 2659362;
  
  public static final int FramePixelDataPropertiesSequence = 2659395;
  
  public static final int GeometricalProperties = 2659396;
  
  public static final int GeometricMaximumDistortion = 2659397;
  
  public static final int ImageProcessingApplied = 2659398;
  
  public static final int MaskSelectionMode = 2659412;
  
  public static final int LUTFunction = 2659444;
  
  public static final int MaskVisibilityPercentage = 2659448;
  
  public static final int PixelShiftSequence = 2659585;
  
  public static final int RegionPixelShiftSequence = 2659586;
  
  public static final int VerticesOfTheRegion = 2659587;
  
  public static final int MultiFramePresentationSequence = 2659589;
  
  public static final int PixelShiftFrameRange = 2659590;
  
  public static final int LUTFrameRange = 2659591;
  
  public static final int ImageToEquipmentMappingMatrix = 2659616;
  
  public static final int EquipmentCoordinateSystemIdentification = 2659639;
  
  public static final int StudyStatusID = 3276810;
  
  public static final int StudyPriorityID = 3276812;
  
  public static final int StudyIDIssuer = 3276818;
  
  public static final int StudyVerifiedDate = 3276850;
  
  public static final int StudyVerifiedTime = 3276851;
  
  public static final int StudyReadDate = 3276852;
  
  public static final int StudyReadTime = 3276853;
  
  public static final int ScheduledStudyStartDate = 3280896;
  
  public static final int ScheduledStudyStartTime = 3280897;
  
  public static final int ScheduledStudyStopDate = 3280912;
  
  public static final int ScheduledStudyStopTime = 3280913;
  
  public static final int ScheduledStudyLocation = 3280928;
  
  public static final int ScheduledStudyLocationAETitle = 3280929;
  
  public static final int ReasonForStudy = 3280944;
  
  public static final int RequestingPhysicianIdentificationSequence = 3280945;
  
  public static final int RequestingPhysician = 3280946;
  
  public static final int RequestingService = 3280947;
  
  public static final int RequestingServiceCodeSequence = 3280948;
  
  public static final int StudyArrivalDate = 3280960;
  
  public static final int StudyArrivalTime = 3280961;
  
  public static final int StudyCompletionDate = 3280976;
  
  public static final int StudyCompletionTime = 3280977;
  
  public static final int StudyComponentStatusID = 3280981;
  
  public static final int RequestedProcedureDescription = 3280992;
  
  public static final int RequestedProcedureCodeSequence = 3280996;
  
  public static final int RequestedContrastAgent = 3281008;
  
  public static final int StudyComments = 3293184;
  
  public static final int ReferencedPatientAliasSequence = 3670020;
  
  public static final int VisitStatusID = 3670024;
  
  public static final int AdmissionID = 3670032;
  
  public static final int IssuerOfAdmissionID = 3670033;
  
  public static final int IssuerOfAdmissionIDSequence = 3670036;
  
  public static final int RouteOfAdmissions = 3670038;
  
  public static final int ScheduledAdmissionDate = 3670042;
  
  public static final int ScheduledAdmissionTime = 3670043;
  
  public static final int ScheduledDischargeDate = 3670044;
  
  public static final int ScheduledDischargeTime = 3670045;
  
  public static final int ScheduledPatientInstitutionResidence = 3670046;
  
  public static final int AdmittingDate = 3670048;
  
  public static final int AdmittingTime = 3670049;
  
  public static final int DischargeDate = 3670064;
  
  public static final int DischargeTime = 3670066;
  
  public static final int DischargeDiagnosisDescription = 3670080;
  
  public static final int DischargeDiagnosisCodeSequence = 3670084;
  
  public static final int SpecialNeeds = 3670096;
  
  public static final int ServiceEpisodeID = 3670112;
  
  public static final int IssuerOfServiceEpisodeID = 3670113;
  
  public static final int ServiceEpisodeDescription = 3670114;
  
  public static final int IssuerOfServiceEpisodeIDSequence = 3670116;
  
  public static final int PertinentDocumentsSequence = 3670272;
  
  public static final int PertinentResourcesSequence = 3670273;
  
  public static final int ResourceDescription = 3670274;
  
  public static final int CurrentPatientLocation = 3670784;
  
  public static final int PatientInstitutionResidence = 3671040;
  
  public static final int PatientState = 3671296;
  
  public static final int PatientClinicalTrialParticipationSequence = 3671298;
  
  public static final int VisitComments = 3686400;
  
  public static final int WaveformOriginality = 3801092;
  
  public static final int NumberOfWaveformChannels = 3801093;
  
  public static final int NumberOfWaveformSamples = 3801104;
  
  public static final int SamplingFrequency = 3801114;
  
  public static final int MultiplexGroupLabel = 3801120;
  
  public static final int ChannelDefinitionSequence = 3801600;
  
  public static final int WaveformChannelNumber = 3801602;
  
  public static final int ChannelLabel = 3801603;
  
  public static final int ChannelStatus = 3801605;
  
  public static final int ChannelSourceSequence = 3801608;
  
  public static final int ChannelSourceModifiersSequence = 3801609;
  
  public static final int SourceWaveformSequence = 3801610;
  
  public static final int ChannelDerivationDescription = 3801612;
  
  public static final int ChannelSensitivity = 3801616;
  
  public static final int ChannelSensitivityUnitsSequence = 3801617;
  
  public static final int ChannelSensitivityCorrectionFactor = 3801618;
  
  public static final int ChannelBaseline = 3801619;
  
  public static final int ChannelTimeSkew = 3801620;
  
  public static final int ChannelSampleSkew = 3801621;
  
  public static final int ChannelOffset = 3801624;
  
  public static final int WaveformBitsStored = 3801626;
  
  public static final int FilterLowFrequency = 3801632;
  
  public static final int FilterHighFrequency = 3801633;
  
  public static final int NotchFilterFrequency = 3801634;
  
  public static final int NotchFilterBandwidth = 3801635;
  
  public static final int WaveformDataDisplayScale = 3801648;
  
  public static final int WaveformDisplayBackgroundCIELabValue = 3801649;
  
  public static final int WaveformPresentationGroupSequence = 3801664;
  
  public static final int PresentationGroupNumber = 3801665;
  
  public static final int ChannelDisplaySequence = 3801666;
  
  public static final int ChannelRecommendedDisplayCIELabValue = 3801668;
  
  public static final int ChannelPosition = 3801669;
  
  public static final int DisplayShadingFlag = 3801670;
  
  public static final int FractionalChannelDisplayScale = 3801671;
  
  public static final int AbsoluteChannelDisplayScale = 3801672;
  
  public static final int MultiplexedAudioChannelsDescriptionCodeSequence = 3801856;
  
  public static final int ChannelIdentificationCode = 3801857;
  
  public static final int ChannelMode = 3801858;
  
  public static final int ScheduledStationAETitle = 4194305;
  
  public static final int ScheduledProcedureStepStartDate = 4194306;
  
  public static final int ScheduledProcedureStepStartTime = 4194307;
  
  public static final int ScheduledProcedureStepEndDate = 4194308;
  
  public static final int ScheduledProcedureStepEndTime = 4194309;
  
  public static final int ScheduledPerformingPhysicianName = 4194310;
  
  public static final int ScheduledProcedureStepDescription = 4194311;
  
  public static final int ScheduledProtocolCodeSequence = 4194312;
  
  public static final int ScheduledProcedureStepID = 4194313;
  
  public static final int StageCodeSequence = 4194314;
  
  public static final int ScheduledPerformingPhysicianIdentificationSequence = 4194315;
  
  public static final int ScheduledStationName = 4194320;
  
  public static final int ScheduledProcedureStepLocation = 4194321;
  
  public static final int PreMedication = 4194322;
  
  public static final int ScheduledProcedureStepStatus = 4194336;
  
  public static final int OrderPlacerIdentifierSequence = 4194342;
  
  public static final int OrderFillerIdentifierSequence = 4194343;
  
  public static final int LocalNamespaceEntityID = 4194353;
  
  public static final int UniversalEntityID = 4194354;
  
  public static final int UniversalEntityIDType = 4194355;
  
  public static final int IdentifierTypeCode = 4194357;
  
  public static final int AssigningFacilitySequence = 4194358;
  
  public static final int AssigningJurisdictionCodeSequence = 4194361;
  
  public static final int AssigningAgencyOrDepartmentCodeSequence = 4194362;
  
  public static final int ScheduledProcedureStepSequence = 4194560;
  
  public static final int ReferencedNonImageCompositeSOPInstanceSequence = 4194848;
  
  public static final int PerformedStationAETitle = 4194881;
  
  public static final int PerformedStationName = 4194882;
  
  public static final int PerformedLocation = 4194883;
  
  public static final int PerformedProcedureStepStartDate = 4194884;
  
  public static final int PerformedProcedureStepStartTime = 4194885;
  
  public static final int PerformedProcedureStepEndDate = 4194896;
  
  public static final int PerformedProcedureStepEndTime = 4194897;
  
  public static final int PerformedProcedureStepStatus = 4194898;
  
  public static final int PerformedProcedureStepID = 4194899;
  
  public static final int PerformedProcedureStepDescription = 4194900;
  
  public static final int PerformedProcedureTypeDescription = 4194901;
  
  public static final int PerformedProtocolCodeSequence = 4194912;
  
  public static final int PerformedProtocolType = 4194913;
  
  public static final int ScheduledStepAttributesSequence = 4194928;
  
  public static final int RequestAttributesSequence = 4194933;
  
  public static final int CommentsOnThePerformedProcedureStep = 4194944;
  
  public static final int PerformedProcedureStepDiscontinuationReasonCodeSequence = 4194945;
  
  public static final int QuantitySequence = 4194963;
  
  public static final int Quantity = 4194964;
  
  public static final int MeasuringUnitsSequence = 4194965;
  
  public static final int BillingItemSequence = 4194966;
  
  public static final int TotalTimeOfFluoroscopy = 4195072;
  
  public static final int TotalNumberOfExposures = 4195073;
  
  public static final int EntranceDose = 4195074;
  
  public static final int ExposedArea = 4195075;
  
  public static final int DistanceSourceToEntrance = 4195078;
  
  public static final int DistanceSourceToSupport = 4195079;
  
  public static final int ExposureDoseSequence = 4195086;
  
  public static final int CommentsOnRadiationDose = 4195088;
  
  public static final int XRayOutput = 4195090;
  
  public static final int HalfValueLayer = 4195092;
  
  public static final int OrganDose = 4195094;
  
  public static final int OrganExposed = 4195096;
  
  public static final int BillingProcedureStepSequence = 4195104;
  
  public static final int FilmConsumptionSequence = 4195105;
  
  public static final int BillingSuppliesAndDevicesSequence = 4195108;
  
  public static final int ReferencedProcedureStepSequence = 4195120;
  
  public static final int PerformedSeriesSequence = 4195136;
  
  public static final int CommentsOnTheScheduledProcedureStep = 4195328;
  
  public static final int ProtocolContextSequence = 4195392;
  
  public static final int ContentItemModifierSequence = 4195393;
  
  public static final int ScheduledSpecimenSequence = 4195584;
  
  public static final int SpecimenAccessionNumber = 4195594;
  
  public static final int ContainerIdentifier = 4195602;
  
  public static final int IssuerOfTheContainerIdentifierSequence = 4195603;
  
  public static final int AlternateContainerIdentifierSequence = 4195605;
  
  public static final int ContainerTypeCodeSequence = 4195608;
  
  public static final int ContainerDescription = 4195610;
  
  public static final int ContainerComponentSequence = 4195616;
  
  public static final int SpecimenSequence = 4195664;
  
  public static final int SpecimenIdentifier = 4195665;
  
  public static final int SpecimenDescriptionSequenceTrial = 4195666;
  
  public static final int SpecimenDescriptionTrial = 4195667;
  
  public static final int SpecimenUID = 4195668;
  
  public static final int AcquisitionContextSequence = 4195669;
  
  public static final int AcquisitionContextDescription = 4195670;
  
  public static final int SpecimenTypeCodeSequence = 4195738;
  
  public static final int SpecimenDescriptionSequence = 4195680;
  
  public static final int IssuerOfTheSpecimenIdentifierSequence = 4195682;
  
  public static final int SpecimenShortDescription = 4195840;
  
  public static final int SpecimenDetailedDescription = 4195842;
  
  public static final int SpecimenPreparationSequence = 4195856;
  
  public static final int SpecimenPreparationStepContentItemSequence = 4195858;
  
  public static final int SpecimenLocalizationContentItemSequence = 4195872;
  
  public static final int SlideIdentifier = 4196090;
  
  public static final int ImageCenterPointCoordinatesSequence = 4196122;
  
  public static final int XOffsetInSlideCoordinateSystem = 4196138;
  
  public static final int YOffsetInSlideCoordinateSystem = 4196154;
  
  public static final int ZOffsetInSlideCoordinateSystem = 4196170;
  
  public static final int PixelSpacingSequence = 4196568;
  
  public static final int CoordinateSystemAxisCodeSequence = 4196570;
  
  public static final int MeasurementUnitsCodeSequence = 4196586;
  
  public static final int VitalStainCodeSequenceTrial = 4196856;
  
  public static final int RequestedProcedureID = 4198401;
  
  public static final int ReasonForTheRequestedProcedure = 4198402;
  
  public static final int RequestedProcedurePriority = 4198403;
  
  public static final int PatientTransportArrangements = 4198404;
  
  public static final int RequestedProcedureLocation = 4198405;
  
  public static final int PlacerOrderNumberProcedure = 4198406;
  
  public static final int FillerOrderNumberProcedure = 4198407;
  
  public static final int ConfidentialityCode = 4198408;
  
  public static final int ReportingPriority = 4198409;
  
  public static final int ReasonForRequestedProcedureCodeSequence = 4198410;
  
  public static final int NamesOfIntendedRecipientsOfResults = 4198416;
  
  public static final int IntendedRecipientsOfResultsIdentificationSequence = 4198417;
  
  public static final int ReasonForPerformedProcedureCodeSequence = 4198418;
  
  public static final int RequestedProcedureDescriptionTrial = 4198496;
  
  public static final int PersonIdentificationCodeSequence = 4198657;
  
  public static final int PersonAddress = 4198658;
  
  public static final int PersonTelephoneNumbers = 4198659;
  
  public static final int RequestedProcedureComments = 4199424;
  
  public static final int ReasonForTheImagingServiceRequest = 4202497;
  
  public static final int IssueDateOfImagingServiceRequest = 4202500;
  
  public static final int IssueTimeOfImagingServiceRequest = 4202501;
  
  public static final int PlacerOrderNumberImagingServiceRequestRetired = 4202502;
  
  public static final int FillerOrderNumberImagingServiceRequestRetired = 4202503;
  
  public static final int OrderEnteredBy = 4202504;
  
  public static final int OrderEntererLocation = 4202505;
  
  public static final int OrderCallbackPhoneNumber = 4202512;
  
  public static final int PlacerOrderNumberImagingServiceRequest = 4202518;
  
  public static final int FillerOrderNumberImagingServiceRequest = 4202519;
  
  public static final int ImagingServiceRequestComments = 4203520;
  
  public static final int ConfidentialityConstraintOnPatientDataDescription = 4206593;
  
  public static final int GeneralPurposeScheduledProcedureStepStatus = 4210689;
  
  public static final int GeneralPurposePerformedProcedureStepStatus = 4210690;
  
  public static final int GeneralPurposeScheduledProcedureStepPriority = 4210691;
  
  public static final int ScheduledProcessingApplicationsCodeSequence = 4210692;
  
  public static final int ScheduledProcedureStepStartDateTime = 4210693;
  
  public static final int MultipleCopiesFlag = 4210694;
  
  public static final int PerformedProcessingApplicationsCodeSequence = 4210695;
  
  public static final int HumanPerformerCodeSequence = 4210697;
  
  public static final int ScheduledProcedureStepModificationDateTime = 4210704;
  
  public static final int ExpectedCompletionDateTime = 4210705;
  
  public static final int ResultingGeneralPurposePerformedProcedureStepsSequence = 4210709;
  
  public static final int ReferencedGeneralPurposeScheduledProcedureStepSequence = 4210710;
  
  public static final int ScheduledWorkitemCodeSequence = 4210712;
  
  public static final int PerformedWorkitemCodeSequence = 4210713;
  
  public static final int InputAvailabilityFlag = 4210720;
  
  public static final int InputInformationSequence = 4210721;
  
  public static final int RelevantInformationSequence = 4210722;
  
  public static final int ReferencedGeneralPurposeScheduledProcedureStepTransactionUID = 4210723;
  
  public static final int ScheduledStationNameCodeSequence = 4210725;
  
  public static final int ScheduledStationClassCodeSequence = 4210726;
  
  public static final int ScheduledStationGeographicLocationCodeSequence = 4210727;
  
  public static final int PerformedStationNameCodeSequence = 4210728;
  
  public static final int PerformedStationClassCodeSequence = 4210729;
  
  public static final int PerformedStationGeographicLocationCodeSequence = 4210736;
  
  public static final int RequestedSubsequentWorkitemCodeSequence = 4210737;
  
  public static final int NonDICOMOutputCodeSequence = 4210738;
  
  public static final int OutputInformationSequence = 4210739;
  
  public static final int ScheduledHumanPerformersSequence = 4210740;
  
  public static final int ActualHumanPerformersSequence = 4210741;
  
  public static final int HumanPerformerOrganization = 4210742;
  
  public static final int HumanPerformerName = 4210743;
  
  public static final int RawDataHandling = 4210752;
  
  public static final int InputReadinessState = 4210753;
  
  public static final int PerformedProcedureStepStartDateTime = 4210768;
  
  public static final int PerformedProcedureStepEndDateTime = 4210769;
  
  public static final int ProcedureStepCancellationDateTime = 4210770;
  
  public static final int EntranceDoseInmGy = 4227842;
  
  public static final int ParametricMapFrameTypeSequence = 4231314;
  
  public static final int ReferencedImageRealWorldValueMappingSequence = 4231316;
  
  public static final int RealWorldValueMappingSequence = 4231318;
  
  public static final int PixelValueMappingCodeSequence = 4231320;
  
  public static final int LUTLabel = 4231696;
  
  public static final int RealWorldValueLastValueMapped = 4231697;
  
  public static final int RealWorldValueLUTData = 4231698;
  
  public static final int RealWorldValueFirstValueMapped = 4231702;
  
  public static final int QuantityDefinitionSequence = 4231712;
  
  public static final int RealWorldValueIntercept = 4231716;
  
  public static final int RealWorldValueSlope = 4231717;
  
  public static final int FindingsFlagTrial = 4235271;
  
  public static final int RelationshipType = 4235280;
  
  public static final int FindingsSequenceTrial = 4235296;
  
  public static final int FindingsGroupUIDTrial = 4235297;
  
  public static final int ReferencedFindingsGroupUIDTrial = 4235298;
  
  public static final int FindingsGroupRecordingDateTrial = 4235299;
  
  public static final int FindingsGroupRecordingTimeTrial = 4235300;
  
  public static final int FindingsSourceCategoryCodeSequenceTrial = 4235302;
  
  public static final int VerifyingOrganization = 4235303;
  
  public static final int DocumentingOrganizationIdentifierCodeSequenceTrial = 4235304;
  
  public static final int VerificationDateTime = 4235312;
  
  public static final int ObservationDateTime = 4235314;
  
  public static final int ValueType = 4235328;
  
  public static final int ConceptNameCodeSequence = 4235331;
  
  public static final int MeasurementPrecisionDescriptionTrial = 4235335;
  
  public static final int ContinuityOfContent = 4235344;
  
  public static final int UrgencyOrPriorityAlertsTrial = 4235351;
  
  public static final int SequencingIndicatorTrial = 4235360;
  
  public static final int DocumentIdentifierCodeSequenceTrial = 4235366;
  
  public static final int DocumentAuthorTrial = 4235367;
  
  public static final int DocumentAuthorIdentifierCodeSequenceTrial = 4235368;
  
  public static final int IdentifierCodeSequenceTrial = 4235376;
  
  public static final int VerifyingObserverSequence = 4235379;
  
  public static final int ObjectBinaryIdentifierTrial = 4235380;
  
  public static final int VerifyingObserverName = 4235381;
  
  public static final int DocumentingObserverIdentifierCodeSequenceTrial = 4235382;
  
  public static final int AuthorObserverSequence = 4235384;
  
  public static final int ParticipantSequence = 4235386;
  
  public static final int CustodialOrganizationSequence = 4235388;
  
  public static final int ParticipationType = 4235392;
  
  public static final int ParticipationDateTime = 4235394;
  
  public static final int ObserverType = 4235396;
  
  public static final int ProcedureIdentifierCodeSequenceTrial = 4235397;
  
  public static final int VerifyingObserverIdentificationCodeSequence = 4235400;
  
  public static final int ObjectDirectoryBinaryIdentifierTrial = 4235401;
  
  public static final int EquivalentCDADocumentSequence = 4235408;
  
  public static final int ReferencedWaveformChannels = 4235440;
  
  public static final int DateOfDocumentOrVerbalTransactionTrial = 4235536;
  
  public static final int TimeOfDocumentCreationOrVerbalTransactionTrial = 4235538;
  
  public static final int DateTime = 4235552;
  
  public static final int Date = 4235553;
  
  public static final int Time = 4235554;
  
  public static final int PersonName = 4235555;
  
  public static final int UID = 4235556;
  
  public static final int ReportStatusIDTrial = 4235557;
  
  public static final int TemporalRangeType = 4235568;
  
  public static final int ReferencedSamplePositions = 4235570;
  
  public static final int ReferencedFrameNumbers = 4235574;
  
  public static final int ReferencedTimeOffsets = 4235576;
  
  public static final int ReferencedDateTime = 4235578;
  
  public static final int TextValue = 4235616;
  
  public static final int FloatingPointValue = 4235617;
  
  public static final int RationalNumeratorValue = 4235618;
  
  public static final int RationalDenominatorValue = 4235619;
  
  public static final int ObservationCategoryCodeSequenceTrial = 4235623;
  
  public static final int ConceptCodeSequence = 4235624;
  
  public static final int BibliographicCitationTrial = 4235626;
  
  public static final int PurposeOfReferenceCodeSequence = 4235632;
  
  public static final int ObservationUID = 4235633;
  
  public static final int ReferencedObservationUIDTrial = 4235634;
  
  public static final int ReferencedObservationClassTrial = 4235635;
  
  public static final int ReferencedObjectObservationClassTrial = 4235636;
  
  public static final int AnnotationGroupNumber = 4235648;
  
  public static final int ObservationDateTrial = 4235666;
  
  public static final int ObservationTimeTrial = 4235667;
  
  public static final int MeasurementAutomationTrial = 4235668;
  
  public static final int ModifierCodeSequence = 4235669;
  
  public static final int IdentificationDescriptionTrial = 4235812;
  
  public static final int CoordinatesSetGeometricTypeTrial = 4235920;
  
  public static final int AlgorithmCodeSequenceTrial = 4235926;
  
  public static final int AlgorithmDescriptionTrial = 4235927;
  
  public static final int PixelCoordinatesSetTrial = 4235930;
  
  public static final int MeasuredValueSequence = 4236032;
  
  public static final int NumericValueQualifierCodeSequence = 4236033;
  
  public static final int CurrentObserverTrial = 4236039;
  
  public static final int NumericValue = 4236042;
  
  public static final int ReferencedAccessionSequenceTrial = 4236051;
  
  public static final int ReportStatusCommentTrial = 4236090;
  
  public static final int ProcedureContextSequenceTrial = 4236096;
  
  public static final int VerbalSourceTrial = 4236114;
  
  public static final int AddressTrial = 4236115;
  
  public static final int TelephoneNumberTrial = 4236116;
  
  public static final int VerbalSourceIdentifierCodeSequenceTrial = 4236120;
  
  public static final int PredecessorDocumentsSequence = 4236128;
  
  public static final int ReferencedRequestSequence = 4236144;
  
  public static final int PerformedProcedureCodeSequence = 4236146;
  
  public static final int CurrentRequestedProcedureEvidenceSequence = 4236149;
  
  public static final int ReportDetailSequenceTrial = 4236160;
  
  public static final int PertinentOtherEvidenceSequence = 4236165;
  
  public static final int HL7StructuredDocumentReferenceSequence = 4236176;
  
  public static final int ObservationSubjectUIDTrial = 4236290;
  
  public static final int ObservationSubjectClassTrial = 4236291;
  
  public static final int ObservationSubjectTypeCodeSequenceTrial = 4236292;
  
  public static final int CompletionFlag = 4236433;
  
  public static final int CompletionFlagDescription = 4236434;
  
  public static final int VerificationFlag = 4236435;
  
  public static final int ArchiveRequested = 4236436;
  
  public static final int PreliminaryFlag = 4236438;
  
  public static final int ContentTemplateSequence = 4236548;
  
  public static final int IdenticalDocumentsSequence = 4236581;
  
  public static final int ObservationSubjectContextFlagTrial = 4236800;
  
  public static final int ObserverContextFlagTrial = 4236801;
  
  public static final int ProcedureContextFlagTrial = 4236803;
  
  public static final int ContentSequence = 4237104;
  
  public static final int RelationshipSequenceTrial = 4237105;
  
  public static final int RelationshipTypeCodeSequenceTrial = 4237106;
  
  public static final int LanguageCodeSequenceTrial = 4237124;
  
  public static final int UniformResourceLocatorTrial = 4237714;
  
  public static final int WaveformAnnotationSequence = 4239392;
  
  public static final int TemplateIdentifier = 4250368;
  
  public static final int TemplateVersion = 4250374;
  
  public static final int TemplateLocalVersion = 4250375;
  
  public static final int TemplateExtensionFlag = 4250379;
  
  public static final int TemplateExtensionOrganizationUID = 4250380;
  
  public static final int TemplateExtensionCreatorUID = 4250381;
  
  public static final int ReferencedContentItemIdentifier = 4250483;
  
  public static final int HL7InstanceIdentifier = 4251649;
  
  public static final int HL7DocumentEffectiveTime = 4251652;
  
  public static final int HL7DocumentTypeCodeSequence = 4251654;
  
  public static final int DocumentClassCodeSequence = 4251656;
  
  public static final int RetrieveURI = 4251664;
  
  public static final int RetrieveLocationUID = 4251665;
  
  public static final int TypeOfInstances = 4251680;
  
  public static final int DICOMRetrievalSequence = 4251681;
  
  public static final int DICOMMediaRetrievalSequence = 4251682;
  
  public static final int WADORetrievalSequence = 4251683;
  
  public static final int XDSRetrievalSequence = 4251684;
  
  public static final int WADORSRetrievalSequence = 4251685;
  
  public static final int RepositoryUniqueID = 4251696;
  
  public static final int HomeCommunityID = 4251697;
  
  public static final int DocumentTitle = 4325392;
  
  public static final int EncapsulatedDocument = 4325393;
  
  public static final int MIMETypeOfEncapsulatedDocument = 4325394;
  
  public static final int SourceInstanceSequence = 4325395;
  
  public static final int ListOfMIMETypes = 4325396;
  
  public static final int ProductPackageIdentifier = 4456449;
  
  public static final int SubstanceAdministrationApproval = 4456450;
  
  public static final int ApprovalStatusFurtherDescription = 4456451;
  
  public static final int ApprovalStatusDateTime = 4456452;
  
  public static final int ProductTypeCodeSequence = 4456455;
  
  public static final int ProductName = 4456456;
  
  public static final int ProductDescription = 4456457;
  
  public static final int ProductLotIdentifier = 4456458;
  
  public static final int ProductExpirationDateTime = 4456459;
  
  public static final int SubstanceAdministrationDateTime = 4456464;
  
  public static final int SubstanceAdministrationNotes = 4456465;
  
  public static final int SubstanceAdministrationDeviceID = 4456466;
  
  public static final int ProductParameterSequence = 4456467;
  
  public static final int SubstanceAdministrationParameterSequence = 4456473;
  
  public static final int LensDescription = 4587538;
  
  public static final int RightLensSequence = 4587540;
  
  public static final int LeftLensSequence = 4587541;
  
  public static final int UnspecifiedLateralityLensSequence = 4587542;
  
  public static final int CylinderSequence = 4587544;
  
  public static final int PrismSequence = 4587560;
  
  public static final int HorizontalPrismPower = 4587568;
  
  public static final int HorizontalPrismBase = 4587570;
  
  public static final int VerticalPrismPower = 4587572;
  
  public static final int VerticalPrismBase = 4587574;
  
  public static final int LensSegmentType = 4587576;
  
  public static final int OpticalTransmittance = 4587584;
  
  public static final int ChannelWidth = 4587586;
  
  public static final int PupilSize = 4587588;
  
  public static final int CornealSize = 4587590;
  
  public static final int AutorefractionRightEyeSequence = 4587600;
  
  public static final int AutorefractionLeftEyeSequence = 4587602;
  
  public static final int DistancePupillaryDistance = 4587616;
  
  public static final int NearPupillaryDistance = 4587618;
  
  public static final int IntermediatePupillaryDistance = 4587619;
  
  public static final int OtherPupillaryDistance = 4587620;
  
  public static final int KeratometryRightEyeSequence = 4587632;
  
  public static final int KeratometryLeftEyeSequence = 4587633;
  
  public static final int SteepKeratometricAxisSequence = 4587636;
  
  public static final int RadiusOfCurvature = 4587637;
  
  public static final int KeratometricPower = 4587638;
  
  public static final int KeratometricAxis = 4587639;
  
  public static final int FlatKeratometricAxisSequence = 4587648;
  
  public static final int BackgroundColor = 4587666;
  
  public static final int Optotype = 4587668;
  
  public static final int OptotypePresentation = 4587669;
  
  public static final int SubjectiveRefractionRightEyeSequence = 4587671;
  
  public static final int SubjectiveRefractionLeftEyeSequence = 4587672;
  
  public static final int AddNearSequence = 4587776;
  
  public static final int AddIntermediateSequence = 4587777;
  
  public static final int AddOtherSequence = 4587778;
  
  public static final int AddPower = 4587780;
  
  public static final int ViewingDistance = 4587782;
  
  public static final int VisualAcuityTypeCodeSequence = 4587809;
  
  public static final int VisualAcuityRightEyeSequence = 4587810;
  
  public static final int VisualAcuityLeftEyeSequence = 4587811;
  
  public static final int VisualAcuityBothEyesOpenSequence = 4587812;
  
  public static final int ViewingDistanceType = 4587813;
  
  public static final int VisualAcuityModifiers = 4587829;
  
  public static final int DecimalVisualAcuity = 4587831;
  
  public static final int OptotypeDetailedDefinition = 4587833;
  
  public static final int ReferencedRefractiveMeasurementsSequence = 4587845;
  
  public static final int SpherePower = 4587846;
  
  public static final int CylinderPower = 4587847;
  
  public static final int CornealTopographySurface = 4588033;
  
  public static final int CornealVertexLocation = 4588034;
  
  public static final int PupilCentroidXCoordinate = 4588035;
  
  public static final int PupilCentroidYCoordinate = 4588036;
  
  public static final int EquivalentPupilRadius = 4588037;
  
  public static final int CornealTopographyMapTypeCodeSequence = 4588039;
  
  public static final int VerticesOfTheOutlineOfPupil = 4588040;
  
  public static final int CornealTopographyMappingNormalsSequence = 4588048;
  
  public static final int MaximumCornealCurvatureSequence = 4588049;
  
  public static final int MaximumCornealCurvature = 4588050;
  
  public static final int MaximumCornealCurvatureLocation = 4588051;
  
  public static final int MinimumKeratometricSequence = 4588053;
  
  public static final int SimulatedKeratometricCylinderSequence = 4588056;
  
  public static final int AverageCornealPower = 4588064;
  
  public static final int CornealISValue = 4588068;
  
  public static final int AnalyzedArea = 4588071;
  
  public static final int SurfaceRegularityIndex = 4588080;
  
  public static final int SurfaceAsymmetryIndex = 4588082;
  
  public static final int CornealEccentricityIndex = 4588084;
  
  public static final int KeratoconusPredictionIndex = 4588086;
  
  public static final int DecimalPotentialVisualAcuity = 4588088;
  
  public static final int CornealTopographyMapQualityEvaluation = 4588098;
  
  public static final int SourceImageCornealProcessedDataSequence = 4588100;
  
  public static final int CornealPointLocation = 4588103;
  
  public static final int CornealPointEstimated = 4588104;
  
  public static final int AxialPower = 4588105;
  
  public static final int TangentialPower = 4588112;
  
  public static final int RefractivePower = 4588113;
  
  public static final int RelativeElevation = 4588114;
  
  public static final int CornealWavefront = 4588115;
  
  public static final int ImagedVolumeWidth = 4718593;
  
  public static final int ImagedVolumeHeight = 4718594;
  
  public static final int ImagedVolumeDepth = 4718595;
  
  public static final int TotalPixelMatrixColumns = 4718598;
  
  public static final int TotalPixelMatrixRows = 4718599;
  
  public static final int TotalPixelMatrixOriginSequence = 4718600;
  
  public static final int SpecimenLabelInImage = 4718608;
  
  public static final int FocusMethod = 4718609;
  
  public static final int ExtendedDepthOfField = 4718610;
  
  public static final int NumberOfFocalPlanes = 4718611;
  
  public static final int DistanceBetweenFocalPlanes = 4718612;
  
  public static final int RecommendedAbsentPixelCIELabValue = 4718613;
  
  public static final int IlluminatorTypeCodeSequence = 4718848;
  
  public static final int ImageOrientationSlide = 4718850;
  
  public static final int OpticalPathSequence = 4718853;
  
  public static final int OpticalPathIdentifier = 4718854;
  
  public static final int OpticalPathDescription = 4718855;
  
  public static final int IlluminationColorCodeSequence = 4718856;
  
  public static final int SpecimenReferenceSequence = 4718864;
  
  public static final int CondenserLensPower = 4718865;
  
  public static final int ObjectiveLensPower = 4718866;
  
  public static final int ObjectiveLensNumericalAperture = 4718867;
  
  public static final int PaletteColorLookupTableSequence = 4718880;
  
  public static final int ReferencedImageNavigationSequence = 4719104;
  
  public static final int TopLeftHandCornerOfLocalizerArea = 4719105;
  
  public static final int BottomRightHandCornerOfLocalizerArea = 4719106;
  
  public static final int OpticalPathIdentificationSequence = 4719111;
  
  public static final int PlanePositionSlideSequence = 4719130;
  
  public static final int ColumnPositionInTotalImagePixelMatrix = 4719134;
  
  public static final int RowPositionInTotalImagePixelMatrix = 4719135;
  
  public static final int PixelOriginInterpretation = 4719361;
  
  public static final int CalibrationImage = 5242884;
  
  public static final int DeviceSequence = 5242896;
  
  public static final int ContainerComponentTypeCodeSequence = 5242898;
  
  public static final int ContainerComponentThickness = 5242899;
  
  public static final int DeviceLength = 5242900;
  
  public static final int ContainerComponentWidth = 5242901;
  
  public static final int DeviceDiameter = 5242902;
  
  public static final int DeviceDiameterUnits = 5242903;
  
  public static final int DeviceVolume = 5242904;
  
  public static final int InterMarkerDistance = 5242905;
  
  public static final int ContainerComponentMaterial = 5242906;
  
  public static final int ContainerComponentID = 5242907;
  
  public static final int ContainerComponentLength = 5242908;
  
  public static final int ContainerComponentDiameter = 5242909;
  
  public static final int ContainerComponentDescription = 5242910;
  
  public static final int DeviceDescription = 5242912;
  
  public static final int ContrastBolusIngredientPercentByVolume = 5373953;
  
  public static final int OCTFocalDistance = 5373954;
  
  public static final int BeamSpotSize = 5373955;
  
  public static final int EffectiveRefractiveIndex = 5373956;
  
  public static final int OCTAcquisitionDomain = 5373958;
  
  public static final int OCTOpticalCenterWavelength = 5373959;
  
  public static final int AxialResolution = 5373960;
  
  public static final int RangingDepth = 5373961;
  
  public static final int ALineRate = 5373969;
  
  public static final int ALinesPerFrame = 5373970;
  
  public static final int CatheterRotationalRate = 5373971;
  
  public static final int ALinePixelSpacing = 5373972;
  
  public static final int ModeOfPercutaneousAccessSequence = 5373974;
  
  public static final int IntravascularOCTFrameTypeSequence = 5373989;
  
  public static final int OCTZOffsetApplied = 5373990;
  
  public static final int IntravascularFrameContentSequence = 5373991;
  
  public static final int IntravascularLongitudinalDistance = 5373992;
  
  public static final int IntravascularOCTFrameContentSequence = 5373993;
  
  public static final int OCTZOffsetCorrection = 5374000;
  
  public static final int CatheterDirectionOfRotation = 5374001;
  
  public static final int SeamLineLocation = 5374003;
  
  public static final int FirstALineLocation = 5374004;
  
  public static final int SeamLineIndex = 5374006;
  
  public static final int NumberOfPaddedALines = 5374008;
  
  public static final int InterpolationType = 5374009;
  
  public static final int RefractiveIndexApplied = 5374010;
  
  public static final int EnergyWindowVector = 5505040;
  
  public static final int NumberOfEnergyWindows = 5505041;
  
  public static final int EnergyWindowInformationSequence = 5505042;
  
  public static final int EnergyWindowRangeSequence = 5505043;
  
  public static final int EnergyWindowLowerLimit = 5505044;
  
  public static final int EnergyWindowUpperLimit = 5505045;
  
  public static final int RadiopharmaceuticalInformationSequence = 5505046;
  
  public static final int ResidualSyringeCounts = 5505047;
  
  public static final int EnergyWindowName = 5505048;
  
  public static final int DetectorVector = 5505056;
  
  public static final int NumberOfDetectors = 5505057;
  
  public static final int DetectorInformationSequence = 5505058;
  
  public static final int PhaseVector = 5505072;
  
  public static final int NumberOfPhases = 5505073;
  
  public static final int PhaseInformationSequence = 5505074;
  
  public static final int NumberOfFramesInPhase = 5505075;
  
  public static final int PhaseDelay = 5505078;
  
  public static final int PauseBetweenFrames = 5505080;
  
  public static final int PhaseDescription = 5505081;
  
  public static final int RotationVector = 5505104;
  
  public static final int NumberOfRotations = 5505105;
  
  public static final int RotationInformationSequence = 5505106;
  
  public static final int NumberOfFramesInRotation = 5505107;
  
  public static final int RRIntervalVector = 5505120;
  
  public static final int NumberOfRRIntervals = 5505121;
  
  public static final int GatedInformationSequence = 5505122;
  
  public static final int DataInformationSequence = 5505123;
  
  public static final int TimeSlotVector = 5505136;
  
  public static final int NumberOfTimeSlots = 5505137;
  
  public static final int TimeSlotInformationSequence = 5505138;
  
  public static final int TimeSlotTime = 5505139;
  
  public static final int SliceVector = 5505152;
  
  public static final int NumberOfSlices = 5505153;
  
  public static final int AngularViewVector = 5505168;
  
  public static final int TimeSliceVector = 5505280;
  
  public static final int NumberOfTimeSlices = 5505281;
  
  public static final int StartAngle = 5505536;
  
  public static final int TypeOfDetectorMotion = 5505538;
  
  public static final int TriggerVector = 5505552;
  
  public static final int NumberOfTriggersInPhase = 5505553;
  
  public static final int ViewCodeSequence = 5505568;
  
  public static final int ViewModifierCodeSequence = 5505570;
  
  public static final int RadionuclideCodeSequence = 5505792;
  
  public static final int AdministrationRouteCodeSequence = 5505794;
  
  public static final int RadiopharmaceuticalCodeSequence = 5505796;
  
  public static final int CalibrationDataSequence = 5505798;
  
  public static final int EnergyWindowNumber = 5505800;
  
  public static final int ImageID = 5506048;
  
  public static final int PatientOrientationCodeSequence = 5506064;
  
  public static final int PatientOrientationModifierCodeSequence = 5506066;
  
  public static final int PatientGantryRelationshipCodeSequence = 5506068;
  
  public static final int SliceProgressionDirection = 5506304;
  
  public static final int ScanProgressionDirection = 5506305;
  
  public static final int SeriesType = 5509120;
  
  public static final int Units = 5509121;
  
  public static final int CountsSource = 5509122;
  
  public static final int ReprojectionMethod = 5509124;
  
  public static final int SUVType = 5509126;
  
  public static final int RandomsCorrectionMethod = 5509376;
  
  public static final int AttenuationCorrectionMethod = 5509377;
  
  public static final int DecayCorrection = 5509378;
  
  public static final int ReconstructionMethod = 5509379;
  
  public static final int DetectorLinesOfResponseUsed = 5509380;
  
  public static final int ScatterCorrectionMethod = 5509381;
  
  public static final int AxialAcceptance = 5509632;
  
  public static final int AxialMash = 5509633;
  
  public static final int TransverseMash = 5509634;
  
  public static final int DetectorElementSize = 5509635;
  
  public static final int CoincidenceWindowWidth = 5509648;
  
  public static final int SecondaryCountsType = 5509664;
  
  public static final int FrameReferenceTime = 5509888;
  
  public static final int PrimaryPromptsCountsAccumulated = 5509904;
  
  public static final int SecondaryCountsAccumulated = 5509905;
  
  public static final int SliceSensitivityFactor = 5509920;
  
  public static final int DecayFactor = 5509921;
  
  public static final int DoseCalibrationFactor = 5509922;
  
  public static final int ScatterFractionFactor = 5509923;
  
  public static final int DeadTimeFactor = 5509924;
  
  public static final int ImageIndex = 5509936;
  
  public static final int CountsIncluded = 5510144;
  
  public static final int DeadTimeCorrectionFlag = 5510145;
  
  public static final int HistogramSequence = 6303744;
  
  public static final int HistogramNumberOfBins = 6303746;
  
  public static final int HistogramFirstBinValue = 6303748;
  
  public static final int HistogramLastBinValue = 6303750;
  
  public static final int HistogramBinWidth = 6303752;
  
  public static final int HistogramExplanation = 6303760;
  
  public static final int HistogramData = 6303776;
  
  public static final int SegmentationType = 6422529;
  
  public static final int SegmentSequence = 6422530;
  
  public static final int SegmentedPropertyCategoryCodeSequence = 6422531;
  
  public static final int SegmentNumber = 6422532;
  
  public static final int SegmentLabel = 6422533;
  
  public static final int SegmentDescription = 6422534;
  
  public static final int SegmentAlgorithmType = 6422536;
  
  public static final int SegmentAlgorithmName = 6422537;
  
  public static final int SegmentIdentificationSequence = 6422538;
  
  public static final int ReferencedSegmentNumber = 6422539;
  
  public static final int RecommendedDisplayGrayscaleValue = 6422540;
  
  public static final int RecommendedDisplayCIELabValue = 6422541;
  
  public static final int MaximumFractionalValue = 6422542;
  
  public static final int SegmentedPropertyTypeCodeSequence = 6422543;
  
  public static final int SegmentationFractionalType = 6422544;
  
  public static final int SegmentedPropertyTypeModifierCodeSequence = 6422545;
  
  public static final int UsedSegmentsSequence = 6422546;
  
  public static final int DeformableRegistrationSequence = 6553602;
  
  public static final int SourceFrameOfReferenceUID = 6553603;
  
  public static final int DeformableRegistrationGridSequence = 6553605;
  
  public static final int GridDimensions = 6553607;
  
  public static final int GridResolution = 6553608;
  
  public static final int VectorGridData = 6553609;
  
  public static final int PreDeformationMatrixRegistrationSequence = 6553615;
  
  public static final int PostDeformationMatrixRegistrationSequence = 6553616;
  
  public static final int NumberOfSurfaces = 6684673;
  
  public static final int SurfaceSequence = 6684674;
  
  public static final int SurfaceNumber = 6684675;
  
  public static final int SurfaceComments = 6684676;
  
  public static final int SurfaceProcessing = 6684681;
  
  public static final int SurfaceProcessingRatio = 6684682;
  
  public static final int SurfaceProcessingDescription = 6684683;
  
  public static final int RecommendedPresentationOpacity = 6684684;
  
  public static final int RecommendedPresentationType = 6684685;
  
  public static final int FiniteVolume = 6684686;
  
  public static final int Manifold = 6684688;
  
  public static final int SurfacePointsSequence = 6684689;
  
  public static final int SurfacePointsNormalsSequence = 6684690;
  
  public static final int SurfaceMeshPrimitivesSequence = 6684691;
  
  public static final int NumberOfSurfacePoints = 6684693;
  
  public static final int PointCoordinatesData = 6684694;
  
  public static final int PointPositionAccuracy = 6684695;
  
  public static final int MeanPointDistance = 6684696;
  
  public static final int MaximumPointDistance = 6684697;
  
  public static final int PointsBoundingBoxCoordinates = 6684698;
  
  public static final int AxisOfRotation = 6684699;
  
  public static final int CenterOfRotation = 6684700;
  
  public static final int NumberOfVectors = 6684702;
  
  public static final int VectorDimensionality = 6684703;
  
  public static final int VectorAccuracy = 6684704;
  
  public static final int VectorCoordinateData = 6684705;
  
  public static final int TrianglePointIndexList = 6684707;
  
  public static final int EdgePointIndexList = 6684708;
  
  public static final int VertexPointIndexList = 6684709;
  
  public static final int TriangleStripSequence = 6684710;
  
  public static final int TriangleFanSequence = 6684711;
  
  public static final int LineSequence = 6684712;
  
  public static final int PrimitivePointIndexList = 6684713;
  
  public static final int SurfaceCount = 6684714;
  
  public static final int ReferencedSurfaceSequence = 6684715;
  
  public static final int ReferencedSurfaceNumber = 6684716;
  
  public static final int SegmentSurfaceGenerationAlgorithmIdentificationSequence = 6684717;
  
  public static final int SegmentSurfaceSourceInstanceSequence = 6684718;
  
  public static final int AlgorithmFamilyCodeSequence = 6684719;
  
  public static final int AlgorithmNameCodeSequence = 6684720;
  
  public static final int AlgorithmVersion = 6684721;
  
  public static final int AlgorithmParameters = 6684722;
  
  public static final int FacetSequence = 6684724;
  
  public static final int SurfaceProcessingAlgorithmIdentificationSequence = 6684725;
  
  public static final int AlgorithmName = 6684726;
  
  public static final int RecommendedPointRadius = 6684727;
  
  public static final int RecommendedLineThickness = 6684728;
  
  public static final int LongPrimitivePointIndexList = 6684736;
  
  public static final int LongTrianglePointIndexList = 6684737;
  
  public static final int LongEdgePointIndexList = 6684738;
  
  public static final int LongVertexPointIndexList = 6684739;
  
  public static final int ImplantSize = 6840848;
  
  public static final int ImplantTemplateVersion = 6840865;
  
  public static final int ReplacedImplantTemplateSequence = 6840866;
  
  public static final int ImplantType = 6840867;
  
  public static final int DerivationImplantTemplateSequence = 6840868;
  
  public static final int OriginalImplantTemplateSequence = 6840869;
  
  public static final int EffectiveDateTime = 6840870;
  
  public static final int ImplantTargetAnatomySequence = 6840880;
  
  public static final int InformationFromManufacturerSequence = 6840928;
  
  public static final int NotificationFromManufacturerSequence = 6840933;
  
  public static final int InformationIssueDateTime = 6840944;
  
  public static final int InformationSummary = 6840960;
  
  public static final int ImplantRegulatoryDisapprovalCodeSequence = 6840992;
  
  public static final int OverallTemplateSpatialTolerance = 6840997;
  
  public static final int HPGLDocumentSequence = 6841024;
  
  public static final int HPGLDocumentID = 6841040;
  
  public static final int HPGLDocumentLabel = 6841045;
  
  public static final int ViewOrientationCodeSequence = 6841056;
  
  public static final int ViewOrientationModifier = 6841072;
  
  public static final int HPGLDocumentScaling = 6841074;
  
  public static final int HPGLDocument = 6841088;
  
  public static final int HPGLContourPenNumber = 6841104;
  
  public static final int HPGLPenSequence = 6841120;
  
  public static final int HPGLPenNumber = 6841136;
  
  public static final int HPGLPenLabel = 6841152;
  
  public static final int HPGLPenDescription = 6841157;
  
  public static final int RecommendedRotationPoint = 6841158;
  
  public static final int BoundingRectangle = 6841159;
  
  public static final int ImplantTemplate3DModelSurfaceNumber = 6841168;
  
  public static final int SurfaceModelDescriptionSequence = 6841184;
  
  public static final int SurfaceModelLabel = 6841216;
  
  public static final int SurfaceModelScalingFactor = 6841232;
  
  public static final int MaterialsCodeSequence = 6841248;
  
  public static final int CoatingMaterialsCodeSequence = 6841252;
  
  public static final int ImplantTypeCodeSequence = 6841256;
  
  public static final int FixationMethodCodeSequence = 6841260;
  
  public static final int MatingFeatureSetsSequence = 6841264;
  
  public static final int MatingFeatureSetID = 6841280;
  
  public static final int MatingFeatureSetLabel = 6841296;
  
  public static final int MatingFeatureSequence = 6841312;
  
  public static final int MatingFeatureID = 6841328;
  
  public static final int MatingFeatureDegreeOfFreedomSequence = 6841344;
  
  public static final int DegreeOfFreedomID = 6841360;
  
  public static final int DegreeOfFreedomType = 6841376;
  
  public static final int TwoDMatingFeatureCoordinatesSequence = 6841392;
  
  public static final int ReferencedHPGLDocumentID = 6841408;
  
  public static final int TwoDMatingPoint = 6841424;
  
  public static final int TwoDMatingAxes = 6841440;
  
  public static final int TwoDDegreeOfFreedomSequence = 6841456;
  
  public static final int ThreeDDegreeOfFreedomAxis = 6841488;
  
  public static final int RangeOfFreedom = 6841504;
  
  public static final int ThreeDMatingPoint = 6841536;
  
  public static final int ThreeDMatingAxes = 6841552;
  
  public static final int TwoDDegreeOfFreedomAxis = 6841584;
  
  public static final int PlanningLandmarkPointSequence = 6841600;
  
  public static final int PlanningLandmarkLineSequence = 6841616;
  
  public static final int PlanningLandmarkPlaneSequence = 6841632;
  
  public static final int PlanningLandmarkID = 6841648;
  
  public static final int PlanningLandmarkDescription = 6841664;
  
  public static final int PlanningLandmarkIdentificationCodeSequence = 6841669;
  
  public static final int TwoDPointCoordinatesSequence = 6841680;
  
  public static final int TwoDPointCoordinates = 6841696;
  
  public static final int ThreeDPointCoordinates = 6841744;
  
  public static final int TwoDLineCoordinatesSequence = 6841760;
  
  public static final int TwoDLineCoordinates = 6841776;
  
  public static final int ThreeDLineCoordinates = 6841808;
  
  public static final int TwoDPlaneCoordinatesSequence = 6841824;
  
  public static final int TwoDPlaneIntersection = 6841840;
  
  public static final int ThreeDPlaneOrigin = 6841872;
  
  public static final int ThreeDPlaneNormal = 6841888;
  
  public static final int GraphicAnnotationSequence = 7340033;
  
  public static final int GraphicLayer = 7340034;
  
  public static final int BoundingBoxAnnotationUnits = 7340035;
  
  public static final int AnchorPointAnnotationUnits = 7340036;
  
  public static final int GraphicAnnotationUnits = 7340037;
  
  public static final int UnformattedTextValue = 7340038;
  
  public static final int TextObjectSequence = 7340040;
  
  public static final int GraphicObjectSequence = 7340041;
  
  public static final int BoundingBoxTopLeftHandCorner = 7340048;
  
  public static final int BoundingBoxBottomRightHandCorner = 7340049;
  
  public static final int BoundingBoxTextHorizontalJustification = 7340050;
  
  public static final int AnchorPoint = 7340052;
  
  public static final int AnchorPointVisibility = 7340053;
  
  public static final int GraphicDimensions = 7340064;
  
  public static final int NumberOfGraphicPoints = 7340065;
  
  public static final int GraphicData = 7340066;
  
  public static final int GraphicType = 7340067;
  
  public static final int GraphicFilled = 7340068;
  
  public static final int ImageRotationRetired = 7340096;
  
  public static final int ImageHorizontalFlip = 7340097;
  
  public static final int ImageRotation = 7340098;
  
  public static final int DisplayedAreaTopLeftHandCornerTrial = 7340112;
  
  public static final int DisplayedAreaBottomRightHandCornerTrial = 7340113;
  
  public static final int DisplayedAreaTopLeftHandCorner = 7340114;
  
  public static final int DisplayedAreaBottomRightHandCorner = 7340115;
  
  public static final int DisplayedAreaSelectionSequence = 7340122;
  
  public static final int GraphicLayerSequence = 7340128;
  
  public static final int GraphicLayerOrder = 7340130;
  
  public static final int GraphicLayerRecommendedDisplayGrayscaleValue = 7340134;
  
  public static final int GraphicLayerRecommendedDisplayRGBValue = 7340135;
  
  public static final int GraphicLayerDescription = 7340136;
  
  public static final int ContentLabel = 7340160;
  
  public static final int ContentDescription = 7340161;
  
  public static final int PresentationCreationDate = 7340162;
  
  public static final int PresentationCreationTime = 7340163;
  
  public static final int ContentCreatorName = 7340164;
  
  public static final int ContentCreatorIdentificationCodeSequence = 7340166;
  
  public static final int AlternateContentDescriptionSequence = 7340167;
  
  public static final int PresentationSizeMode = 7340288;
  
  public static final int PresentationPixelSpacing = 7340289;
  
  public static final int PresentationPixelAspectRatio = 7340290;
  
  public static final int PresentationPixelMagnificationRatio = 7340291;
  
  public static final int GraphicGroupLabel = 7340551;
  
  public static final int GraphicGroupDescription = 7340552;
  
  public static final int CompoundGraphicSequence = 7340553;
  
  public static final int CompoundGraphicInstanceID = 7340582;
  
  public static final int FontName = 7340583;
  
  public static final int FontNameType = 7340584;
  
  public static final int CSSFontName = 7340585;
  
  public static final int RotationAngle = 7340592;
  
  public static final int TextStyleSequence = 7340593;
  
  public static final int LineStyleSequence = 7340594;
  
  public static final int FillStyleSequence = 7340595;
  
  public static final int GraphicGroupSequence = 7340596;
  
  public static final int TextColorCIELabValue = 7340609;
  
  public static final int HorizontalAlignment = 7340610;
  
  public static final int VerticalAlignment = 7340611;
  
  public static final int ShadowStyle = 7340612;
  
  public static final int ShadowOffsetX = 7340613;
  
  public static final int ShadowOffsetY = 7340614;
  
  public static final int ShadowColorCIELabValue = 7340615;
  
  public static final int Underlined = 7340616;
  
  public static final int Bold = 7340617;
  
  public static final int Italic = 7340624;
  
  public static final int PatternOnColorCIELabValue = 7340625;
  
  public static final int PatternOffColorCIELabValue = 7340626;
  
  public static final int LineThickness = 7340627;
  
  public static final int LineDashingStyle = 7340628;
  
  public static final int LinePattern = 7340629;
  
  public static final int FillPattern = 7340630;
  
  public static final int FillMode = 7340631;
  
  public static final int ShadowOpacity = 7340632;
  
  public static final int GapLength = 7340641;
  
  public static final int DiameterOfVisibility = 7340642;
  
  public static final int RotationPoint = 7340659;
  
  public static final int TickAlignment = 7340660;
  
  public static final int ShowTickLabel = 7340664;
  
  public static final int TickLabelAlignment = 7340665;
  
  public static final int CompoundGraphicUnits = 7340674;
  
  public static final int PatternOnOpacity = 7340676;
  
  public static final int PatternOffOpacity = 7340677;
  
  public static final int MajorTicksSequence = 7340679;
  
  public static final int TickPosition = 7340680;
  
  public static final int TickLabel = 7340681;
  
  public static final int CompoundGraphicType = 7340692;
  
  public static final int GraphicGroupID = 7340693;
  
  public static final int ShapeType = 7340806;
  
  public static final int RegistrationSequence = 7340808;
  
  public static final int MatrixRegistrationSequence = 7340809;
  
  public static final int MatrixSequence = 7340810;
  
  public static final int FrameOfReferenceTransformationMatrixType = 7340812;
  
  public static final int RegistrationTypeCodeSequence = 7340813;
  
  public static final int FiducialDescription = 7340815;
  
  public static final int FiducialIdentifier = 7340816;
  
  public static final int FiducialIdentifierCodeSequence = 7340817;
  
  public static final int ContourUncertaintyRadius = 7340818;
  
  public static final int UsedFiducialsSequence = 7340820;
  
  public static final int GraphicCoordinatesDataSequence = 7340824;
  
  public static final int FiducialUID = 7340826;
  
  public static final int FiducialSetSequence = 7340828;
  
  public static final int FiducialSequence = 7340830;
  
  public static final int GraphicLayerRecommendedDisplayCIELabValue = 7341057;
  
  public static final int BlendingSequence = 7341058;
  
  public static final int RelativeOpacity = 7341059;
  
  public static final int ReferencedSpatialRegistrationSequence = 7341060;
  
  public static final int BlendingPosition = 7341061;
  
  public static final int HangingProtocolName = 7471106;
  
  public static final int HangingProtocolDescription = 7471108;
  
  public static final int HangingProtocolLevel = 7471110;
  
  public static final int HangingProtocolCreator = 7471112;
  
  public static final int HangingProtocolCreationDateTime = 7471114;
  
  public static final int HangingProtocolDefinitionSequence = 7471116;
  
  public static final int HangingProtocolUserIdentificationCodeSequence = 7471118;
  
  public static final int HangingProtocolUserGroupName = 7471120;
  
  public static final int SourceHangingProtocolSequence = 7471122;
  
  public static final int NumberOfPriorsReferenced = 7471124;
  
  public static final int ImageSetsSequence = 7471136;
  
  public static final int ImageSetSelectorSequence = 7471138;
  
  public static final int ImageSetSelectorUsageFlag = 7471140;
  
  public static final int SelectorAttribute = 7471142;
  
  public static final int SelectorValueNumber = 7471144;
  
  public static final int TimeBasedImageSetsSequence = 7471152;
  
  public static final int ImageSetNumber = 7471154;
  
  public static final int ImageSetSelectorCategory = 7471156;
  
  public static final int RelativeTime = 7471160;
  
  public static final int RelativeTimeUnits = 7471162;
  
  public static final int AbstractPriorValue = 7471164;
  
  public static final int AbstractPriorCodeSequence = 7471166;
  
  public static final int ImageSetLabel = 7471168;
  
  public static final int SelectorAttributeVR = 7471184;
  
  public static final int SelectorSequencePointer = 7471186;
  
  public static final int SelectorSequencePointerPrivateCreator = 7471188;
  
  public static final int SelectorAttributePrivateCreator = 7471190;
  
  public static final int SelectorATValue = 7471200;
  
  public static final int SelectorCSValue = 7471202;
  
  public static final int SelectorISValue = 7471204;
  
  public static final int SelectorLOValue = 7471206;
  
  public static final int SelectorLTValue = 7471208;
  
  public static final int SelectorPNValue = 7471210;
  
  public static final int SelectorSHValue = 7471212;
  
  public static final int SelectorSTValue = 7471214;
  
  public static final int SelectorUTValue = 7471216;
  
  public static final int SelectorDSValue = 7471218;
  
  public static final int SelectorFDValue = 7471220;
  
  public static final int SelectorFLValue = 7471222;
  
  public static final int SelectorULValue = 7471224;
  
  public static final int SelectorUSValue = 7471226;
  
  public static final int SelectorSLValue = 7471228;
  
  public static final int SelectorSSValue = 7471230;
  
  public static final int SelectorCodeSequenceValue = 7471232;
  
  public static final int NumberOfScreens = 7471360;
  
  public static final int NominalScreenDefinitionSequence = 7471362;
  
  public static final int NumberOfVerticalPixels = 7471364;
  
  public static final int NumberOfHorizontalPixels = 7471366;
  
  public static final int DisplayEnvironmentSpatialPosition = 7471368;
  
  public static final int ScreenMinimumGrayscaleBitDepth = 7471370;
  
  public static final int ScreenMinimumColorBitDepth = 7471372;
  
  public static final int ApplicationMaximumRepaintTime = 7471374;
  
  public static final int DisplaySetsSequence = 7471616;
  
  public static final int DisplaySetNumber = 7471618;
  
  public static final int DisplaySetLabel = 7471619;
  
  public static final int DisplaySetPresentationGroup = 7471620;
  
  public static final int DisplaySetPresentationGroupDescription = 7471622;
  
  public static final int PartialDataDisplayHandling = 7471624;
  
  public static final int SynchronizedScrollingSequence = 7471632;
  
  public static final int DisplaySetScrollingGroup = 7471634;
  
  public static final int NavigationIndicatorSequence = 7471636;
  
  public static final int NavigationDisplaySet = 7471638;
  
  public static final int ReferenceDisplaySets = 7471640;
  
  public static final int ImageBoxesSequence = 7471872;
  
  public static final int ImageBoxNumber = 7471874;
  
  public static final int ImageBoxLayoutType = 7471876;
  
  public static final int ImageBoxTileHorizontalDimension = 7471878;
  
  public static final int ImageBoxTileVerticalDimension = 7471880;
  
  public static final int ImageBoxScrollDirection = 7471888;
  
  public static final int ImageBoxSmallScrollType = 7471890;
  
  public static final int ImageBoxSmallScrollAmount = 7471892;
  
  public static final int ImageBoxLargeScrollType = 7471894;
  
  public static final int ImageBoxLargeScrollAmount = 7471896;
  
  public static final int ImageBoxOverlapPriority = 7471904;
  
  public static final int CineRelativeToRealTime = 7471920;
  
  public static final int FilterOperationsSequence = 7472128;
  
  public static final int FilterByCategory = 7472130;
  
  public static final int FilterByAttributePresence = 7472132;
  
  public static final int FilterByOperator = 7472134;
  
  public static final int StructuredDisplayBackgroundCIELabValue = 7472160;
  
  public static final int EmptyImageBoxCIELabValue = 7472161;
  
  public static final int StructuredDisplayImageBoxSequence = 7472162;
  
  public static final int StructuredDisplayTextBoxSequence = 7472164;
  
  public static final int ReferencedFirstFrameSequence = 7472167;
  
  public static final int ImageBoxSynchronizationSequence = 7472176;
  
  public static final int SynchronizedImageBoxList = 7472178;
  
  public static final int TypeOfSynchronization = 7472180;
  
  public static final int BlendingOperationType = 7472384;
  
  public static final int ReformattingOperationType = 7472400;
  
  public static final int ReformattingThickness = 7472402;
  
  public static final int ReformattingInterval = 7472404;
  
  public static final int ReformattingOperationInitialViewDirection = 7472406;
  
  public static final int ThreeDRenderingType = 7472416;
  
  public static final int SortingOperationsSequence = 7472640;
  
  public static final int SortByCategory = 7472642;
  
  public static final int SortingDirection = 7472644;
  
  public static final int DisplaySetPatientOrientation = 7472896;
  
  public static final int VOIType = 7472898;
  
  public static final int PseudoColorType = 7472900;
  
  public static final int PseudoColorPaletteInstanceReferenceSequence = 7472901;
  
  public static final int ShowGrayscaleInverted = 7472902;
  
  public static final int ShowImageTrueSizeFlag = 7472912;
  
  public static final int ShowGraphicAnnotationFlag = 7472914;
  
  public static final int ShowPatientDemographicsFlag = 7472916;
  
  public static final int ShowAcquisitionTechniquesFlag = 7472918;
  
  public static final int DisplaySetHorizontalJustification = 7472919;
  
  public static final int DisplaySetVerticalJustification = 7472920;
  
  public static final int ContinuationStartMeterset = 7602464;
  
  public static final int ContinuationEndMeterset = 7602465;
  
  public static final int ProcedureStepState = 7606272;
  
  public static final int ProcedureStepProgressInformationSequence = 7606274;
  
  public static final int ProcedureStepProgress = 7606276;
  
  public static final int ProcedureStepProgressDescription = 7606278;
  
  public static final int ProcedureStepCommunicationsURISequence = 7606280;
  
  public static final int ContactURI = 7606282;
  
  public static final int ContactDisplayName = 7606284;
  
  public static final int ProcedureStepDiscontinuationReasonCodeSequence = 7606286;
  
  public static final int BeamTaskSequence = 7606304;
  
  public static final int BeamTaskType = 7606306;
  
  public static final int BeamOrderIndexTrial = 7606308;
  
  public static final int AutosequenceFlag = 7606309;
  
  public static final int TableTopVerticalAdjustedPosition = 7606310;
  
  public static final int TableTopLongitudinalAdjustedPosition = 7606311;
  
  public static final int TableTopLateralAdjustedPosition = 7606312;
  
  public static final int PatientSupportAdjustedAngle = 7606314;
  
  public static final int TableTopEccentricAdjustedAngle = 7606315;
  
  public static final int TableTopPitchAdjustedAngle = 7606316;
  
  public static final int TableTopRollAdjustedAngle = 7606317;
  
  public static final int DeliveryVerificationImageSequence = 7606320;
  
  public static final int VerificationImageTiming = 7606322;
  
  public static final int DoubleExposureFlag = 7606324;
  
  public static final int DoubleExposureOrdering = 7606326;
  
  public static final int DoubleExposureMetersetTrial = 7606328;
  
  public static final int DoubleExposureFieldDeltaTrial = 7606330;
  
  public static final int RelatedReferenceRTImageSequence = 7606336;
  
  public static final int GeneralMachineVerificationSequence = 7606338;
  
  public static final int ConventionalMachineVerificationSequence = 7606340;
  
  public static final int IonMachineVerificationSequence = 7606342;
  
  public static final int FailedAttributesSequence = 7606344;
  
  public static final int OverriddenAttributesSequence = 7606346;
  
  public static final int ConventionalControlPointVerificationSequence = 7606348;
  
  public static final int IonControlPointVerificationSequence = 7606350;
  
  public static final int AttributeOccurrenceSequence = 7606352;
  
  public static final int AttributeOccurrencePointer = 7606354;
  
  public static final int AttributeItemSelector = 7606356;
  
  public static final int AttributeOccurrencePrivateCreator = 7606358;
  
  public static final int SelectorSequencePointerItems = 7606359;
  
  public static final int ScheduledProcedureStepPriority = 7606784;
  
  public static final int WorklistLabel = 7606786;
  
  public static final int ProcedureStepLabel = 7606788;
  
  public static final int ScheduledProcessingParametersSequence = 7606800;
  
  public static final int PerformedProcessingParametersSequence = 7606802;
  
  public static final int UnifiedProcedureStepPerformedProcedureSequence = 7606806;
  
  public static final int RelatedProcedureStepSequence = 7606816;
  
  public static final int ProcedureStepRelationshipType = 7606818;
  
  public static final int ReplacedProcedureStepSequence = 7606820;
  
  public static final int DeletionLock = 7606832;
  
  public static final int ReceivingAE = 7606836;
  
  public static final int RequestingAE = 7606838;
  
  public static final int ReasonForCancellation = 7606840;
  
  public static final int SCPStatus = 7606850;
  
  public static final int SubscriptionListStatus = 7606852;
  
  public static final int UnifiedProcedureStepListStatus = 7606854;
  
  public static final int BeamOrderIndex = 7607076;
  
  public static final int DoubleExposureMeterset = 7607096;
  
  public static final int DoubleExposureFieldDelta = 7607098;
  
  public static final int ImplantAssemblyTemplateName = 7733249;
  
  public static final int ImplantAssemblyTemplateIssuer = 7733251;
  
  public static final int ImplantAssemblyTemplateVersion = 7733254;
  
  public static final int ReplacedImplantAssemblyTemplateSequence = 7733256;
  
  public static final int ImplantAssemblyTemplateType = 7733258;
  
  public static final int OriginalImplantAssemblyTemplateSequence = 7733260;
  
  public static final int DerivationImplantAssemblyTemplateSequence = 7733262;
  
  public static final int ImplantAssemblyTemplateTargetAnatomySequence = 7733264;
  
  public static final int ProcedureTypeCodeSequence = 7733280;
  
  public static final int SurgicalTechnique = 7733296;
  
  public static final int ComponentTypesSequence = 7733298;
  
  public static final int ComponentTypeCodeSequence = 7733300;
  
  public static final int ExclusiveComponentType = 7733302;
  
  public static final int MandatoryComponentType = 7733304;
  
  public static final int ComponentSequence = 7733312;
  
  public static final int ComponentID = 7733333;
  
  public static final int ComponentAssemblySequence = 7733344;
  
  public static final int Component1ReferencedID = 7733360;
  
  public static final int Component1ReferencedMatingFeatureSetID = 7733376;
  
  public static final int Component1ReferencedMatingFeatureID = 7733392;
  
  public static final int Component2ReferencedID = 7733408;
  
  public static final int Component2ReferencedMatingFeatureSetID = 7733424;
  
  public static final int Component2ReferencedMatingFeatureID = 7733440;
  
  public static final int ImplantTemplateGroupName = 7864321;
  
  public static final int ImplantTemplateGroupDescription = 7864336;
  
  public static final int ImplantTemplateGroupIssuer = 7864352;
  
  public static final int ImplantTemplateGroupVersion = 7864356;
  
  public static final int ReplacedImplantTemplateGroupSequence = 7864358;
  
  public static final int ImplantTemplateGroupTargetAnatomySequence = 7864360;
  
  public static final int ImplantTemplateGroupMembersSequence = 7864362;
  
  public static final int ImplantTemplateGroupMemberID = 7864366;
  
  public static final int ThreeDImplantTemplateGroupMemberMatchingPoint = 7864400;
  
  public static final int ThreeDImplantTemplateGroupMemberMatchingAxes = 7864416;
  
  public static final int ImplantTemplateGroupMemberMatching2DCoordinatesSequence = 7864432;
  
  public static final int TwoDImplantTemplateGroupMemberMatchingPoint = 7864464;
  
  public static final int TwoDImplantTemplateGroupMemberMatchingAxes = 7864480;
  
  public static final int ImplantTemplateGroupVariationDimensionSequence = 7864496;
  
  public static final int ImplantTemplateGroupVariationDimensionName = 7864498;
  
  public static final int ImplantTemplateGroupVariationDimensionRankSequence = 7864500;
  
  public static final int ReferencedImplantTemplateGroupMemberID = 7864502;
  
  public static final int ImplantTemplateGroupVariationDimensionRank = 7864504;
  
  public static final int SurfaceScanAcquisitionTypeCodeSequence = 8388609;
  
  public static final int SurfaceScanModeCodeSequence = 8388610;
  
  public static final int RegistrationMethodCodeSequence = 8388611;
  
  public static final int ShotDurationTime = 8388612;
  
  public static final int ShotOffsetTime = 8388613;
  
  public static final int SurfacePointPresentationValueData = 8388614;
  
  public static final int SurfacePointColorCIELabValueData = 8388615;
  
  public static final int UVMappingSequence = 8388616;
  
  public static final int TextureLabel = 8388617;
  
  public static final int UValueData = 8388624;
  
  public static final int VValueData = 8388625;
  
  public static final int ReferencedTextureSequence = 8388626;
  
  public static final int ReferencedSurfaceDataSequence = 8388627;
  
  public static final int StorageMediaFileSetID = 8913200;
  
  public static final int StorageMediaFileSetUID = 8913216;
  
  public static final int IconImageSequence = 8913408;
  
  public static final int TopicTitle = 8915204;
  
  public static final int TopicSubject = 8915206;
  
  public static final int TopicAuthor = 8915216;
  
  public static final int TopicKeywords = 8915218;
  
  public static final int SOPInstanceStatus = 16778256;
  
  public static final int SOPAuthorizationDateTime = 16778272;
  
  public static final int SOPAuthorizationComment = 16778276;
  
  public static final int AuthorizationEquipmentCertificationNumber = 16778278;
  
  public static final int MACIDNumber = 67108869;
  
  public static final int MACCalculationTransferSyntaxUID = 67108880;
  
  public static final int MACAlgorithm = 67108885;
  
  public static final int DataElementsSigned = 67108896;
  
  public static final int DigitalSignatureUID = 67109120;
  
  public static final int DigitalSignatureDateTime = 67109125;
  
  public static final int CertificateType = 67109136;
  
  public static final int CertificateOfSigner = 67109141;
  
  public static final int Signature = 67109152;
  
  public static final int CertifiedTimestampType = 67109637;
  
  public static final int CertifiedTimestamp = 67109648;
  
  public static final int DigitalSignaturePurposeCodeSequence = 67109889;
  
  public static final int ReferencedDigitalSignatureSequence = 67109890;
  
  public static final int ReferencedSOPInstanceMACSequence = 67109891;
  
  public static final int MAC = 67109892;
  
  public static final int EncryptedAttributesSequence = 67110144;
  
  public static final int EncryptedContentTransferSyntaxUID = 67110160;
  
  public static final int EncryptedContent = 67110176;
  
  public static final int ModifiedAttributesSequence = 67110224;
  
  public static final int OriginalAttributesSequence = 67110241;
  
  public static final int AttributeModificationDateTime = 67110242;
  
  public static final int ModifyingSystem = 67110243;
  
  public static final int SourceOfPreviousValues = 67110244;
  
  public static final int ReasonForTheAttributeModification = 67110245;
  
  public static final int EscapeTriplet = 268435456;
  
  public static final int RunLengthTriplet = 268435457;
  
  public static final int HuffmanTableSize = 268435458;
  
  public static final int HuffmanTableTriplet = 268435459;
  
  public static final int ShiftTableSize = 268435460;
  
  public static final int ShiftTableTriplet = 268435461;
  
  public static final int ZonalMap = 269484032;
  
  public static final int NumberOfCopies = 536870928;
  
  public static final int PrinterConfigurationSequence = 536870942;
  
  public static final int PrintPriority = 536870944;
  
  public static final int MediumType = 536870960;
  
  public static final int FilmDestination = 536870976;
  
  public static final int FilmSessionLabel = 536870992;
  
  public static final int MemoryAllocation = 536871008;
  
  public static final int MaximumMemoryAllocation = 536871009;
  
  public static final int ColorImagePrintingFlag = 536871010;
  
  public static final int CollationFlag = 536871011;
  
  public static final int AnnotationFlag = 536871013;
  
  public static final int ImageOverlayFlag = 536871015;
  
  public static final int PresentationLUTFlag = 536871017;
  
  public static final int ImageBoxPresentationLUTFlag = 536871018;
  
  public static final int MemoryBitDepth = 536871072;
  
  public static final int PrintingBitDepth = 536871073;
  
  public static final int MediaInstalledSequence = 536871074;
  
  public static final int OtherMediaAvailableSequence = 536871076;
  
  public static final int SupportedImageDisplayFormatsSequence = 536871080;
  
  public static final int ReferencedFilmBoxSequence = 536872192;
  
  public static final int ReferencedStoredPrintSequence = 536872208;
  
  public static final int ImageDisplayFormat = 537919504;
  
  public static final int AnnotationDisplayFormatID = 537919536;
  
  public static final int FilmOrientation = 537919552;
  
  public static final int FilmSizeID = 537919568;
  
  public static final int PrinterResolutionID = 537919570;
  
  public static final int DefaultPrinterResolutionID = 537919572;
  
  public static final int MagnificationType = 537919584;
  
  public static final int SmoothingType = 537919616;
  
  public static final int DefaultMagnificationType = 537919654;
  
  public static final int OtherMagnificationTypesAvailable = 537919655;
  
  public static final int DefaultSmoothingType = 537919656;
  
  public static final int OtherSmoothingTypesAvailable = 537919657;
  
  public static final int BorderDensity = 537919744;
  
  public static final int EmptyImageDensity = 537919760;
  
  public static final int MinDensity = 537919776;
  
  public static final int MaxDensity = 537919792;
  
  public static final int Trim = 537919808;
  
  public static final int ConfigurationInformation = 537919824;
  
  public static final int ConfigurationInformationDescription = 537919826;
  
  public static final int MaximumCollatedFilms = 537919828;
  
  public static final int Illumination = 537919838;
  
  public static final int ReflectedAmbientLight = 537919840;
  
  public static final int PrinterPixelSpacing = 537920374;
  
  public static final int ReferencedFilmSessionSequence = 537920768;
  
  public static final int ReferencedImageBoxSequence = 537920784;
  
  public static final int ReferencedBasicAnnotationBoxSequence = 537920800;
  
  public static final int ImageBoxPosition = 538968080;
  
  public static final int Polarity = 538968096;
  
  public static final int RequestedImageSize = 538968112;
  
  public static final int RequestedDecimateCropBehavior = 538968128;
  
  public static final int RequestedResolutionID = 538968144;
  
  public static final int RequestedImageSizeFlag = 538968224;
  
  public static final int DecimateCropResult = 538968226;
  
  public static final int BasicGrayscaleImageSequence = 538968336;
  
  public static final int BasicColorImageSequence = 538968337;
  
  public static final int ReferencedImageOverlayBoxSequence = 538968368;
  
  public static final int ReferencedVOILUTBoxSequence = 538968384;
  
  public static final int AnnotationPosition = 540016656;
  
  public static final int TextString = 540016672;
  
  public static final int ReferencedOverlayPlaneSequence = 541065232;
  
  public static final int ReferencedOverlayPlaneGroups = 541065233;
  
  public static final int OverlayPixelDataSequence = 541065248;
  
  public static final int OverlayMagnificationType = 541065312;
  
  public static final int OverlaySmoothingType = 541065328;
  
  public static final int OverlayOrImageMagnification = 541065330;
  
  public static final int MagnifyToNumberOfColumns = 541065332;
  
  public static final int OverlayForegroundDensity = 541065344;
  
  public static final int OverlayBackgroundDensity = 541065346;
  
  public static final int OverlayMode = 541065360;
  
  public static final int ThresholdDensity = 541065472;
  
  public static final int ReferencedImageBoxSequenceRetired = 541066496;
  
  public static final int PresentationLUTSequence = 542113808;
  
  public static final int PresentationLUTShape = 542113824;
  
  public static final int ReferencedPresentationLUTSequence = 542115072;
  
  public static final int PrintJobID = 553648144;
  
  public static final int ExecutionStatus = 553648160;
  
  public static final int ExecutionStatusInfo = 553648176;
  
  public static final int CreationDate = 553648192;
  
  public static final int CreationTime = 553648208;
  
  public static final int Originator = 553648240;
  
  public static final int DestinationAE = 553648448;
  
  public static final int OwnerID = 553648480;
  
  public static final int NumberOfFilms = 553648496;
  
  public static final int ReferencedPrintJobSequencePullStoredPrint = 553649408;
  
  public static final int PrinterStatus = 554696720;
  
  public static final int PrinterStatusInfo = 554696736;
  
  public static final int PrinterName = 554696752;
  
  public static final int PrintQueueID = 554696857;
  
  public static final int QueueStatus = 555745296;
  
  public static final int PrintJobDescriptionSequence = 555745360;
  
  public static final int ReferencedPrintJobSequence = 555745392;
  
  public static final int PrintManagementCapabilitiesSequence = 556793872;
  
  public static final int PrinterCharacteristicsSequence = 556793877;
  
  public static final int FilmBoxContentSequence = 556793904;
  
  public static final int ImageBoxContentSequence = 556793920;
  
  public static final int AnnotationContentSequence = 556793936;
  
  public static final int ImageOverlayBoxContentSequence = 556793952;
  
  public static final int PresentationLUTContentSequence = 556793984;
  
  public static final int ProposedStudySequence = 556794016;
  
  public static final int OriginalImageSequence = 556794048;
  
  public static final int LabelUsingInformationExtractedFromInstances = 570425345;
  
  public static final int LabelText = 570425346;
  
  public static final int LabelStyleSelection = 570425347;
  
  public static final int MediaDisposition = 570425348;
  
  public static final int BarcodeValue = 570425349;
  
  public static final int BarcodeSymbology = 570425350;
  
  public static final int AllowMediaSplitting = 570425351;
  
  public static final int IncludeNonDICOMObjects = 570425352;
  
  public static final int IncludeDisplayApplication = 570425353;
  
  public static final int PreserveCompositeInstancesAfterMediaCreation = 570425354;
  
  public static final int TotalNumberOfPiecesOfMediaCreated = 570425355;
  
  public static final int RequestedMediaApplicationProfile = 570425356;
  
  public static final int ReferencedStorageMediaSequence = 570425357;
  
  public static final int FailureAttributes = 570425358;
  
  public static final int AllowLossyCompression = 570425359;
  
  public static final int RequestPriority = 570425376;
  
  public static final int RTImageLabel = 805437442;
  
  public static final int RTImageName = 805437443;
  
  public static final int RTImageDescription = 805437444;
  
  public static final int ReportedValuesOrigin = 805437450;
  
  public static final int RTImagePlane = 805437452;
  
  public static final int XRayImageReceptorTranslation = 805437453;
  
  public static final int XRayImageReceptorAngle = 805437454;
  
  public static final int RTImageOrientation = 805437456;
  
  public static final int ImagePlanePixelSpacing = 805437457;
  
  public static final int RTImagePosition = 805437458;
  
  public static final int RadiationMachineName = 805437472;
  
  public static final int RadiationMachineSAD = 805437474;
  
  public static final int RadiationMachineSSD = 805437476;
  
  public static final int RTImageSID = 805437478;
  
  public static final int SourceToReferenceObjectDistance = 805437480;
  
  public static final int FractionNumber = 805437481;
  
  public static final int ExposureSequence = 805437488;
  
  public static final int MetersetExposure = 805437490;
  
  public static final int DiaphragmPosition = 805437492;
  
  public static final int FluenceMapSequence = 805437504;
  
  public static final int FluenceDataSource = 805437505;
  
  public static final int FluenceDataScale = 805437506;
  
  public static final int PrimaryFluenceModeSequence = 805437520;
  
  public static final int FluenceMode = 805437521;
  
  public static final int FluenceModeID = 805437522;
  
  public static final int DVHType = 805568513;
  
  public static final int DoseUnits = 805568514;
  
  public static final int DoseType = 805568516;
  
  public static final int SpatialTransformOfDose = 805568517;
  
  public static final int DoseComment = 805568518;
  
  public static final int NormalizationPoint = 805568520;
  
  public static final int DoseSummationType = 805568522;
  
  public static final int GridFrameOffsetVector = 805568524;
  
  public static final int DoseGridScaling = 805568526;
  
  public static final int RTDoseROISequence = 805568528;
  
  public static final int DoseValue = 805568530;
  
  public static final int TissueHeterogeneityCorrection = 805568532;
  
  public static final int DVHNormalizationPoint = 805568576;
  
  public static final int DVHNormalizationDoseValue = 805568578;
  
  public static final int DVHSequence = 805568592;
  
  public static final int DVHDoseScaling = 805568594;
  
  public static final int DVHVolumeUnits = 805568596;
  
  public static final int DVHNumberOfBins = 805568598;
  
  public static final int DVHData = 805568600;
  
  public static final int DVHReferencedROISequence = 805568608;
  
  public static final int DVHROIContributionType = 805568610;
  
  public static final int DVHMinimumDose = 805568624;
  
  public static final int DVHMaximumDose = 805568626;
  
  public static final int DVHMeanDose = 805568628;
  
  public static final int StructureSetLabel = 805699586;
  
  public static final int StructureSetName = 805699588;
  
  public static final int StructureSetDescription = 805699590;
  
  public static final int StructureSetDate = 805699592;
  
  public static final int StructureSetTime = 805699593;
  
  public static final int ReferencedFrameOfReferenceSequence = 805699600;
  
  public static final int RTReferencedStudySequence = 805699602;
  
  public static final int RTReferencedSeriesSequence = 805699604;
  
  public static final int ContourImageSequence = 805699606;
  
  public static final int PredecessorStructureSetSequence = 805699608;
  
  public static final int StructureSetROISequence = 805699616;
  
  public static final int ROINumber = 805699618;
  
  public static final int ReferencedFrameOfReferenceUID = 805699620;
  
  public static final int ROIName = 805699622;
  
  public static final int ROIDescription = 805699624;
  
  public static final int ROIDisplayColor = 805699626;
  
  public static final int ROIVolume = 805699628;
  
  public static final int RTRelatedROISequence = 805699632;
  
  public static final int RTROIRelationship = 805699635;
  
  public static final int ROIGenerationAlgorithm = 805699638;
  
  public static final int ROIGenerationDescription = 805699640;
  
  public static final int ROIContourSequence = 805699641;
  
  public static final int ContourSequence = 805699648;
  
  public static final int ContourGeometricType = 805699650;
  
  public static final int ContourSlabThickness = 805699652;
  
  public static final int ContourOffsetVector = 805699653;
  
  public static final int NumberOfContourPoints = 805699654;
  
  public static final int ContourNumber = 805699656;
  
  public static final int AttachedContours = 805699657;
  
  public static final int ContourData = 805699664;
  
  public static final int RTROIObservationsSequence = 805699712;
  
  public static final int ObservationNumber = 805699714;
  
  public static final int ReferencedROINumber = 805699716;
  
  public static final int ROIObservationLabel = 805699717;
  
  public static final int RTROIIdentificationCodeSequence = 805699718;
  
  public static final int ROIObservationDescription = 805699720;
  
  public static final int RelatedRTROIObservationsSequence = 805699744;
  
  public static final int RTROIInterpretedType = 805699748;
  
  public static final int ROIInterpreter = 805699750;
  
  public static final int ROIPhysicalPropertiesSequence = 805699760;
  
  public static final int ROIPhysicalProperty = 805699762;
  
  public static final int ROIPhysicalPropertyValue = 805699764;
  
  public static final int ROIElementalCompositionSequence = 805699766;
  
  public static final int ROIElementalCompositionAtomicNumber = 805699767;
  
  public static final int ROIElementalCompositionAtomicMassFraction = 805699768;
  
  public static final int AdditionalRTROIIdentificationCodeSequence = 805699769;
  
  public static final int FrameOfReferenceRelationshipSequence = 805699776;
  
  public static final int RelatedFrameOfReferenceUID = 805699778;
  
  public static final int FrameOfReferenceTransformationType = 805699780;
  
  public static final int FrameOfReferenceTransformationMatrix = 805699782;
  
  public static final int FrameOfReferenceTransformationComment = 805699784;
  
  public static final int MeasuredDoseReferenceSequence = 805830672;
  
  public static final int MeasuredDoseDescription = 805830674;
  
  public static final int MeasuredDoseType = 805830676;
  
  public static final int MeasuredDoseValue = 805830678;
  
  public static final int TreatmentSessionBeamSequence = 805830688;
  
  public static final int TreatmentSessionIonBeamSequence = 805830689;
  
  public static final int CurrentFractionNumber = 805830690;
  
  public static final int TreatmentControlPointDate = 805830692;
  
  public static final int TreatmentControlPointTime = 805830693;
  
  public static final int TreatmentTerminationStatus = 805830698;
  
  public static final int TreatmentTerminationCode = 805830699;
  
  public static final int TreatmentVerificationStatus = 805830700;
  
  public static final int ReferencedTreatmentRecordSequence = 805830704;
  
  public static final int SpecifiedPrimaryMeterset = 805830706;
  
  public static final int SpecifiedSecondaryMeterset = 805830707;
  
  public static final int DeliveredPrimaryMeterset = 805830710;
  
  public static final int DeliveredSecondaryMeterset = 805830711;
  
  public static final int SpecifiedTreatmentTime = 805830714;
  
  public static final int DeliveredTreatmentTime = 805830715;
  
  public static final int ControlPointDeliverySequence = 805830720;
  
  public static final int IonControlPointDeliverySequence = 805830721;
  
  public static final int SpecifiedMeterset = 805830722;
  
  public static final int DeliveredMeterset = 805830724;
  
  public static final int MetersetRateSet = 805830725;
  
  public static final int MetersetRateDelivered = 805830726;
  
  public static final int ScanSpotMetersetsDelivered = 805830727;
  
  public static final int DoseRateDelivered = 805830728;
  
  public static final int TreatmentSummaryCalculatedDoseReferenceSequence = 805830736;
  
  public static final int CumulativeDoseToDoseReference = 805830738;
  
  public static final int FirstTreatmentDate = 805830740;
  
  public static final int MostRecentTreatmentDate = 805830742;
  
  public static final int NumberOfFractionsDelivered = 805830746;
  
  public static final int OverrideSequence = 805830752;
  
  public static final int ParameterSequencePointer = 805830753;
  
  public static final int OverrideParameterPointer = 805830754;
  
  public static final int ParameterItemIndex = 805830755;
  
  public static final int MeasuredDoseReferenceNumber = 805830756;
  
  public static final int ParameterPointer = 805830757;
  
  public static final int OverrideReason = 805830758;
  
  public static final int CorrectedParameterSequence = 805830760;
  
  public static final int CorrectionValue = 805830762;
  
  public static final int CalculatedDoseReferenceSequence = 805830768;
  
  public static final int CalculatedDoseReferenceNumber = 805830770;
  
  public static final int CalculatedDoseReferenceDescription = 805830772;
  
  public static final int CalculatedDoseReferenceDoseValue = 805830774;
  
  public static final int StartMeterset = 805830776;
  
  public static final int EndMeterset = 805830778;
  
  public static final int ReferencedMeasuredDoseReferenceSequence = 805830784;
  
  public static final int ReferencedMeasuredDoseReferenceNumber = 805830786;
  
  public static final int ReferencedCalculatedDoseReferenceSequence = 805830800;
  
  public static final int ReferencedCalculatedDoseReferenceNumber = 805830802;
  
  public static final int BeamLimitingDeviceLeafPairsSequence = 805830816;
  
  public static final int RecordedWedgeSequence = 805830832;
  
  public static final int RecordedCompensatorSequence = 805830848;
  
  public static final int RecordedBlockSequence = 805830864;
  
  public static final int TreatmentSummaryMeasuredDoseReferenceSequence = 805830880;
  
  public static final int RecordedSnoutSequence = 805830896;
  
  public static final int RecordedRangeShifterSequence = 805830898;
  
  public static final int RecordedLateralSpreadingDeviceSequence = 805830900;
  
  public static final int RecordedRangeModulatorSequence = 805830902;
  
  public static final int RecordedSourceSequence = 805830912;
  
  public static final int SourceSerialNumber = 805830917;
  
  public static final int TreatmentSessionApplicationSetupSequence = 805830928;
  
  public static final int ApplicationSetupCheck = 805830934;
  
  public static final int RecordedBrachyAccessoryDeviceSequence = 805830944;
  
  public static final int ReferencedBrachyAccessoryDeviceNumber = 805830946;
  
  public static final int RecordedChannelSequence = 805830960;
  
  public static final int SpecifiedChannelTotalTime = 805830962;
  
  public static final int DeliveredChannelTotalTime = 805830964;
  
  public static final int SpecifiedNumberOfPulses = 805830966;
  
  public static final int DeliveredNumberOfPulses = 805830968;
  
  public static final int SpecifiedPulseRepetitionInterval = 805830970;
  
  public static final int DeliveredPulseRepetitionInterval = 805830972;
  
  public static final int RecordedSourceApplicatorSequence = 805830976;
  
  public static final int ReferencedSourceApplicatorNumber = 805830978;
  
  public static final int RecordedChannelShieldSequence = 805830992;
  
  public static final int ReferencedChannelShieldNumber = 805830994;
  
  public static final int BrachyControlPointDeliveredSequence = 805831008;
  
  public static final int SafePositionExitDate = 805831010;
  
  public static final int SafePositionExitTime = 805831012;
  
  public static final int SafePositionReturnDate = 805831014;
  
  public static final int SafePositionReturnTime = 805831016;
  
  public static final int PulseSpecificBrachyControlPointDeliveredSequence = 805831025;
  
  public static final int PulseNumber = 805831026;
  
  public static final int BrachyPulseControlPointDeliveredSequence = 805831027;
  
  public static final int CurrentTreatmentStatus = 805831168;
  
  public static final int TreatmentStatusComment = 805831170;
  
  public static final int FractionGroupSummarySequence = 805831200;
  
  public static final int ReferencedFractionNumber = 805831203;
  
  public static final int FractionGroupType = 805831204;
  
  public static final int BeamStopperPosition = 805831216;
  
  public static final int FractionStatusSummarySequence = 805831232;
  
  public static final int TreatmentDate = 805831248;
  
  public static final int TreatmentTime = 805831249;
  
  public static final int RTPlanLabel = 805961730;
  
  public static final int RTPlanName = 805961731;
  
  public static final int RTPlanDescription = 805961732;
  
  public static final int RTPlanDate = 805961734;
  
  public static final int RTPlanTime = 805961735;
  
  public static final int TreatmentProtocols = 805961737;
  
  public static final int PlanIntent = 805961738;
  
  public static final int TreatmentSites = 805961739;
  
  public static final int RTPlanGeometry = 805961740;
  
  public static final int PrescriptionDescription = 805961742;
  
  public static final int DoseReferenceSequence = 805961744;
  
  public static final int DoseReferenceNumber = 805961746;
  
  public static final int DoseReferenceUID = 805961747;
  
  public static final int DoseReferenceStructureType = 805961748;
  
  public static final int NominalBeamEnergyUnit = 805961749;
  
  public static final int DoseReferenceDescription = 805961750;
  
  public static final int DoseReferencePointCoordinates = 805961752;
  
  public static final int NominalPriorDose = 805961754;
  
  public static final int DoseReferenceType = 805961760;
  
  public static final int ConstraintWeight = 805961761;
  
  public static final int DeliveryWarningDose = 805961762;
  
  public static final int DeliveryMaximumDose = 805961763;
  
  public static final int TargetMinimumDose = 805961765;
  
  public static final int TargetPrescriptionDose = 805961766;
  
  public static final int TargetMaximumDose = 805961767;
  
  public static final int TargetUnderdoseVolumeFraction = 805961768;
  
  public static final int OrganAtRiskFullVolumeDose = 805961770;
  
  public static final int OrganAtRiskLimitDose = 805961771;
  
  public static final int OrganAtRiskMaximumDose = 805961772;
  
  public static final int OrganAtRiskOverdoseVolumeFraction = 805961773;
  
  public static final int ToleranceTableSequence = 805961792;
  
  public static final int ToleranceTableNumber = 805961794;
  
  public static final int ToleranceTableLabel = 805961795;
  
  public static final int GantryAngleTolerance = 805961796;
  
  public static final int BeamLimitingDeviceAngleTolerance = 805961798;
  
  public static final int BeamLimitingDeviceToleranceSequence = 805961800;
  
  public static final int BeamLimitingDevicePositionTolerance = 805961802;
  
  public static final int SnoutPositionTolerance = 805961803;
  
  public static final int PatientSupportAngleTolerance = 805961804;
  
  public static final int TableTopEccentricAngleTolerance = 805961806;
  
  public static final int TableTopPitchAngleTolerance = 805961807;
  
  public static final int TableTopRollAngleTolerance = 805961808;
  
  public static final int TableTopVerticalPositionTolerance = 805961809;
  
  public static final int TableTopLongitudinalPositionTolerance = 805961810;
  
  public static final int TableTopLateralPositionTolerance = 805961811;
  
  public static final int RTPlanRelationship = 805961813;
  
  public static final int FractionGroupSequence = 805961840;
  
  public static final int FractionGroupNumber = 805961841;
  
  public static final int FractionGroupDescription = 805961842;
  
  public static final int NumberOfFractionsPlanned = 805961848;
  
  public static final int NumberOfFractionPatternDigitsPerDay = 805961849;
  
  public static final int RepeatFractionCycleLength = 805961850;
  
  public static final int FractionPattern = 805961851;
  
  public static final int NumberOfBeams = 805961856;
  
  public static final int BeamDoseSpecificationPoint = 805961858;
  
  public static final int BeamDose = 805961860;
  
  public static final int BeamMeterset = 805961862;
  
  public static final int BeamDosePointDepth = 805961864;
  
  public static final int BeamDosePointEquivalentDepth = 805961865;
  
  public static final int BeamDosePointSSD = 805961866;
  
  public static final int BeamDoseMeaning = 805961867;
  
  public static final int BeamDoseVerificationControlPointSequence = 805961868;
  
  public static final int AverageBeamDosePointDepth = 805961869;
  
  public static final int AverageBeamDosePointEquivalentDepth = 805961870;
  
  public static final int AverageBeamDosePointSSD = 805961871;
  
  public static final int NumberOfBrachyApplicationSetups = 805961888;
  
  public static final int BrachyApplicationSetupDoseSpecificationPoint = 805961890;
  
  public static final int BrachyApplicationSetupDose = 805961892;
  
  public static final int BeamSequence = 805961904;
  
  public static final int TreatmentMachineName = 805961906;
  
  public static final int PrimaryDosimeterUnit = 805961907;
  
  public static final int SourceAxisDistance = 805961908;
  
  public static final int BeamLimitingDeviceSequence = 805961910;
  
  public static final int RTBeamLimitingDeviceType = 805961912;
  
  public static final int SourceToBeamLimitingDeviceDistance = 805961914;
  
  public static final int IsocenterToBeamLimitingDeviceDistance = 805961915;
  
  public static final int NumberOfLeafJawPairs = 805961916;
  
  public static final int LeafPositionBoundaries = 805961918;
  
  public static final int BeamNumber = 805961920;
  
  public static final int BeamName = 805961922;
  
  public static final int BeamDescription = 805961923;
  
  public static final int BeamType = 805961924;
  
  public static final int BeamDeliveryDurationLimit = 805961925;
  
  public static final int RadiationType = 805961926;
  
  public static final int HighDoseTechniqueType = 805961927;
  
  public static final int ReferenceImageNumber = 805961928;
  
  public static final int PlannedVerificationImageSequence = 805961930;
  
  public static final int ImagingDeviceSpecificAcquisitionParameters = 805961932;
  
  public static final int TreatmentDeliveryType = 805961934;
  
  public static final int NumberOfWedges = 805961936;
  
  public static final int WedgeSequence = 805961937;
  
  public static final int WedgeNumber = 805961938;
  
  public static final int WedgeType = 805961939;
  
  public static final int WedgeID = 805961940;
  
  public static final int WedgeAngle = 805961941;
  
  public static final int WedgeFactor = 805961942;
  
  public static final int TotalWedgeTrayWaterEquivalentThickness = 805961943;
  
  public static final int WedgeOrientation = 805961944;
  
  public static final int IsocenterToWedgeTrayDistance = 805961945;
  
  public static final int SourceToWedgeTrayDistance = 805961946;
  
  public static final int WedgeThinEdgePosition = 805961947;
  
  public static final int BolusID = 805961948;
  
  public static final int BolusDescription = 805961949;
  
  public static final int EffectiveWedgeAngle = 805961950;
  
  public static final int NumberOfCompensators = 805961952;
  
  public static final int MaterialID = 805961953;
  
  public static final int TotalCompensatorTrayFactor = 805961954;
  
  public static final int CompensatorSequence = 805961955;
  
  public static final int CompensatorNumber = 805961956;
  
  public static final int CompensatorID = 805961957;
  
  public static final int SourceToCompensatorTrayDistance = 805961958;
  
  public static final int CompensatorRows = 805961959;
  
  public static final int CompensatorColumns = 805961960;
  
  public static final int CompensatorPixelSpacing = 805961961;
  
  public static final int CompensatorPosition = 805961962;
  
  public static final int CompensatorTransmissionData = 805961963;
  
  public static final int CompensatorThicknessData = 805961964;
  
  public static final int NumberOfBoli = 805961965;
  
  public static final int CompensatorType = 805961966;
  
  public static final int CompensatorTrayID = 805961967;
  
  public static final int NumberOfBlocks = 805961968;
  
  public static final int TotalBlockTrayFactor = 805961970;
  
  public static final int TotalBlockTrayWaterEquivalentThickness = 805961971;
  
  public static final int BlockSequence = 805961972;
  
  public static final int BlockTrayID = 805961973;
  
  public static final int SourceToBlockTrayDistance = 805961974;
  
  public static final int IsocenterToBlockTrayDistance = 805961975;
  
  public static final int BlockType = 805961976;
  
  public static final int AccessoryCode = 805961977;
  
  public static final int BlockDivergence = 805961978;
  
  public static final int BlockMountingPosition = 805961979;
  
  public static final int BlockNumber = 805961980;
  
  public static final int BlockName = 805961982;
  
  public static final int BlockThickness = 805961984;
  
  public static final int BlockTransmission = 805961986;
  
  public static final int BlockNumberOfPoints = 805961988;
  
  public static final int BlockData = 805961990;
  
  public static final int ApplicatorSequence = 805961991;
  
  public static final int ApplicatorID = 805961992;
  
  public static final int ApplicatorType = 805961993;
  
  public static final int ApplicatorDescription = 805961994;
  
  public static final int CumulativeDoseReferenceCoefficient = 805961996;
  
  public static final int FinalCumulativeMetersetWeight = 805961998;
  
  public static final int NumberOfControlPoints = 805962000;
  
  public static final int ControlPointSequence = 805962001;
  
  public static final int ControlPointIndex = 805962002;
  
  public static final int NominalBeamEnergy = 805962004;
  
  public static final int DoseRateSet = 805962005;
  
  public static final int WedgePositionSequence = 805962006;
  
  public static final int WedgePosition = 805962008;
  
  public static final int BeamLimitingDevicePositionSequence = 805962010;
  
  public static final int LeafJawPositions = 805962012;
  
  public static final int GantryAngle = 805962014;
  
  public static final int GantryRotationDirection = 805962015;
  
  public static final int BeamLimitingDeviceAngle = 805962016;
  
  public static final int BeamLimitingDeviceRotationDirection = 805962017;
  
  public static final int PatientSupportAngle = 805962018;
  
  public static final int PatientSupportRotationDirection = 805962019;
  
  public static final int TableTopEccentricAxisDistance = 805962020;
  
  public static final int TableTopEccentricAngle = 805962021;
  
  public static final int TableTopEccentricRotationDirection = 805962022;
  
  public static final int TableTopVerticalPosition = 805962024;
  
  public static final int TableTopLongitudinalPosition = 805962025;
  
  public static final int TableTopLateralPosition = 805962026;
  
  public static final int IsocenterPosition = 805962028;
  
  public static final int SurfaceEntryPoint = 805962030;
  
  public static final int SourceToSurfaceDistance = 805962032;
  
  public static final int CumulativeMetersetWeight = 805962036;
  
  public static final int TableTopPitchAngle = 805962048;
  
  public static final int TableTopPitchRotationDirection = 805962050;
  
  public static final int TableTopRollAngle = 805962052;
  
  public static final int TableTopRollRotationDirection = 805962054;
  
  public static final int HeadFixationAngle = 805962056;
  
  public static final int GantryPitchAngle = 805962058;
  
  public static final int GantryPitchRotationDirection = 805962060;
  
  public static final int GantryPitchAngleTolerance = 805962062;
  
  public static final int PatientSetupSequence = 805962112;
  
  public static final int PatientSetupNumber = 805962114;
  
  public static final int PatientSetupLabel = 805962115;
  
  public static final int PatientAdditionalPosition = 805962116;
  
  public static final int FixationDeviceSequence = 805962128;
  
  public static final int FixationDeviceType = 805962130;
  
  public static final int FixationDeviceLabel = 805962132;
  
  public static final int FixationDeviceDescription = 805962134;
  
  public static final int FixationDevicePosition = 805962136;
  
  public static final int FixationDevicePitchAngle = 805962137;
  
  public static final int FixationDeviceRollAngle = 805962138;
  
  public static final int ShieldingDeviceSequence = 805962144;
  
  public static final int ShieldingDeviceType = 805962146;
  
  public static final int ShieldingDeviceLabel = 805962148;
  
  public static final int ShieldingDeviceDescription = 805962150;
  
  public static final int ShieldingDevicePosition = 805962152;
  
  public static final int SetupTechnique = 805962160;
  
  public static final int SetupTechniqueDescription = 805962162;
  
  public static final int SetupDeviceSequence = 805962164;
  
  public static final int SetupDeviceType = 805962166;
  
  public static final int SetupDeviceLabel = 805962168;
  
  public static final int SetupDeviceDescription = 805962170;
  
  public static final int SetupDeviceParameter = 805962172;
  
  public static final int SetupReferenceDescription = 805962192;
  
  public static final int TableTopVerticalSetupDisplacement = 805962194;
  
  public static final int TableTopLongitudinalSetupDisplacement = 805962196;
  
  public static final int TableTopLateralSetupDisplacement = 805962198;
  
  public static final int BrachyTreatmentTechnique = 805962240;
  
  public static final int BrachyTreatmentType = 805962242;
  
  public static final int TreatmentMachineSequence = 805962246;
  
  public static final int SourceSequence = 805962256;
  
  public static final int SourceNumber = 805962258;
  
  public static final int SourceType = 805962260;
  
  public static final int SourceManufacturer = 805962262;
  
  public static final int ActiveSourceDiameter = 805962264;
  
  public static final int ActiveSourceLength = 805962266;
  
  public static final int SourceModelID = 805962267;
  
  public static final int SourceDescription = 805962268;
  
  public static final int SourceEncapsulationNominalThickness = 805962274;
  
  public static final int SourceEncapsulationNominalTransmission = 805962276;
  
  public static final int SourceIsotopeName = 805962278;
  
  public static final int SourceIsotopeHalfLife = 805962280;
  
  public static final int SourceStrengthUnits = 805962281;
  
  public static final int ReferenceAirKermaRate = 805962282;
  
  public static final int SourceStrength = 805962283;
  
  public static final int SourceStrengthReferenceDate = 805962284;
  
  public static final int SourceStrengthReferenceTime = 805962286;
  
  public static final int ApplicationSetupSequence = 805962288;
  
  public static final int ApplicationSetupType = 805962290;
  
  public static final int ApplicationSetupNumber = 805962292;
  
  public static final int ApplicationSetupName = 805962294;
  
  public static final int ApplicationSetupManufacturer = 805962296;
  
  public static final int TemplateNumber = 805962304;
  
  public static final int TemplateType = 805962306;
  
  public static final int TemplateName = 805962308;
  
  public static final int TotalReferenceAirKerma = 805962320;
  
  public static final int BrachyAccessoryDeviceSequence = 805962336;
  
  public static final int BrachyAccessoryDeviceNumber = 805962338;
  
  public static final int BrachyAccessoryDeviceID = 805962339;
  
  public static final int BrachyAccessoryDeviceType = 805962340;
  
  public static final int BrachyAccessoryDeviceName = 805962342;
  
  public static final int BrachyAccessoryDeviceNominalThickness = 805962346;
  
  public static final int BrachyAccessoryDeviceNominalTransmission = 805962348;
  
  public static final int ChannelSequence = 805962368;
  
  public static final int ChannelNumber = 805962370;
  
  public static final int ChannelLength = 805962372;
  
  public static final int ChannelTotalTime = 805962374;
  
  public static final int SourceMovementType = 805962376;
  
  public static final int NumberOfPulses = 805962378;
  
  public static final int PulseRepetitionInterval = 805962380;
  
  public static final int SourceApplicatorNumber = 805962384;
  
  public static final int SourceApplicatorID = 805962385;
  
  public static final int SourceApplicatorType = 805962386;
  
  public static final int SourceApplicatorName = 805962388;
  
  public static final int SourceApplicatorLength = 805962390;
  
  public static final int SourceApplicatorManufacturer = 805962392;
  
  public static final int SourceApplicatorWallNominalThickness = 805962396;
  
  public static final int SourceApplicatorWallNominalTransmission = 805962398;
  
  public static final int SourceApplicatorStepSize = 805962400;
  
  public static final int TransferTubeNumber = 805962402;
  
  public static final int TransferTubeLength = 805962404;
  
  public static final int ChannelShieldSequence = 805962416;
  
  public static final int ChannelShieldNumber = 805962418;
  
  public static final int ChannelShieldID = 805962419;
  
  public static final int ChannelShieldName = 805962420;
  
  public static final int ChannelShieldNominalThickness = 805962424;
  
  public static final int ChannelShieldNominalTransmission = 805962426;
  
  public static final int FinalCumulativeTimeWeight = 805962440;
  
  public static final int BrachyControlPointSequence = 805962448;
  
  public static final int ControlPointRelativePosition = 805962450;
  
  public static final int ControlPoint3DPosition = 805962452;
  
  public static final int CumulativeTimeWeight = 805962454;
  
  public static final int CompensatorDivergence = 805962464;
  
  public static final int CompensatorMountingPosition = 805962465;
  
  public static final int SourceToCompensatorDistance = 805962466;
  
  public static final int TotalCompensatorTrayWaterEquivalentThickness = 805962467;
  
  public static final int IsocenterToCompensatorTrayDistance = 805962468;
  
  public static final int CompensatorColumnOffset = 805962469;
  
  public static final int IsocenterToCompensatorDistances = 805962470;
  
  public static final int CompensatorRelativeStoppingPowerRatio = 805962471;
  
  public static final int CompensatorMillingToolDiameter = 805962472;
  
  public static final int IonRangeCompensatorSequence = 805962474;
  
  public static final int CompensatorDescription = 805962475;
  
  public static final int RadiationMassNumber = 805962498;
  
  public static final int RadiationAtomicNumber = 805962500;
  
  public static final int RadiationChargeState = 805962502;
  
  public static final int ScanMode = 805962504;
  
  public static final int VirtualSourceAxisDistances = 805962506;
  
  public static final int SnoutSequence = 805962508;
  
  public static final int SnoutPosition = 805962509;
  
  public static final int SnoutID = 805962511;
  
  public static final int NumberOfRangeShifters = 805962514;
  
  public static final int RangeShifterSequence = 805962516;
  
  public static final int RangeShifterNumber = 805962518;
  
  public static final int RangeShifterID = 805962520;
  
  public static final int RangeShifterType = 805962528;
  
  public static final int RangeShifterDescription = 805962530;
  
  public static final int NumberOfLateralSpreadingDevices = 805962544;
  
  public static final int LateralSpreadingDeviceSequence = 805962546;
  
  public static final int LateralSpreadingDeviceNumber = 805962548;
  
  public static final int LateralSpreadingDeviceID = 805962550;
  
  public static final int LateralSpreadingDeviceType = 805962552;
  
  public static final int LateralSpreadingDeviceDescription = 805962554;
  
  public static final int LateralSpreadingDeviceWaterEquivalentThickness = 805962556;
  
  public static final int NumberOfRangeModulators = 805962560;
  
  public static final int RangeModulatorSequence = 805962562;
  
  public static final int RangeModulatorNumber = 805962564;
  
  public static final int RangeModulatorID = 805962566;
  
  public static final int RangeModulatorType = 805962568;
  
  public static final int RangeModulatorDescription = 805962570;
  
  public static final int BeamCurrentModulationID = 805962572;
  
  public static final int PatientSupportType = 805962576;
  
  public static final int PatientSupportID = 805962578;
  
  public static final int PatientSupportAccessoryCode = 805962580;
  
  public static final int FixationLightAzimuthalAngle = 805962582;
  
  public static final int FixationLightPolarAngle = 805962584;
  
  public static final int MetersetRate = 805962586;
  
  public static final int RangeShifterSettingsSequence = 805962592;
  
  public static final int RangeShifterSetting = 805962594;
  
  public static final int IsocenterToRangeShifterDistance = 805962596;
  
  public static final int RangeShifterWaterEquivalentThickness = 805962598;
  
  public static final int LateralSpreadingDeviceSettingsSequence = 805962608;
  
  public static final int LateralSpreadingDeviceSetting = 805962610;
  
  public static final int IsocenterToLateralSpreadingDeviceDistance = 805962612;
  
  public static final int RangeModulatorSettingsSequence = 805962624;
  
  public static final int RangeModulatorGatingStartValue = 805962626;
  
  public static final int RangeModulatorGatingStopValue = 805962628;
  
  public static final int RangeModulatorGatingStartWaterEquivalentThickness = 805962630;
  
  public static final int RangeModulatorGatingStopWaterEquivalentThickness = 805962632;
  
  public static final int IsocenterToRangeModulatorDistance = 805962634;
  
  public static final int ScanSpotTuneID = 805962640;
  
  public static final int NumberOfScanSpotPositions = 805962642;
  
  public static final int ScanSpotPositionMap = 805962644;
  
  public static final int ScanSpotMetersetWeights = 805962646;
  
  public static final int ScanningSpotSize = 805962648;
  
  public static final int NumberOfPaintings = 805962650;
  
  public static final int IonToleranceTableSequence = 805962656;
  
  public static final int IonBeamSequence = 805962658;
  
  public static final int IonBeamLimitingDeviceSequence = 805962660;
  
  public static final int IonBlockSequence = 805962662;
  
  public static final int IonControlPointSequence = 805962664;
  
  public static final int IonWedgeSequence = 805962666;
  
  public static final int IonWedgePositionSequence = 805962668;
  
  public static final int ReferencedSetupImageSequence = 805962753;
  
  public static final int SetupImageComment = 805962754;
  
  public static final int MotionSynchronizationSequence = 805962768;
  
  public static final int ControlPointOrientation = 805962770;
  
  public static final int GeneralAccessorySequence = 805962784;
  
  public static final int GeneralAccessoryID = 805962785;
  
  public static final int GeneralAccessoryDescription = 805962786;
  
  public static final int GeneralAccessoryType = 805962787;
  
  public static final int GeneralAccessoryNumber = 805962788;
  
  public static final int SourceToGeneralAccessoryDistance = 805962789;
  
  public static final int ApplicatorGeometrySequence = 805962801;
  
  public static final int ApplicatorApertureShape = 805962802;
  
  public static final int ApplicatorOpening = 805962803;
  
  public static final int ApplicatorOpeningX = 805962804;
  
  public static final int ApplicatorOpeningY = 805962805;
  
  public static final int SourceToApplicatorMountingPositionDistance = 805962806;
  
  public static final int ReferencedRTPlanSequence = 806092802;
  
  public static final int ReferencedBeamSequence = 806092804;
  
  public static final int ReferencedBeamNumber = 806092806;
  
  public static final int ReferencedReferenceImageNumber = 806092807;
  
  public static final int StartCumulativeMetersetWeight = 806092808;
  
  public static final int EndCumulativeMetersetWeight = 806092809;
  
  public static final int ReferencedBrachyApplicationSetupSequence = 806092810;
  
  public static final int ReferencedBrachyApplicationSetupNumber = 806092812;
  
  public static final int ReferencedSourceNumber = 806092814;
  
  public static final int ReferencedFractionGroupSequence = 806092832;
  
  public static final int ReferencedFractionGroupNumber = 806092834;
  
  public static final int ReferencedVerificationImageSequence = 806092864;
  
  public static final int ReferencedReferenceImageSequence = 806092866;
  
  public static final int ReferencedDoseReferenceSequence = 806092880;
  
  public static final int ReferencedDoseReferenceNumber = 806092881;
  
  public static final int BrachyReferencedDoseReferenceSequence = 806092885;
  
  public static final int ReferencedStructureSetSequence = 806092896;
  
  public static final int ReferencedPatientSetupNumber = 806092906;
  
  public static final int ReferencedDoseSequence = 806092928;
  
  public static final int ReferencedToleranceTableNumber = 806092960;
  
  public static final int ReferencedBolusSequence = 806092976;
  
  public static final int ReferencedWedgeNumber = 806092992;
  
  public static final int ReferencedCompensatorNumber = 806093008;
  
  public static final int ReferencedBlockNumber = 806093024;
  
  public static final int ReferencedControlPointIndex = 806093040;
  
  public static final int ReferencedControlPointSequence = 806093042;
  
  public static final int ReferencedStartControlPointIndex = 806093044;
  
  public static final int ReferencedStopControlPointIndex = 806093046;
  
  public static final int ReferencedRangeShifterNumber = 806093056;
  
  public static final int ReferencedLateralSpreadingDeviceNumber = 806093058;
  
  public static final int ReferencedRangeModulatorNumber = 806093060;
  
  public static final int ApprovalStatus = 806223874;
  
  public static final int ReviewDate = 806223876;
  
  public static final int ReviewTime = 806223877;
  
  public static final int ReviewerName = 806223880;
  
  public static final int Arbitrary = 1073741840;
  
  public static final int TextComments = 1073758208;
  
  public static final int ResultsID = 1074266176;
  
  public static final int ResultsIDIssuer = 1074266178;
  
  public static final int ReferencedInterpretationSequence = 1074266192;
  
  public static final int ReportProductionStatusTrial = 1074266367;
  
  public static final int InterpretationRecordedDate = 1074266368;
  
  public static final int InterpretationRecordedTime = 1074266369;
  
  public static final int InterpretationRecorder = 1074266370;
  
  public static final int ReferenceToRecordedSound = 1074266371;
  
  public static final int InterpretationTranscriptionDate = 1074266376;
  
  public static final int InterpretationTranscriptionTime = 1074266377;
  
  public static final int InterpretationTranscriber = 1074266378;
  
  public static final int InterpretationText = 1074266379;
  
  public static final int InterpretationAuthor = 1074266380;
  
  public static final int InterpretationApproverSequence = 1074266385;
  
  public static final int InterpretationApprovalDate = 1074266386;
  
  public static final int InterpretationApprovalTime = 1074266387;
  
  public static final int PhysicianApprovingInterpretation = 1074266388;
  
  public static final int InterpretationDiagnosisDescription = 1074266389;
  
  public static final int InterpretationDiagnosisCodeSequence = 1074266391;
  
  public static final int ResultsDistributionListSequence = 1074266392;
  
  public static final int DistributionName = 1074266393;
  
  public static final int DistributionAddress = 1074266394;
  
  public static final int InterpretationID = 1074266624;
  
  public static final int InterpretationIDIssuer = 1074266626;
  
  public static final int InterpretationTypeID = 1074266640;
  
  public static final int InterpretationStatusID = 1074266642;
  
  public static final int Impressions = 1074266880;
  
  public static final int ResultsComments = 1074282496;
  
  public static final int LowEnergyDetectors = 1074790401;
  
  public static final int HighEnergyDetectors = 1074790402;
  
  public static final int DetectorGeometrySequence = 1074790404;
  
  public static final int ThreatROIVoxelSequence = 1074794497;
  
  public static final int ThreatROIBase = 1074794500;
  
  public static final int ThreatROIExtents = 1074794501;
  
  public static final int ThreatROIBitmap = 1074794502;
  
  public static final int RouteSegmentID = 1074794503;
  
  public static final int GantryType = 1074794504;
  
  public static final int OOIOwnerType = 1074794505;
  
  public static final int RouteSegmentSequence = 1074794506;
  
  public static final int PotentialThreatObjectID = 1074794512;
  
  public static final int ThreatSequence = 1074794513;
  
  public static final int ThreatCategory = 1074794514;
  
  public static final int ThreatCategoryDescription = 1074794515;
  
  public static final int ATDAbilityAssessment = 1074794516;
  
  public static final int ATDAssessmentFlag = 1074794517;
  
  public static final int ATDAssessmentProbability = 1074794518;
  
  public static final int Mass = 1074794519;
  
  public static final int Density = 1074794520;
  
  public static final int ZEffective = 1074794521;
  
  public static final int BoardingPassID = 1074794522;
  
  public static final int CenterOfMass = 1074794523;
  
  public static final int CenterOfPTO = 1074794524;
  
  public static final int BoundingPolygon = 1074794525;
  
  public static final int RouteSegmentStartLocationID = 1074794526;
  
  public static final int RouteSegmentEndLocationID = 1074794527;
  
  public static final int RouteSegmentLocationIDType = 1074794528;
  
  public static final int AbortReason = 1074794529;
  
  public static final int VolumeOfPTO = 1074794531;
  
  public static final int AbortFlag = 1074794532;
  
  public static final int RouteSegmentStartTime = 1074794533;
  
  public static final int RouteSegmentEndTime = 1074794534;
  
  public static final int TDRType = 1074794535;
  
  public static final int InternationalRouteSegment = 1074794536;
  
  public static final int ThreatDetectionAlgorithmandVersion = 1074794537;
  
  public static final int AssignedLocation = 1074794538;
  
  public static final int AlarmDecisionTime = 1074794539;
  
  public static final int AlarmDecision = 1074794545;
  
  public static final int NumberOfTotalObjects = 1074794547;
  
  public static final int NumberOfAlarmObjects = 1074794548;
  
  public static final int PTORepresentationSequence = 1074794551;
  
  public static final int ATDAssessmentSequence = 1074794552;
  
  public static final int TIPType = 1074794553;
  
  public static final int DICOSVersion = 1074794554;
  
  public static final int OOIOwnerCreationTime = 1074794561;
  
  public static final int OOIType = 1074794562;
  
  public static final int OOISize = 1074794563;
  
  public static final int AcquisitionStatus = 1074794564;
  
  public static final int BasisMaterialsCodeSequence = 1074794565;
  
  public static final int PhantomType = 1074794566;
  
  public static final int OOIOwnerSequence = 1074794567;
  
  public static final int ScanType = 1074794568;
  
  public static final int ItineraryID = 1074794577;
  
  public static final int ItineraryIDType = 1074794578;
  
  public static final int ItineraryIDAssigningAuthority = 1074794579;
  
  public static final int RouteID = 1074794580;
  
  public static final int RouteIDAssigningAuthority = 1074794581;
  
  public static final int InboundArrivalType = 1074794582;
  
  public static final int CarrierID = 1074794584;
  
  public static final int CarrierIDAssigningAuthority = 1074794585;
  
  public static final int SourceOrientation = 1074794592;
  
  public static final int SourcePosition = 1074794593;
  
  public static final int BeltHeight = 1074794594;
  
  public static final int AlgorithmRoutingCodeSequence = 1074794596;
  
  public static final int TransportClassification = 1074794599;
  
  public static final int OOITypeDescriptor = 1074794600;
  
  public static final int TotalProcessingTime = 1074794601;
  
  public static final int DetectorCalibrationData = 1074794604;
  
  public static final int AdditionalScreeningPerformed = 1074794605;
  
  public static final int AdditionalInspectionSelectionCriteria = 1074794606;
  
  public static final int AdditionalInspectionMethodSequence = 1074794607;
  
  public static final int AITDeviceType = 1074794608;
  
  public static final int QRMeasurementsSequence = 1074794609;
  
  public static final int TargetMaterialSequence = 1074794610;
  
  public static final int SNRThreshold = 1074794611;
  
  public static final int ImageScaleRepresentation = 1074794613;
  
  public static final int ReferencedPTOSequence = 1074794614;
  
  public static final int ReferencedTDRInstanceSequence = 1074794615;
  
  public static final int PTOLocationDescription = 1074794616;
  
  public static final int AnomalyLocatorIndicatorSequence = 1074794617;
  
  public static final int AnomalyLocatorIndicator = 1074794618;
  
  public static final int PTORegionSequence = 1074794619;
  
  public static final int InspectionSelectionCriteria = 1074794620;
  
  public static final int SecondaryInspectionMethodSequence = 1074794621;
  
  public static final int PRCSToRCSOrientation = 1074794622;
  
  public static final int MACParametersSequence = 1342046209;
  
  public static final int CurveDimensions = 1342177285;
  
  public static final int NumberOfPoints = 1342177296;
  
  public static final int TypeOfData = 1342177312;
  
  public static final int CurveDescription = 1342177314;
  
  public static final int AxisUnits = 1342177328;
  
  public static final int AxisLabels = 1342177344;
  
  public static final int DataValueRepresentation = 1342177539;
  
  public static final int MinimumCoordinateValue = 1342177540;
  
  public static final int MaximumCoordinateValue = 1342177541;
  
  public static final int CurveRange = 1342177542;
  
  public static final int CurveDataDescriptor = 1342177552;
  
  public static final int CoordinateStartValue = 1342177554;
  
  public static final int CoordinateStepValue = 1342177556;
  
  public static final int CurveActivationLayer = 1342181377;
  
  public static final int AudioType = 1342185472;
  
  public static final int AudioSampleFormat = 1342185474;
  
  public static final int NumberOfChannels = 1342185476;
  
  public static final int NumberOfSamples = 1342185478;
  
  public static final int SampleRate = 1342185480;
  
  public static final int TotalTime = 1342185482;
  
  public static final int AudioSampleData = 1342185484;
  
  public static final int AudioComments = 1342185486;
  
  public static final int CurveLabel = 1342186752;
  
  public static final int CurveReferencedOverlaySequence = 1342187008;
  
  public static final int CurveReferencedOverlayGroup = 1342187024;
  
  public static final int CurveData = 1342189568;
  
  public static final int SharedFunctionalGroupsSequence = 1375769129;
  
  public static final int PerFrameFunctionalGroupsSequence = 1375769136;
  
  public static final int WaveformSequence = 1409286400;
  
  public static final int ChannelMinimumValue = 1409286416;
  
  public static final int ChannelMaximumValue = 1409286418;
  
  public static final int WaveformBitsAllocated = 1409290244;
  
  public static final int WaveformSampleInterpretation = 1409290246;
  
  public static final int WaveformPaddingValue = 1409290250;
  
  public static final int WaveformData = 1409290256;
  
  public static final int FirstOrderPhaseCorrectionAngle = 1442840592;
  
  public static final int SpectroscopyData = 1442840608;
  
  public static final int OverlayRows = 1610612752;
  
  public static final int OverlayColumns = 1610612753;
  
  public static final int OverlayPlanes = 1610612754;
  
  public static final int NumberOfFramesInOverlay = 1610612757;
  
  public static final int OverlayDescription = 1610612770;
  
  public static final int OverlayType = 1610612800;
  
  public static final int OverlaySubtype = 1610612805;
  
  public static final int OverlayOrigin = 1610612816;
  
  public static final int ImageFrameOrigin = 1610612817;
  
  public static final int OverlayPlaneOrigin = 1610612818;
  
  public static final int OverlayCompressionCode = 1610612832;
  
  public static final int OverlayCompressionOriginator = 1610612833;
  
  public static final int OverlayCompressionLabel = 1610612834;
  
  public static final int OverlayCompressionDescription = 1610612835;
  
  public static final int OverlayCompressionStepPointers = 1610612838;
  
  public static final int OverlayRepeatInterval = 1610612840;
  
  public static final int OverlayBitsGrouped = 1610612841;
  
  public static final int OverlayBitsAllocated = 1610612992;
  
  public static final int OverlayBitPosition = 1610612994;
  
  public static final int OverlayFormat = 1610613008;
  
  public static final int OverlayLocation = 1610613248;
  
  public static final int OverlayCodeLabel = 1610614784;
  
  public static final int OverlayNumberOfTables = 1610614786;
  
  public static final int OverlayCodeTableLocation = 1610614787;
  
  public static final int OverlayBitsForCodeWord = 1610614788;
  
  public static final int OverlayActivationLayer = 1610616833;
  
  public static final int OverlayDescriptorGray = 1610617088;
  
  public static final int OverlayDescriptorRed = 1610617089;
  
  public static final int OverlayDescriptorGreen = 1610617090;
  
  public static final int OverlayDescriptorBlue = 1610617091;
  
  public static final int OverlaysGray = 1610617344;
  
  public static final int OverlaysRed = 1610617345;
  
  public static final int OverlaysGreen = 1610617346;
  
  public static final int OverlaysBlue = 1610617347;
  
  public static final int ROIArea = 1610617601;
  
  public static final int ROIMean = 1610617602;
  
  public static final int ROIStandardDeviation = 1610617603;
  
  public static final int OverlayLabel = 1610618112;
  
  public static final int OverlayData = 1610625024;
  
  public static final int OverlayComments = 1610629120;
  
  public static final int FloatPixelData = 2145386504;
  
  public static final int DoubleFloatPixelData = 2145386505;
  
  public static final int PixelData = 2145386512;
  
  public static final int CoefficientsSDVN = 2145386528;
  
  public static final int CoefficientsSDHN = 2145386544;
  
  public static final int CoefficientsSDDN = 2145386560;
  
  public static final int VariablePixelData = 2130706448;
  
  public static final int VariableNextDataGroup = 2130706449;
  
  public static final int VariableCoefficientsSDVN = 2130706464;
  
  public static final int VariableCoefficientsSDHN = 2130706480;
  
  public static final int VariableCoefficientsSDDN = 2130706496;
  
  public static final int DigitalSignaturesSequence = -327686;
  
  public static final int DataSetTrailingPadding = -196612;
  
  public static final int Item = -73728;
  
  public static final int ItemDelimitationItem = -73715;
  
  public static final int SequenceDelimitationItem = -73507;
  
  public static final int ReferencedBulkDataSequence = -458760;
  
  public static final long InstanceCreationDateAndTime = 2251877123620883L;
  
  public static final long StudyDateAndTime = 2251937253163056L;
  
  public static final long SeriesDateAndTime = 2251941548130353L;
  
  public static final long AcquisitionDateAndTime = 2251945843097650L;
  
  public static final long ContentDateAndTime = 2251950138064947L;
  
  public static final long OverlayDateAndTime = 2251954433032244L;
  
  public static final long CurveDateAndTime = 2251958727999541L;
  
  public static final long PatientBirthDateAndTime = 4503805786849330L;
  
  public static final long DateAndTimeOfSecondaryCapture = 6773068938088468L;
  
  public static final long DateAndTimeOfLastCalibration = 6775190651933185L;
  
  public static final long DateAndTimeOfLastDetectorCalibration = 6878596284575758L;
  
  public static final long ModifiedImageDateAndTime = 9064386746397701L;
  
  public static final long StudyVerifiedDateAndTime = 14073963587174451L;
  
  public static final long StudyReadDateAndTime = 14073972177109045L;
  
  public static final long ScheduledStudyStartDateAndTime = 14091341024858113L;
  
  public static final long ScheduledStudyStopDateAndTime = 14091409744334865L;
  
  public static final long StudyArrivalDateAndTime = 14091615902765121L;
  
  public static final long StudyCompletionDateAndTime = 14091684622241873L;
  
  public static final long ScheduledAdmissionDateAndTime = 15762710368616475L;
  
  public static final long ScheduledDischargeDateAndTime = 15762718958551069L;
  
  public static final long AdmittingDateAndTime = 15762736138420257L;
  
  public static final long DischargeDateAndTime = 15762804857897010L;
  
  public static final long ScheduledProcedureStepStartDateAndTime = 18014407103610883L;
  
  public static final long ScheduledProcedureStepEndDateAndTime = 18014415693545477L;
  
  public static final long PerformedProcedureStepStartDateAndTime = 18016889594708549L;
  
  public static final long PerformedProcedureStepEndDateAndTime = 18016941134316113L;
  
  public static final long IssueDateAndTimeOfImagingServiceRequest = 18049600065642501L;
  
  public static final long DateAndTime = 18191561619710242L;
  
  public static final long PresentationCreationDateAndTime = 31525755744682115L;
  
  public static final long CreationDateAndTime = 2377900878683177040L;
  
  public static final long StructureSetDateAndTime = 3460453398846242825L;
  
  public static final long TreatmentControlPointDateAndTime = 3461016469058879525L;
  
  public static final long SafePositionExitDateAndTime = 3461017834858479972L;
  
  public static final long SafePositionReturnDateAndTime = 3461017852038349160L;
  
  public static final long TreatmentDateAndTime = 3461018857060696657L;
  
  public static final long RTPlanDateAndTime = 3461579290163412999L;
  
  public static final long SourceStrengthReferenceDateAndTime = 3461581652395426350L;
  
  public static final long ReviewDateAndTime = 3462705181480583173L;
  
  public static final long InterpretationRecordedDateAndTime = 4613938918826967297L;
  
  public static final long InterpretationTranscriptionDateAndTime = 4613938953186705673L;
  
  public static final long InterpretationApprovalDateAndTime = 4613938996136378643L;
}


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */