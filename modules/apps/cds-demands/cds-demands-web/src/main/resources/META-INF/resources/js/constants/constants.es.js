const constants = {
    services:{
        attachments:{
            deleteattachment:'/cdsdemand.cdsdemand/delete-attachment',
            getattachments:'/cdsdemand.cdsdemand/get-attachments',
        },
        bioe:{
            getclouds:'/cdsdemand.bioelocal/get-clouds',
        },
        demands:{
            userdemands:'/cdsdemand.cdsdemand/find-user-demands',
            requiringuseraction:'/cdsdemand.cdsdemand/find-user-action-required-demands',
            domaindemands: '/cdsdemand.cdsdemand/find-domain-demands',
            getrequestorinfo:  '/cdsdemand.bioelocal/get-requestor-info'

        },
        gdprinfo:{
            get:'/cdsdemand.cdsdemandgdprinfo/get-entries-by-demand-id',
            update:'/cdsdemand.cdsdemandgdprinfo/update-entry',
            delete:'/cdsdemand.cdsdemandgdprinfo/delete-entry',
        },
        deleteentry:'/cdsdemand.cdsdemand/delete-entry',
        workflowaction:'/cdsdemand.cdsdemand/perform-transition',
        getcomments:'/comment.commentmanagerjsonws/get-comments',
        getcstcategoryoptions: '/cdsdemand.cst/get-gdpr-category-options',
        getcstreasoningoptions: '/cdsdemand.cst/get-gdpr-reasoning-options',
        getextendedcdsdemand:'/cdsdemand.cdsdemand/get-extended-cds-demand',
    },
    navigation:{
        cdsdashboard: '/dashboard/cds/',
        editdemand:'/demand/edit/',
        domaindashboard:'/dashboard/domain/',
        home:'/',
        newdemand:'/demand/new/',
        userdashboard:'/dashboard/user/',
        viewdemand:'/demand/view/',

    },
    states:{
        AKCEPTACE : 'state_akceptace',
        AKCEPTOVANO : 'state_akceptovano',
        MIMO_BICDS : 'state_mimo_cds',
        NACENENO : 'state_naceneno',
        NACENOVANO : 'state_nacenovano',
        NAVRH : 'state_navrh',
        POZASTAVENO_BAN : 'state_pozastaveno_ban',
        POZASTAVENO_SPOC : 'state_pozastaveno_spoc',
        REALIZACE : 'state_realizace',
        REVIZE_BAN : 'state_revize_ban',
        REVIZE_DODAVKY : 'state_revize_dodavky',
        REVIZE_SPOC : 'state_revize_spoc',
        ZRUSENO : 'state_zruseno',
    },
    sidebar:{
        attachments:"attachments",
        comments:"comments",
    }
}

export default constants;