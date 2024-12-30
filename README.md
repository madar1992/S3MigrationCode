# S3MigrationCode

# S3 Migration Code

## Overview
The **S3 Migration Code** is a Java-based application designed to efficiently migrate objects between Amazon S3 buckets. This tool is ideal for scenarios where files need to be copied, such as:
- Migrating data to a different AWS region.
- Consolidating data from multiple buckets into one.
- Backing up files in a secondary S3 bucket.

---

## Features
- **Supports Pagination:** Handles large buckets by processing objects in batches.
- **Simple Configuration:** Configure source and destination buckets with ease.
- **Resilient:** Error handling for common AWS S3 issues.
- **AWS SDK Integration:** Built using the AWS SDK for Java.

---

## Prerequisites
1. **Java Environment**:
   - Install [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. **AWS CLI Configuration**:
   - Ensure AWS credentials are set up in `~/.aws/credentials` or environment variables.
   - Example:
     ```plaintext
     [default]
     aws_access_key_id = YOUR_ACCESS_KEY
     aws_secret_access_key = YOUR_SECRET_KEY
     ```
3. **Maven**:
   - Install [Apache Maven](https://maven.apache.org/).

---

## How to Run

1.** Clone this repository:**
   ```bash
   git clone https://github.com/your-username/s3-migration-code.git

**Navigate to the project directory**:

cd s3-migration-code

**Build the project:**

mvn clean install

**Run the application:**

java -jar target/s3-migration-code.jar

**API Usage
Endpoint**
POST /api/s3/copy
**Parameters**
sourceBucket: Name of the source bucket.
destinationBucket: Name of the destination bucket.

**Example Request**
bash
Copy code
curl -X POST "http://localhost:8080/api/s3/copy?sourceBucket=source-bucket-name&destinationBucket=destination-bucket-name"


**Customization**
Update the AWS region in the S3CopyService class to match your source and destination buckets.
Add filters for specific file types or prefixes if needed.
