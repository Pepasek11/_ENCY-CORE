import ClayMultiStepNav from '@clayui/multi-step-nav';
import React, {useState} from "react";
import constants from "../constants/constants.es";

const WFStepNav = (
    {
        entry=null
    }
) => {
    if(!entry) return null;

    const [value, setValue] = useState(1);

    const steps = {
        [constants.states.NAVRH]:{
            applicable: true,
            id: 0,
            title: Liferay.Language.get('state_navrh')
        },
        [constants.states.REVIZE_SPOC]:{
            id: 1,
            applicable: entry?.state !== constants.states.ZRUSENO,
            title: Liferay.Language.get('state_revize_spoc')
        },
        [constants.states.POZASTAVENO_SPOC]:{
            id: 2,
            applicable: entry?.state === constants.states.POZASTAVENO_SPOC,
            expand:false,
            title: Liferay.Language.get('state_pozastaveno_spoc')
        },
        [constants.states.REVIZE_BAN]:{
            id: 3,
            applicable: (
                entry?.state !== constants.states.ZRUSENO
                && entry?.state !== constants.states.MIMO_BICDS
            ),
            title: Liferay.Language.get('state_revize_ban')
        },
        [constants.states.POZASTAVENO_BAN]:{
            id: 4,
            applicable: entry?.state === constants.states.POZASTAVENO_BAN,
            expand:false,
            title: Liferay.Language.get('state_pozastaveno_ban')
        },
        [constants.states.NACENOVANO]:{
            id: 5,
            applicable: (
                entry?.state !== constants.states.ZRUSENO
                && entry?.state !== constants.states.MIMO_BICDS
            ),
            title: Liferay.Language.get('state_nacenovano')
        },
        [constants.states.NACENENO]:{
            id: 6,
            applicable:
                entry?.state !== constants.states.ZRUSENO
                && entry?.state !== constants.states.MIMO_BICDS
                && Number(entry?.type) === 2,
            title: Liferay.Language.get('state_naceneno')
        },
        [constants.states.REALIZACE]:{
            id: 7,
            applicable:
                entry?.state !== constants.states.ZRUSENO
                && entry?.state !== constants.states.MIMO_BICDS
            ,
            title: Liferay.Language.get('state_realizace')
        },
        [constants.states.REVIZE_DODAVKY]:{
            id: 8,
            active: value === 8,
            applicable: entry?.state === constants.states.REVIZE_DODAVKY,
            complete: value > 8,
            title: Liferay.Language.get('state_revize_dodavky')
        },
        [constants.states.AKCEPTACE]:{
            id: 9,
            active: value === 9,
            applicable:
                entry?.state !== constants.states.ZRUSENO
                && entry?.state !== constants.states.MIMO_BICDS,
            complete: value > 9,
            title: Liferay.Language.get('state_akceptace')
        },
        [constants.states.AKCEPTOVANO]:{
            id: 10,
            active: value === 10,
            applicable: (
                entry?.state !== constants.states.ZRUSENO
                && entry?.state !== constants.states.MIMO_BICDS
            ),
            complete: value > 10,
            expand:false,
            title: Liferay.Language.get('state_akceptovano')
        },
        [constants.states.MIMO_BICDS]:{
            id: 11,
            active: value === 11,
            applicable: entry?.state === constants.states.MIMO_BICDS,
            complete: value > 11,
            expand:false,
            title: Liferay.Language.get('state_mimo_cds')
        },
        [constants.states.ZRUSENO]:{
            id: 12,
            active: value === 12,
            applicable: entry?.state === constants.states.ZRUSENO,
            complete: value > 12,
            expand:false,
            title: Liferay.Language.get('state_zruseno')
        }
};

    return (
        <ClayMultiStepNav>
            {Object.values(steps)
                .filter(step=>step.applicable)
                .map(({id, active, complete, expand=true,title}, i) => (
                <ClayMultiStepNav.Item
                    active={id===steps[entry?.state]?.id}
                    complete={id<steps[entry?.state]?.id}
                    expand={expand}
                    key={i}
                >
                    {/*}  <ClayMultiStepNav.Title>{title}</ClayMultiStepNav.Title>*/}
                    <ClayMultiStepNav.Divider/>
                    <ClayMultiStepNav.Indicator
                        complete={id<steps[entry?.state]?.id}
                        label={1 + i}
                        subTitle={title}
                    />
                </ClayMultiStepNav.Item>
            ))}
        </ClayMultiStepNav>
    );
};

export default WFStepNav;