# Liferay JSON Web Services

## JSON RPC

```text
/jsonws/calendar-portlet/calendar/get-calendar/calendar-id/10466
```

## Simple JavaScript API

```javascript
Liferay.Service('/calendar-portlet/calendar/get-calendar', { calendarId: 10466 });
```

## Service Access Policies
[https://help.liferay.com/hc/en-us/articles/360017896072-Service-Access-Policies]()

# Liferay JSON Web Services Object Composition

## A simple Invoker call (recommended)

### Basic request

```javascript
Liferay.Service({
	'/calendar-portlet/calendar/get-calendar': {
		calendarId: 10466
	}
});
```

### Nested requests

```javascript
Liferay.Service({
	'$calendar = /calendar-portlet/calendar/get-calendar': {
		calendarId: 10466,

		'$bookings = /calendar-portlet/calendarbooking/get-calendar-bookings': {
			'@calendarId': '$calendar.calendarId',
			startDate: -1,
			endDate: -1
		}
	}
});
```

### Filtering keys

```javascript
Liferay.Service({
	'$calendar[calendarId, nameCurrentValue] = /calendar-portlet/calendar/get-calendar': {
		calendarId: 10466,

		'$bookings[titleCurrentValue] = /calendar-portlet/calendarbooking/get-calendar-bookings': {
			'@calendarId': '$calendar.calendarId',
			startDate: -1,
			endDate: -1
		}
	}
});
```

For more information, check [http://www.liferay.com/documentation/liferay-portal/6.1/development/-/ai/json-web-services](http://www.liferay.com/documentation/liferay-portal/6.1/development/-/ai/json-web-services).


Source:
[https://gist.github.com/eduardolundgren/4260723]()