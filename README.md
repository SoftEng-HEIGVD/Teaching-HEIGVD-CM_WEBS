### Links to repos

- [iFlux Blog](http://www.iflux.io/blog.html)
- [Doc Skeleton](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-CM_WEBS-2015-Labo-Doc)
- [Java Spring Boot Skeleton](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-CM_WEBS-2015-Labo-SpringBoot)
- [Express Skeleton](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-CM_WEBS-2015-Labo-Express)

### Heroku Setup

1. Create your account on [Heroku](https://signup.heroku.com/www-header)
2. Follow the instruction to [setup](https://devcenter.heroku.com/articles/getting-started-with-nodejs#set-up) your computer. Only the instruction to install the required tools.
3. Go to your project directory: `cd <app directory>`
4. Run the following command: `heroku create`
5. To deploy the app, run this command: `git push heroku master` or follow the specific instructions present in the app README.md.

### Express - Mongoose example

```javascript
var
  mongoose = require('mongoose'),
  Schema = mongoose.Schema;

// Issue type definition
var IssueType = new Schema({
  name: String,
  description: String
});

mongoose.model('IssueType', IssueType);

// Issue definition
var Issue = new Schema({
  description: String,
	// Default value on object creation
	updatedOn: { type: Date, default: Date.now },
	// ...
	issueType: { type: Schema.Types.ObjectId, ref: 'IssueType' }
});

// Hook applied before object saved to enrich the object data
Issue.pre('save', function(next) {
	this.updatedOn = new Date();
	next();
});

mongoose.model('Issue', Issue);

Issue.find()
	.populate('issueType')
	.exec(function(err, issues) {
		// Do something with the issues
	});

IssueType.findById("id", function(err, issueType) {
	var issue = new Issue({
		issueType: issueType
	});
})

var issue = new Issue({
	issueType: "id"
});
```

### Express - Routing example

```javascript
function authenticate(req, res, next) {
	// Try to retrieve the userId from HTTP headers
	var userId = req.headers['x-user-id'];

	if (userId != undefined) {
		// Try to retrieve the corresponding user
		User.findById(userId, function (err, user) {
			if (err || user === null) {
				res.status(401).end();
			}

			// If user has at least one role, then he is authorized to access the API
			else if (user.roles.length > 0) {
				req.user = user;
				// Continue the invocation chain
				next();
			}
			else {
				res.status(403).end();
			}
		});
	}
	else {
		res.status(401).end();
	}
},


module.exports = function (app) {
  app.use('/api/users', router);
};

// First possibility
router.route('/')
	.get(authenticate)
	.get(function(req, res, next) {
		User.find(function (err, users) {
		  if (err) return next(err);
		  res.json(users);
		});
	});

// Second possibility
router.route('/')
	.get(authenticate, function(req, res, next) {
		User.find(function (err, users) {
		  if (err) return next(err);
		  res.json(users);
		});
	});

// In this example, maybe we want to apply authentication to **ALL** resources (Maybe not a good idea for creating a new user!)
router.all('/api/*', authenticate);
```