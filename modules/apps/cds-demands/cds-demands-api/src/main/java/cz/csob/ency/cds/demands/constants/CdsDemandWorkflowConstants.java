package cz.csob.ency.cds.demands.constants;

/**
 * @author Miroslav Čermák
 */
public class CdsDemandWorkflowConstants {
    public static final String STATE_AKCEPTACE = "state_akceptace";
    public static final String STATE_AKCEPTOVANO = "state_akceptovano";
    public static final String STATE_MIMO_BICDS = "state_mimo_cds";
    public static final String STATE_NACENENO = "state_naceneno";
    public static final String STATE_NACENOVANO = "state_nacenovano";
    public static final String STATE_NAVRH = "state_navrh";
    public static final String STATE_POZASTAVENO_BAN = "state_pozastaveno_ban";
    public static final String STATE_POZASTAVENO_SPOC = "state_pozastaveno_spoc";
    public static final String STATE_REALIZACE = "state_realizace";
    public static final String STATE_REVIZE_BAN = "state_revize_ban";
    public static final String STATE_REVIZE_DODAVKY = "state_revize_dodavky";
    public static final String STATE_REVIZE_SPOC = "state_revize_spoc";
    public static final String STATE_ZRUSENO = "state_zruseno";


    //Mimo cds
    public static final String TRANSITION_VRATIT_CDS = "transition-vratit_cds";

    //Navrh
    public static final String TRANSITION_NAVRH_KE_SCHVALENI = "transition-navrh-ke_schvaleni";
    public static final String TRANSITION_NAVRH_ZRUSIT = "transition-navrh-zrusit";

    //Revize SPOC (ex.novy)
    public static final String TRANSITION_REVIZE_SPOC_MIMO_CDS = "transition-revize_spoc-mimo_cds";
    public static final String TRANSITION_REVIZE_SPOC_POZASTAVIT = "transition-revize_spoc-pozastavit";
    public static final String TRANSITION_REVIZE_SPOC_SCHVALIT = "transition-revize_spoc-novy_schvalit";
    public static final String TRANSITION_REVIZE_SPOC_VRATIT = "transition-revize_spoc-novy_vratit";
    public static final String TRANSITION_REVIZE_SPOC_ZRUSIT = "transition-revize_spoc-zrusit";
    
    //Pozastaveno SPOCem
    public static final String TRANSITION_POZASTAVENO_SPOC_OBNOVIT = "transition-pozastaveno_spoc-obnovit";

    //Revize BAN
    public static final String TRANSITION_REVIZE_BAN_MIMO_CDS = "transition-revize_ban-mimo_cds";
    public static final String TRANSITION_REVIZE_BAN_POZASTAVIT = "transition-revize_ban-pozastavit";
    public static final String TRANSITION_REVIZE_BAN_SCHVALIT = "transition-revize_ban-schvalit";
    public static final String TRANSITION_REVIZE_BAN_SCHVALITUS = "transition-revize_ban-schvalit_us";
    public static final String TRANSITION_REVIZE_BAN_VRATIT = "transition-revize_ban-vratiti";   
    public static final String TRANSITION_REVIZE_BAN_ZAMITNOUT = "transition-revize_ban-zamitnout";

    //Pozastaveno BANem
    public static final String TRANSITION_POZASTAVENO_BAN_OBNOVIT = "transition-pozastaveno_ban-obnovit";

    //Nacenovano
    public static final String TRANSITION_NACENOVANO_ADM_DO_REVIZE = "transition-nacenovano-adm_do+revize";
    public static final String TRANSITION_NACENOVANO_NACENENO = "transition-nacenovano-naceneno";
    public static final String TRANSITION_NACENOVANO_NACENENO_US = "transition-nacenovano-naceneno_us";
    public static final String TRANSITION_NACENOVANO_SYNC_ZRUSENO ="transition-nacenovano-sync_zruseno" ;

    //Naceneno
    public static final String TRANSITION_NACENENO_SCHVALIT = "transition-naceneno-schvalit";
    public static final String TRANSITION_NACENENO_ODMITNOUT = "transition-naceneno-odmitnout";
    public static final String TRANSITION_NACENENO_SYNC_ZRUSENO = "transition-naceneno-sync_zruseno";

    //Realizace
    public static final String TRANSITION_REALIZACE_DO_AKCEPTACE = "transition-realizace-do_akceptace";
    public static final String TRANSITION_REALIZACE_SYNC_DO_AKCEPTACE = "transition-realizace-sync_do_akceptace";
    public static final String TRANSITION_REALIZACE_SYNC_ZRUSENO = "transition-realizace-sync_zruseno";

    //Akceptace
    public static final String TRANSITION_AKCEPTACE_SCHVALIT = "transition-akceptace-schvalit";
    public static final String TRANSITION_AKCEPTACE_ODMITNOUT = "transition-akceptace-odmitnout";
    public static final String TRANSITION_AKCEPTACE_SYNC_ZRUSENO = "transition-akceptace-sync_zruseno";

    //Revize dodavky
    public static final String TRANSITION_REVIZE_DODAVKY_DO_AKCEPTACE = "transition-revize_dodavky-do_akceptace";
    public static final String TRANSITION_REVIZE_DODAVKY_DO_REALIZACE = "transition-revize_dodavky-do_realizace";

    //ADMIN TMP
    public static final String TRANSITION_REALIZACE_TMP_DO_REVIZE_BAN = "transition-realizace-do_revize_ban";


    public static final String WORKFLOW_CLASS_NAME =
            "cz.csob.ency.cds.demands.workflow.CdsDemandWorkflow";
}
