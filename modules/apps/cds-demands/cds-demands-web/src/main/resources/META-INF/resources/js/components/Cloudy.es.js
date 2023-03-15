import {Box, Card, CardContent, CardHeader, Divider, Typography} from '@material-ui/core';
import React, {useEffect, useMemo, useState} from 'react';
import {
    Bar,
    BarChart,
    CartesianGrid,
    Cell,
    Legend,
    Pie,
    PieChart,
    ResponsiveContainer,
    Tooltip,
    XAxis,
    YAxis
} from 'recharts';
import constants from "../constants/constants.es";
import {lang} from "../constants/lang.es";
import {ErrorBoundary} from "./ErrorBoundary.es";
import {Sheet, SheetSection} from "./Components";


const loadData = (domainId = [], callback = () => {
}) => {
    if (typeof domainId !== 'object') {
        domainId = [domainId];
    }

    Liferay.Service(
        constants.services.bioe.getclouds,
        {
            domainId: domainId
        },
        function ({success, error, message, data}) {
            if (success === true) {
                callback(data);
            } else {
                console.error(message);
            }
        }
    );
}

const colors = {
    reserved: '#00bb1e',
    plac: '#0d15a1',
    plwa: '#204bff',
    vydo: '#fa5418',
    vyac: '#ff9900',
    avok: '#9a9a9a',
    avbad: '#ff0000',
}

export const SingleDomain = ({domain = -1, height = 300, ...props}) => {
    const [data, setData] = useState([]);

    useEffect(() => {
        loadData([], (data) => {
            setData(data);
        })
    }, [])

    const filteredData = useMemo(
        () => {
            let x = data.filter(rec => domain === (Number(rec?.utvar_b0))).shift();
            if (!x) return [];
            let available = Number(x?.prislibene) - Number(x?.planovano);
            return [
                {
                    name: lang.cloudy.prislibene,
                    value: x?.prislibene ?? 0,
                    color: colors.reserved
                },
                {
                    name: lang.cloudy.planovano,
                    value: x?.planovano ?? 0,
                    color: colors.plac
                },
                {
                    name: lang.cloudy.planwaiting,
                    value: x?.planwaiting ?? 0,
                    color: colors.plwa
                },
                {
                    name: lang.cloudy.vykazanoclosed,
                    value: x?.vykazanoclosed ?? 0,
                    color: colors.vydo
                },
                {
                    name: lang.cloudy.vykazanoworking,
                    value: x?.vykazanoworking ?? 0,
                    color: colors.vyac
                }, {
                    name: lang.cloudy.available,
                    value: available,
                    color: available > 0 ? colors.avok : colors.avbad
                }
            ];
        }
        , [data, domain])

    const {pieData1, pieData2, pieData3} = useMemo(
        () => {
            let x = data.filter(rec => domain === (Number(rec?.utvar_b0))).shift();
            if (!x) return {pieData1: [], pieData2: [], pieData3: []};
            let available = (Number(x?.prislibene) + Number(x?.planwaiting)) - Number(x?.planovano);
            return {
                pieData1:
                    [{
                        pie: 1,
                        name: lang.cloudy.prislibene,
                        value: x?.prislibene ?? 0,
                        color: colors.reserved

                    }, {
                        pie: 1,
                        name: lang.cloudy.available,
                        value: available > 0 ? 0 : -available,
                        color: colors.avbad
                    }],
                pieData2: [{
                    pie: 2,
                    name: lang.cloudy.planovano,
                    value: x?.planovano ?? 0,
                    color: colors.plac
                }, {
                    pie: 2,
                    name: lang.cloudy.planwaiting,
                    value: x?.planwaiting ?? 0,
                    color: colors.plwa
                }, {
                    pie: 2,
                    name: lang.cloudy.available,
                    value: available > 0 ? available : 0,
                    color: colors.avok
                }],
                pieData3: [{
                    pie: 3,
                    name: lang.cloudy.vykazanoclosed,
                    value: x?.vykazanoclosed ?? 0,
                    color: colors.vydo
                }, {
                    pie: 3,
                    name: lang.cloudy.vykazanoworking,
                    value: x?.vykazanoworking ?? 0,
                    color: colors.vyac
                }, {
                    pie: 3,
                    name: lang.cloudy.available,
                    value: (available + Number(x?.planwaiting)) > 0 ? (available + Number(x?.planwaiting)) : 0,
                    color: colors.avok
                }
                ]
            };
        }
        , [data, domain])


    return (
        <ErrorBoundary>
            <Sheet>
                <SheetSection title={lang.cloudy.mdsOverview}>
                    <Box
                        sx={{
                            height: height,
                            position: 'relative'
                        }}
                    >

                        <ResponsiveContainer>
                            <PieChart height={height}>
                                <Pie
                                    data={pieData3}
                                    dataKey="value"
                                    fill="#8884d8"
                                    innerRadius={'76%'}
                                    outerRadius={'95%'}
                                    paddingAngle={0}
                                >
                                    {pieData3.map((entry, index) => {
                                            return (
                                                <Cell key={`cell-${index}`} fill={entry.color}/>
                                            )
                                        }
                                    )}
                                </Pie>
                                <Pie
                                    data={pieData2}
                                    dataKey="value"
                                    fill="#8884d8"
                                    innerRadius={'56%'}
                                    outerRadius={'75%'}
                                    paddingAngle={0}
                                >
                                    {pieData2.map((entry, index) => (
                                        <Cell key={`cell-${index}`} fill={entry.color}/>
                                    ))}
                                </Pie>
                                <Pie
                                    data={pieData1}
                                    dataKey="value"
                                    fill="#8884d8"
                                    innerRadius={'36%'}
                                    outerRadius={'55%'}
                                    paddingAngle={0}
                                >
                                    {pieData1.map((entry, index) => (
                                        <Cell key={`cell-${index}`} fill={entry.color}/>
                                    ))}
                                </Pie>
                            </PieChart>
                        </ResponsiveContainer>
                    </Box>
                    <Box
                        sx={{
                            display: 'flex',
                            justifyContent: 'center',
                            pt: 2,
                            flexWrap: 'wrap'
                        }}
                    >
                        {filteredData.map(({color, name, value}) => (
                            <Box
                                key={name}
                                sx={{p: 1, textAlign: 'center'}}
                            >
                                <Typography
                                    color="textPrimary"
                                    variant="body1"
                                >
                                    {name}
                                </Typography>
                                <Typography
                                    style={{color}}
                                    variant="h4"
                                >
                                    {value}
                                </Typography>
                            </Box>
                        ))}
                    </Box>
                </SheetSection>
            </Sheet>
        </ErrorBoundary>
    )
}

export const MultiDomain = (
    {
        domains = [], height = 300, setDomainsCallback = () => {
    }, ...props
    }) => {

    const [data, setData] = useState([]);

    useEffect(() => {
        loadData([], (data) => {
            setData(data);
            setDomainsCallback(data.map(rec => {
                return {label: rec?.utvar_b0_desc, value: rec?.utvar_b0}
            }))
        })
    }, [])

    const filteredData = useMemo(
        () => data.filter(
            rec => domains.length === 0 || domains.includes(rec?.utvar_b0) || rec?.utvar_b0 === 0)
        , [data, domains])

    return (
        <ErrorBoundary>
            <Sheet>
                <SheetSection title={lang.cloudy.mdsOverview}>
                    <Box
                        sx={{
                            height: height,
                            position: 'relative'
                        }}
                    >

                        <ResponsiveContainer width="100%" height="100%">
                            <BarChart
                                width={500}
                                height={height}
                                data={filteredData}
                                margin={{
                                    top: 10,
                                    right: 20,
                                    left: 10,
                                    bottom: 5,
                                }}
                            >
                                <CartesianGrid strokeDasharray="3 3"/>
                                <XAxis dataKey="utvar_b0_desc"/>
                                <YAxis/>
                                <Tooltip/>
                                <Legend />
                                <Bar dataKey="prislibene"
                                     name={lang.cloudy.prislibene}
                                     stackId="a"
                                     fill={colors.reserved}/>
                                <Bar dataKey="planovano"
                                     name={lang.cloudy.planovano}
                                     stackId="b"
                                     fill={colors.plac}/>
                                <Bar dataKey="planwaiting"
                                     name={lang.cloudy.planwaiting}
                                     stackId="b"
                                     fill={colors.plwa}/>
                                <Bar dataKey="vykazanoclosed"
                                     name={lang.cloudy.vykazanoclosed}
                                     stackId="c"
                                     fill={colors.vydo}/>
                                <Bar dataKey="vykazanoworking"
                                     name={lang.cloudy.vykazanoworking}
                                     stackId="c"
                                     fill={colors.vyac}/>
                            </BarChart>
                        </ResponsiveContainer>
                    </Box>
                </SheetSection>
            </Sheet>
        </ErrorBoundary>
    )
}